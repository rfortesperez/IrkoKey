package com.example.irkokey.data

import com.example.irkokey.domain.models.Password


object PasswordsList {

    fun getPassword(): List<Password> {

        val password1 = Password("Facebook", "user1", "password1")
        val password2 = Password("Instagram", "user2", "password2")
        val password3 = Password("Twitter", "user3", "password3")
        val password4 = Password("LinkedIn", "user4", "password4")
        val password5 = Password("Snapchat", "user5", "password5")
        val password6 = Password("TikTok", "user6", "password6")
        val password7 = Password("Pinterest", "user7", "password7")
        val password8 = Password("Reddit", "user8", "password8")
        val password9 = Password("Tumblr", "user9", "password9")
        val password10 = Password("Telegram", "user10", "password10")

        val itemList: ArrayList<Password> = ArrayList()

        itemList.add(password1)
        itemList.add(password2)
        itemList.add(password3)
        itemList.add(password4)
        itemList.add(password5)
        itemList.add(password6)
        itemList.add(password7)
        itemList.add(password8)
        itemList.add(password9)
        itemList.add(password10)

        return itemList
    }
}