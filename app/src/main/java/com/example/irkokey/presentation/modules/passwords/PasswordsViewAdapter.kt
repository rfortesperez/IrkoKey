package com.example.irkokey.presentation.modules.passwords

import android.text.Editable
import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.databinding.RowPasswordBinding
import com.example.irkokey.domain.models.Password

class PasswordsViewAdapter(
    private var passwordList: MutableList<Password>,
    private val listener: OnPassItemClick,
    private val encryptionUtil: EncryptionUtil
) : RecyclerView.Adapter<PasswordsViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowPasswordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(passwordList[position], listener, encryptionUtil)
    }

    override fun getItemCount() = passwordList.size

    fun updatePassword(position: Int, password: Password) {
        passwordList[position] = password
        notifyItemChanged(position)
    }

    fun filterList(filteredList: MutableList<Password>) {
        this.passwordList = filteredList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: RowPasswordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(password: Password, listener: OnPassItemClick, encryptionUtil: EncryptionUtil) =
            with(binding) {
                tvWebsite.text = password.website
                tvUserName.text = password.userName
                val decryptedPassword = encryptionUtil.decrypt(password.password)
                tvPassword.text = Editable.Factory.getInstance().newEditable(decryptedPassword)
                tvPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

                btnDelete.setOnClickListener { listener.onDeleteClick(adapterPosition) }
                btnEditPassword.setOnClickListener { listener.onEditClick(adapterPosition) }
                btnAddFavorite.setOnClickListener { listener.onAddFavoriteClick(adapterPosition) }
                btnCopyPassword.setOnClickListener { listener.onCopyPasswordClick(adapterPosition) }
            }
    }
}