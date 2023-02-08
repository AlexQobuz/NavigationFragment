package com.example.navigationfragment.user

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.R

class UserAdapter(val context: Context):
    RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    private val usersList: MutableList<User> = mutableListOf()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userId: TextView
        var name: TextView
        var username: TextView
        var email: TextView
        // val cardView = itemView.findViewById<CardView>(R.id.cardview_users)

        init {
            userId = itemView.findViewById(R.id.userId)
            name = itemView.findViewById(R.id.name)
            username = itemView.findViewById(R.id.username)
            email = itemView.findViewById(R.id.email)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_users_items, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = usersList[position].id.toString()
        holder.name.text = usersList[position].name
        holder.username.text = usersList[position].username
        holder.email.text = usersList[position].email

        // val user = usersList[position]
        //holder.cardView.setOnClickListener(itemClickListener)
        //holder.cardView.tag = position


    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    fun setItems(items: List<User>) {
        usersList.clear()
        usersList.addAll(items)
        notifyDataSetChanged()
    }

}