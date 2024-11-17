package com.example.irkokey.common.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.irkokey.domain.models.Password

/**
 * This class is used to compare two lists of Password objects and check if they are the same.
 * @param oldList The old list of Password objects.
 * @param newList The new list of Password objects.
 */
class PasswordDiffCallback(private val oldList: List<Password>, private val newList: List<Password>) : DiffUtil.Callback() {
    /**
     * Returns the size of the old list.
     * @return The size of the old list.
     */
    override fun getOldListSize() = oldList.size
    /**
     * Returns the size of the new list.
     * @return The size of the new list.
     */
    override fun getNewListSize() = newList.size    // Check if the items are the same
    /**
     * Checks if the items at the given positions in the old and new lists are the same.
     * @param oldItemPosition The position of the item in the old list.
     * @param newItemPosition The position of the item in the new list.
     * @return True if the items are the same, false otherwise.
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }
    /**
     * Checks if the contents of the items at the given positions in the old and new lists are the same.
     * @param oldItemPosition The position of the item in the old list.
     * @param newItemPosition The position of the item in the new list.
     * @return True if the contents of the items are the same, false otherwise.
     */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}