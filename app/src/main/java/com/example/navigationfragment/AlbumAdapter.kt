package com.example.navigationfragment

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter(val albums: List<Album>, val itemClickListener: OnClickListener)
    : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val cardView = itemView.findViewById(R.id.cardview_item_fragment_list) as CardView
            val titleView = cardView.findViewById(R.id.title) as TextView
            val descritpionView = cardView.findViewById(R.id.description) as TextView
            val imageView = cardView.findViewById(R.id.imageView) as ImageView
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album_list, parent,false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albums[position]
        holder.cardView.setOnClickListener(itemClickListener)
        holder.cardView.tag = position
        holder.titleView.text = album.title
        holder.descritpionView.text = album.description
    }

    override fun getItemCount(): Int {
        return albums.size
    }

}