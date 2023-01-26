package com.example.navigationfragment.magasin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.R

class ArticleAdapter(val articles: List<Article>, val itemClickListener: View.OnClickListener)
    : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val constraintLayout = itemView.findViewById(R.id.constrainlayout_item_fragment_list) as ConstraintLayout
        val titleView = constraintLayout.findViewById<TextView>(R.id.title_item_article_list)
        val subtitleView = constraintLayout.findViewById<TextView>(R.id.subtitle_item_article_list)
        val textView = constraintLayout.findViewById<TextView>(R.id.text_item_article_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article_list, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.constraintLayout.setOnClickListener(itemClickListener)
        holder.constraintLayout.tag = position
        holder.titleView.text = article.title
        holder.subtitleView.text = article.subtitle
        holder.textView.text = article.text

        holder.itemView.setOnClickListener(itemClickListener)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

}