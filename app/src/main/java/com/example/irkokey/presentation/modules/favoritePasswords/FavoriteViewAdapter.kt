package com.example.irkokey.presentation.modules.favoritePasswords

import android.text.Editable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.irkokey.databinding.ItemFavoritePasswordBinding
import com.example.irkokey.domain.models.Password

class FavoriteViewAdapter(private val favoriteList: List<Password>): RecyclerView.Adapter<FavoriteViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFavoritePasswordBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favoriteList[position])
    }

    override fun getItemCount() = favoriteList.size

    class ViewHolder(private val binding: ItemFavoritePasswordBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(password: Password) {
            with(binding) {
                tvWebsite.text = password.website
                tvUserName.text = password.userName
                tvPassword.text = Editable.Factory.getInstance().newEditable(password.password)
            }
        }
    }
}