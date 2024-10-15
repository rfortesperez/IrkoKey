package com.example.irkokey.presentation.modules.passwords

import android.text.Editable
import android.text.InputType
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.irkokey.databinding.RowPasswordBinding
import com.example.irkokey.domain.models.Password


class PasswordsViewAdapter(private val passwordList: MutableList<Password>, private val listener: OnItemClick) : RecyclerView.Adapter<PasswordsViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowPasswordBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(passwordList[position], listener)
    }

    override fun getItemCount() = passwordList.size

    fun updatePassword(position: Int, password: Password){
        passwordList[position] = password
        notifyItemChanged(position)
    }

    class ViewHolder(private val binding: RowPasswordBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(password: Password, listener: OnItemClick) = with(binding){
            tvWebsite.text = password.website
            tvUserName.text = password.userName
            tvPassword.text = Editable.Factory.getInstance().newEditable(password.password)
            tvPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD


            btnDelete.setOnClickListener { listener.onDeleteClick(adapterPosition) }
            btnEditPassword.setOnClickListener { listener.onEditClick(adapterPosition) }
            btnAddFavorite.setOnClickListener { listener.onAddFavoriteClick(adapterPosition) }
            btnCopyPassword.setOnClickListener { listener.onCopyPasswordClick(adapterPosition) }
        }
    }
}