package com.example.irkokey.presentation.modules.passwords

import android.annotation.SuppressLint
import android.text.Editable
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.databinding.RowPasswordBinding
import com.example.irkokey.domain.models.Password
import com.example.irkokey.domain.models.WebsiteIcon
import com.example.irkokey.domain.models.WebsiteIcons

/**
 * Sealed class representing different actions that can be performed on a password.
 */
sealed class PasswordAction {
    data class Delete(val password: Password) : PasswordAction()
    data class Edit(val password: Password) : PasswordAction()
    data class AddFavorite(val password: Password) : PasswordAction()
    data class CopyPassword(val password: Password) : PasswordAction()
}

/**
 * Adapter class for managing password items in a RecyclerView.
 *
 * @param passwordList The list of passwords to be displayed.
 * @param actionListener The listener for handling password actions.
 * @param encryptionUtil The utility class for encryption and decryption.
 */
class PasswordsViewAdapter(
    private var passwordList: MutableList<Password>,
    private val actionListener: (PasswordAction) -> Unit,
    private val encryptionUtil: EncryptionUtil
) : RecyclerView.Adapter<PasswordsViewAdapter.ViewHolder>() {

    private var originalList: MutableList<Password> = passwordList.toMutableList()

    /**
     * Creates a new ViewHolder for the given parent view.
     *
     * @param parent The parent view.
     * @param viewType The type of the view.
     * @return The created ViewHolder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowPasswordBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    /**
     * Binds the data to the ViewHolder at the given position.
     *
     * @param holder The ViewHolder to bind data to.
     * @param position The position of the item in the list.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(passwordList[position], actionListener, encryptionUtil)
    }

    /**
     * Returns the total number of items in the list.
     *
     * @return The total number of items.
     */
    override fun getItemCount() = passwordList.size

    /**
     * Updates the password at the given position.
     *
     * @param position The position of the password to be updated.
     * @param password The updated password.
     */
    fun updatePassword(position: Int, password: Password) {
        passwordList[position] = password
        notifyItemChanged(position)
    }

    /**
     * Filters the list of passwords based on the given filtered list.
     *
     * @param filteredList The filtered list of passwords.
     */
    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: MutableList<Password>) {
        if (filteredList.isEmpty()) {
            this.passwordList.clear()
            this.passwordList.addAll(originalList)
        } else {
            this.passwordList.clear()
            this.passwordList.addAll(filteredList)
        }
        notifyDataSetChanged()
    }

    /**
     * Updates the original list of passwords.
     *
     * @param newList The new list of passwords.
     */
    fun updateOriginalList(newList: MutableList<Password>) {
        originalList = newList.toMutableList()
    }

    /**
     * Returns the original list of passwords.
     *
     * @return The original list of passwords.
     */
    fun getOriginalList(): MutableList<Password> {
        return originalList
    }

    /**
     * ViewHolder class for binding password data to the view.
     *
     * @param binding The binding for the password row layout.
     */
    class ViewHolder(private val binding: RowPasswordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Binds the password data to the view.
         *
         * @param password The password to be displayed.
         * @param actionListener The listener for handling password actions.
         * @param encryptionUtil The utility class for encryption and decryption.
         */
        fun bind(password: Password,actionListener: (PasswordAction) -> Unit, encryptionUtil: EncryptionUtil) =
            with(binding) {
                tvWebsite.text = password.website
                tvUserName.text = password.userName
                val decryptedPassword = encryptionUtil.decrypt(password.password)
                tvPassword.text = Editable.Factory.getInstance().newEditable(decryptedPassword)
                tvPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

                val matchingIcon: WebsiteIcon? =
                    WebsiteIcons.icons.find { it.websiteName.lowercase() == password.website.lowercase() }
                if (matchingIcon != null) {
                    tvWebsite.setCompoundDrawablesWithIntrinsicBounds(
                        ContextCompat.getDrawable(itemView.context, matchingIcon.iconResId),
                        null,
                        null,
                        null
                    )
                }

                // Hide password
                ivDown.setOnClickListener {
                    it.visibility = View.GONE
                    ivUp.visibility = View.VISIBLE
                    llHide.visibility = View.VISIBLE
                }
                // Show password
                ivUp.setOnClickListener {
                    it.visibility = View.GONE
                    ivDown.visibility = View.VISIBLE
                    llHide.visibility = View.GONE
                }

                btnDelete.setOnClickListener { actionListener(PasswordAction.Delete(password)) }
                btnEditPassword.setOnClickListener { actionListener(PasswordAction.Edit(password)) }
                btnAddFavorite.setOnClickListener {
                    actionListener(
                        PasswordAction.AddFavorite(
                            password
                        )
                    )
                }
                btnCopyPassword.setOnClickListener {
                    actionListener(
                        PasswordAction.CopyPassword(
                            password
                        )
                    )
                }
            }
    }
}