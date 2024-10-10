package com.example.irkokey.presentation.modules.passwords

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.irkokey.data.PasswordsList
import com.example.irkokey.databinding.RowPasswordBinding

class PasswordsViewAdapter : RecyclerView.Adapter<PasswordsViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowPasswordBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.website.text = PasswordsList.getPassword()[position].website
        holder.username.text = PasswordsList.getPassword()[position].userName
        holder.password.text = PasswordsList.getPassword()[position].password
    }

    override fun getItemCount(): Int {
        return PasswordsList.getPassword().size
    }

    class ViewHolder(binding: RowPasswordBinding) : RecyclerView.ViewHolder(binding.root) {
        val website: TextView = binding.tvWebsite
        val username: TextView = binding.tvUserName
        val password: TextView = binding.tvPassword
    }
}