package com.example.irkokey.presentation.modules.favoritePasswords

interface OnFavItemClick {
    fun onCopyPasswordClick(position: Int)
    fun onRemoveFavoriteClick(position: Int)
}