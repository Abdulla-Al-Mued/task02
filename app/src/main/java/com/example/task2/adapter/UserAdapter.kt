package com.example.task2.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task2.R
import com.example.task2.UserDetails

import com.example.task2.model.UserDataItem
import de.hdodenhof.circleimageview.CircleImageView

class UserAdapter(private val userList: List<UserDataItem>, private val context : Context) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val currentItem = userList[position]

        holder.email.text = currentItem.name
        holder.itemNameTextView.text = currentItem.actor
        holder.houseName.text = currentItem.house

        Glide.with(context).load(currentItem.image).into(holder.imageView)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, UserDetails::class.java)
            intent.putExtra("userID", currentItem.id)
            context.startActivity(intent)
            //Log.d("User Item", currentItem.id)
        }

    }


    class UserViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val itemNameTextView: TextView = itemView.findViewById(R.id.name)
        val email : TextView = itemView.findViewById(R.id.email)
        val houseName : TextView = itemView.findViewById(R.id.houseName)
        val imageView : CircleImageView = itemView.findViewById(R.id.circularImage)

    }
}