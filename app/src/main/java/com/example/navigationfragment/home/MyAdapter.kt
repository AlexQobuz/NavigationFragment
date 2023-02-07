package com.example.navigationfragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.Posts
import com.example.navigationfragment.R

class MyAdapter(val context: Context, val dataList: List<Posts>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userId: TextView
        var title: TextView

        init {
            userId = itemView.findViewById(R.id.userId)
            title = itemView.findViewById(R.id.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = dataList[position].userId.toString()
        holder.title.text = dataList[position].title
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}