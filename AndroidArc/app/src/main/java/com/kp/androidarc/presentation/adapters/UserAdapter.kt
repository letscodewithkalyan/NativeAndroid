package com.kp.androidarc.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kp.androidarc.data.models.UserDataModel
import com.kp.androidarc.databinding.ListUserBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var usersData:List<UserDataModel>  = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): UserViewHolder {
        var binding = ListUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int,
    ) {
       var currentItem = usersData[position]
       currentItem?.let {
           holder.bind(it)
       }
    }

    override fun getItemCount(): Int {
        return usersData.size
    }

    fun updateList(data: List<UserDataModel>){
        usersData = data
        notifyDataSetChanged()
    }

    //You should keep the bind() method logic inside the ViewHolder class, and call it from onBindViewHolder() in your Adapter.
    //This is the clean and recommended approach.
    inner class UserViewHolder(private val userBinding: ListUserBinding) : RecyclerView.ViewHolder(userBinding.root) {
        fun bind(userData : UserDataModel){
            userBinding.nameTextView.text = userData.username
            userBinding.emailTextView.text = userData.email
        }
    }
}