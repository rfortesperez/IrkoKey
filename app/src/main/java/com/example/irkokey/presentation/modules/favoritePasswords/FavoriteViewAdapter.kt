package com.example.irkokey.presentation.modules.favoritePasswords

import android.text.Editable
import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.databinding.ItemFavoritePasswordBinding
import com.example.irkokey.domain.models.Password

class FavoriteViewAdapter(private val favoriteList: MutableList<Password>, private val listener: OnFavItemClick, private val encryptionUtil: EncryptionUtil) : RecyclerView.Adapter<FavoriteViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFavoritePasswordBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favoriteList[position], listener, encryptionUtil)
    }

    override fun getItemCount() = favoriteList.size

    fun updatePassword(position: Int, password: Password){
        favoriteList[position] = password
        notifyItemChanged(position)
    }

    class ViewHolder(private val binding: ItemFavoritePasswordBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(password: Password, listener: OnFavItemClick, encryptionUtil: EncryptionUtil) {
            with(binding) {
                tvWebsite.text = password.website
                tvUserName.text = password.userName
                val decryptedPassword = encryptionUtil.decrypt(password.password)
                tvPasswordFav.text = Editable.Factory.getInstance().newEditable(decryptedPassword)
                tvPasswordFav.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

                btnCopyPassword.setOnClickListener { listener.onCopyPasswordClick(adapterPosition) }
                btnRemoveFavorite.setOnClickListener { listener.onRemoveFavoriteClick(adapterPosition) }
            }
        }
    }
}