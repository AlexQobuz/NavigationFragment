package com.example.navigationfragment.posts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.Post
import com.example.navigationfragment.R

class PostsAdapter(val context: Context):
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    private val postsList: MutableList<Post> = mutableListOf()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var userIdInPost: TextView
        var title: TextView

        init {
            userIdInPost = itemView.findViewById(R.id.postId)
            title = itemView.findViewById(R.id.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_posts_items, parent, false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userIdInPost.text = postsList[position].userIdInPost.toString()
        holder.title.text = postsList[position].title
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    fun setItems(items: List<Post>) {
        postsList.clear()
        postsList.addAll(items)
        notifyDataSetChanged()
    }

}