package com.example.irkokey.presentation.modules.passwords

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.irkokey.databinding.RowPasswordBinding
import com.example.irkokey.domain.models.Password

class PasswordsViewAdapter(private val passwords: List<Password>) : RecyclerView.Adapter<PasswordsViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowPasswordBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(passwords[position])
    }

    override fun getItemCount() = passwords.size

    class ViewHolder(private val binding: RowPasswordBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind (password: Password) {
           with(binding) {
               tvWebsite.text = password.website
               tvUserName.text = password.userName
               tvPassword.text = password.password
           }
       }
    }
}