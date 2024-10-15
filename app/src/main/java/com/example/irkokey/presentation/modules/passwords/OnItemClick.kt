package com.example.irkokey.presentation.modules.passwords

interface OnItemClick {
    fun onDeleteClick(position: Int)
    fun onEditClick(position: Int)
    fun onAddFavoriteClick(position: Int)
    fun onCopyPasswordClick(position: Int)
}