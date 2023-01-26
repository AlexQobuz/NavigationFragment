package com.example.navigationfragment.magasin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationfragment.R

class ListArticleFragment : Fragment(), View.OnClickListener {

    lateinit var articles : MutableList<Article>
    lateinit var adapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articles = mutableListOf<Article>()
        articles.add(Article("Session JAM avec un Artiste", "par Joe siverri", "par Alice Suize Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet vehicula finibus.Praesent ultricies est enim, "))

        articles.add(Article("Echange avec un entraîneur", "par Alex suro", "article en cours d'écriture"))

        articles.add(Article("Une Jeune artiste à décourvrir", "par Sam Guiro", "Article en cours d'écriture"))

        adapter = ArticleAdapter(articles, this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.list_article_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            Log.i("ArticleDetailActivity", "Click sur un article de la liste")
            showArticleDetail(view.tag as Int)
        }
    }

    private fun showArticleDetail(articleIndex: Int) {
        val article = articles[articleIndex]

        val intent = Intent(requireActivity(), ArticleDetailActivity::class.java)
        intent.putExtra(ArticleDetailActivity.EXTRA_ARTICLE, article)
        intent.putExtra(ArticleDetailActivity.EXTRA_ARTICLE_INDEX, -1)
        startActivity(intent)

    }

}