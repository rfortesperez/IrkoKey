package com.example.irkokey.presentation.modules.favoritePasswords

import android.annotation.SuppressLint
import android.text.Editable
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.databinding.ItemFavoritePasswordBinding
import com.example.irkokey.domain.models.Password
import com.example.irkokey.domain.models.WebsiteIcon
import com.example.irkokey.domain.models.WebsiteIcons


/**
 * Sealed class representing different actions that can be performed on a password.
 */
sealed class PasswordAction {
    data class RemoveFavorite(val password: Password) : PasswordAction()
    data class CopyPassword(val password: Password) : PasswordAction()
}


/**
 * Adapter class for displaying a list of favorite passwords in a RecyclerView.
 * @param favoriteList The list of favorite passwords.
 * @param actionListener The listener for handling password actions.
 * @param encryptionUtil The utility for encrypting and decrypting passwords.
 */
class FavoriteViewAdapter(
    private var favoriteList: MutableList<Password>,
    private val actionListener: (PasswordAction) -> Unit,
    private val encryptionUtil: EncryptionUtil
) : RecyclerView.Adapter<FavoriteViewAdapter.ViewHolder>() {

    private var originalList: MutableList<Password> = favoriteList.toMutableList()

    /**
     * Creates a new ViewHolder for the RecyclerView.
     * @param parent The parent ViewGroup.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFavoritePasswordBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }
    /**
     * Binds the data to the ViewHolder.
     * @param holder The ViewHolder.
     * @param position The position of the item in the list.
     */

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favoriteList[position], actionListener, encryptionUtil)
    }

    /**
     * Returns the total number of items in the list.
     * @return The total number of items.
     */
    override fun getItemCount() = favoriteList.size

    /**
     * Updates the password at the specified position.
     * @param position The position of the password.
     * @param password The new password.
     */
    fun updatePassword(position: Int, password: Password) {
        favoriteList[position] = password
        notifyItemChanged(position)
    }

    /**
     * Filters the list of passwords based on the search query.
     * @param filteredList The filtered list of passwords.
     */
    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: MutableList<Password>) {
        if (filteredList.isEmpty()) {
            this.favoriteList.clear()
            this.favoriteList.addAll(originalList)
        } else {
            this.favoriteList.clear()
            this.favoriteList.addAll(filteredList)
        }
        notifyDataSetChanged()
    }

    /**
     * Updates the original list of passwords.
     * @param newList The new list of passwords.
     */
    fun updateOriginalList(newList: MutableList<Password>) {
        originalList = newList.toMutableList()
    }

    /**
     * Returns the original list of passwords.
     * @return The original list of passwords.
     */
    fun getOriginalList(): MutableList<Password> {
        return originalList
    }

    /**
     * ViewHolder class for displaying a password item.
     * @param binding The binding for the password item layout.
     */
    class ViewHolder(private val binding: ItemFavoritePasswordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        /**
         * Binds the password data to the ViewHolder.
         * @param password The password data.
         * @param actionListener The listener for handling password actions.
         * @param encryptionUtil The utility for encrypting and decrypting passwords.
         */
        fun bind(password: Password, actionListener: (PasswordAction) -> Unit, encryptionUtil: EncryptionUtil) {
            with(binding) {
                tvWebsite.text = password.website
                tvUserName.text = password.userName

                // Decrypt the password and display it in the password field
                val decryptedPassword = encryptionUtil.decrypt(password.password)

                tvPasswordFav.text = Editable.Factory.getInstance().newEditable(decryptedPassword)
                tvPasswordFav.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

                // Set the icon for the website
                val matchingIcon: WebsiteIcon? = WebsiteIcons.icons.find{ it.websiteName.lowercase() == password.website.lowercase() }
                if(matchingIcon != null){
                    tvWebsite.setCompoundDrawablesWithIntrinsicBounds(
                        ContextCompat.getDrawable(itemView.context, matchingIcon.iconResId),
                        null,
                        null,
                        null
                    )
                }

                // Set the visibility of the password
                ivDown.setOnClickListener {
                    it.visibility = View.GONE
                    ivUp.visibility = View.VISIBLE
                    llHide.visibility = View.VISIBLE
                }

                // Hide the password
                ivUp.setOnClickListener {
                    it.visibility = View.GONE
                    ivDown.visibility = View.VISIBLE
                    llHide.visibility = View.GONE
                }

                // Set the click listeners for the buttons
                btnCopyPassword.setOnClickListener { actionListener(PasswordAction.CopyPassword(password)) }
                btnRemoveFavorite.setOnClickListener { actionListener(PasswordAction.RemoveFavorite(password)) }
            }
        }
    }
}