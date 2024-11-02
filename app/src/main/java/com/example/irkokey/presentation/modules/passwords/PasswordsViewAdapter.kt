package com.example.irkokey.presentation.modules.passwords

import android.annotation.SuppressLint
import android.text.Editable
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.irkokey.common.utils.EncryptionUtil
import com.example.irkokey.databinding.RowPasswordBinding
import com.example.irkokey.domain.models.Password
import com.example.irkokey.domain.models.WebsiteIcon
import com.example.irkokey.domain.models.WebsiteIcons

class PasswordsViewAdapter(
    private var passwordList: MutableList<Password>,
    private val listener: OnPassItemClick,
    private val encryptionUtil: EncryptionUtil
) : RecyclerView.Adapter<PasswordsViewAdapter.ViewHolder>() {


    private var originalList: MutableList<Password> = passwordList.toMutableList()

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


    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: MutableList<Password>) {
        if (filteredList.isEmpty()) {
            this.passwordList.clear()
            this.passwordList.addAll(originalList)
        } else {
            this.passwordList.clear()
            this.passwordList.addAll(filteredList)
        }
        notifyDataSetChanged()
    }

    fun updateOriginalList(newList: MutableList<Password>) {
        originalList = newList.toMutableList()
    }

    fun getOriginalList(): MutableList<Password> {
        return originalList
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

                val matchingIcon: WebsiteIcon? = WebsiteIcons.icons.find{ it.websiteName.lowercase() == password.website.lowercase() }
                if(matchingIcon != null){
                    tvWebsite.setCompoundDrawablesWithIntrinsicBounds(
                        ContextCompat.getDrawable(itemView.context, matchingIcon.iconResId),
                        null,
                        null,
                        null
                    )
                }

                // show password and buttons for each password
                ivDown.setOnClickListener{
                    it.visibility = View.GONE
                    ivUp.visibility = View.VISIBLE
                    llHide.visibility = View.VISIBLE
                }

                // hide password and buttons for each password
                ivUp.setOnClickListener{
                    it.visibility = View.GONE
                    ivDown.visibility = View.VISIBLE
                    llHide.visibility = View.GONE
                }


                btnDelete.setOnClickListener { listener.onDeleteClick(adapterPosition) }
                btnEditPassword.setOnClickListener { listener.onEditClick(adapterPosition) }
                btnAddFavorite.setOnClickListener { listener.onAddFavoriteClick(adapterPosition) }
                btnCopyPassword.setOnClickListener { listener.onCopyPasswordClick(adapterPosition) }
            }
    }
}