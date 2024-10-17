package com.example.irkokey.common.utils


import androidx.recyclerview.widget.DiffUtil
import com.example.irkokey.domain.models.Password

class PasswordDiffCallback(private val oldList: List<Password>, private val newList: List<Password>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}