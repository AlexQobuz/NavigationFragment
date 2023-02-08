package com.example.navigationfragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.R

class PhotosAdapter(val context: Context, val photosList: List<Photos>):
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photoId: TextView
        var title: TextView
        var url: TextView

        init {
            photoId = itemView.findViewById(R.id.photoId)
            title = itemView.findViewById(R.id.photoTitle)
            url = itemView.findViewById(R.id.photoUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_photos_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.photoId.text = photosList[position].id.toString()
        holder.title.text = photosList[position].title
        holder.url.text = photosList[position].url
    }

    override fun getItemCount(): Int {
        return photosList.size
    }



}