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

sealed class PasswordAction {
    data class RemoveFavorite(val password: Password) : PasswordAction()
    data class CopyPassword(val password: Password) : PasswordAction()
}


class FavoriteViewAdapter(
    private var favoriteList: MutableList<Password>,
    private val actionListener: (PasswordAction) -> Unit,
    private val encryptionUtil: EncryptionUtil
) : RecyclerView.Adapter<FavoriteViewAdapter.ViewHolder>() {

    private var originalList: MutableList<Password> = favoriteList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFavoritePasswordBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favoriteList[position], actionListener, encryptionUtil)
    }

    override fun getItemCount() = favoriteList.size

    fun updatePassword(position: Int, password: Password) {
        favoriteList[position] = password
        notifyItemChanged(position)
    }

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

    fun updateOriginalList(newList: MutableList<Password>) {
        originalList = newList.toMutableList()
    }

    fun getOriginalList(): MutableList<Password> {
        return originalList
    }

    class ViewHolder(private val binding: ItemFavoritePasswordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(password: Password, actionListener: (PasswordAction) -> Unit, encryptionUtil: EncryptionUtil) {
            with(binding) {
                tvWebsite.text = password.website
                tvUserName.text = password.userName
                val decryptedPassword = encryptionUtil.decrypt(password.password)
                tvPasswordFav.text = Editable.Factory.getInstance().newEditable(decryptedPassword)
                tvPasswordFav.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

                val matchingIcon: WebsiteIcon? = WebsiteIcons.icons.find{ it.websiteName.lowercase() == password.website.lowercase() }
                if(matchingIcon != null){
                    tvWebsite.setCompoundDrawablesWithIntrinsicBounds(
                        ContextCompat.getDrawable(itemView.context, matchingIcon.iconResId),
                        null,
                        null,
                        null
                    )
                }

                ivDown.setOnClickListener {
                    it.visibility = View.GONE
                    ivUp.visibility = View.VISIBLE
                    llHide.visibility = View.VISIBLE
                }

                ivUp.setOnClickListener {
                    it.visibility = View.GONE
                    ivDown.visibility = View.VISIBLE
                    llHide.visibility = View.GONE
                }

                btnCopyPassword.setOnClickListener { actionListener(PasswordAction.CopyPassword(password)) }
                btnRemoveFavorite.setOnClickListener { actionListener(PasswordAction.RemoveFavorite(password)) }
            }
        }
    }
}