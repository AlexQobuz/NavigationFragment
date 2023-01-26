package com.example.navigationfragment.magasin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.navigationfragment.R

class ArticleDetailActivity : AppCompatActivity() {

    companion object{
        val EXTRA_ARTICLE = "article"
        val EXTRA_ARTICLE_INDEX = "articleIndex"
    }

    lateinit var article: Article
    var articleIndex = -1

    lateinit var titleView: TextView
    lateinit var subtitleView: TextView
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        val article =  if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Article>(EXTRA_ARTICLE, Article::class.java)
        } else {
            intent.getParcelableExtra<Article>(EXTRA_ARTICLE)
        }

        articleIndex = intent.getIntExtra(EXTRA_ARTICLE_INDEX, -1)

        titleView = findViewById<TextView>(R.id.title_article_detail_activity)
        subtitleView = findViewById<TextView>(R.id.subtitle_article_detail_activity)
        textView = findViewById<TextView>(R.id.text_article_detail_activity)

        titleView.text = article!!.text
        subtitleView.text = article.text
        textView.text = article.text

    }

}