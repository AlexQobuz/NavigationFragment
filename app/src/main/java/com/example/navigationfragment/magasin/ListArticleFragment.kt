package com.example.navigationfragment.magasin

import android.content.Intent
import android.os.Bundle
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
        articles.add(Article("Session JAM avec un Artiste", "par Joe siverri", "\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet vehicula finibus. Praesent ultricies est enim, non pellentesque odio eleifend ac. Donec vitae molestie libero. Vestibulum gravida tellus justo, eget venenatis sapien maximus in. Phasellus et eros sit amet ante congue pellentesque. Etiam laoreet maximus dignissim. Phasellus eget quam imperdiet, pretium nulla sit amet, porttitor eros. Vivamus egestas, metus sed finibus interdum, lectus risus condimentum ex, eu convallis lectus diam id lacus. Pellentesque cursus nunc sit amet vulputate pharetra.\n" +
                "\n" +
                "Praesent et gravida risus. Cras magna mauris, interdum a efficitur et, vulputate tempor dui. Cras tempus fringilla ligula eu congue. Proin quam odio, fermentum ut est luctus, faucibus rutrum ex. Vestibulum bibendum feugiat nisl vitae vestibulum. Proin tincidunt egestas purus, id volutpat orci luctus sed. Nam fermentum tincidunt libero convallis vulputate. Donec vel tincidunt enim. Phasellus consequat sagittis ex.\n" +
                "\n" +
                "Etiam maximus molestie nulla vitae tincidunt. In gravida ex urna, sed tincidunt nulla sagittis id. Morbi nec lacinia odio. Cras vel augue et nibh hendrerit tincidunt semper vel ligula. Proin dapibus ligula sed diam mollis, pretium blandit elit sagittis. Curabitur eu hendrerit nunc, et auctor magna. Nunc elementum ante scelerisque ornare suscipit. Nam tincidunt consectetur metus, nec ullamcorper mauris tempor sit amet. Nulla in pharetra ligula, vel tristique sapien. Mauris id tincidunt enim, sed porttitor est. Pellentesque gravida vel lacus sed posuere. Suspendisse volutpat libero nec neque facilisis dignissim. Morbi non egestas velit, ac volutpat ipsum. "))

        articles.add(Article("Echange avec un entraîneur", "par Alex suro", "\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet vehicula finibus. Praesent ultricies est enim, non pellentesque odio eleifend ac. Donec vitae molestie libero. Vestibulum gravida tellus justo, eget venenatis sapien maximus in. Phasellus et eros sit amet ante congue pellentesque. Etiam laoreet maximus dignissim. Phasellus eget quam imperdiet, pretium nulla sit amet, porttitor eros. Vivamus egestas, metus sed finibus interdum, lectus risus condimentum ex, eu convallis lectus diam id lacus. Pellentesque cursus nunc sit amet vulputate pharetra.\n" +
                "\n" +
                "Praesent et gravida risus. Cras magna mauris, interdum a efficitur et, vulputate tempor dui. Cras tempus fringilla ligula eu congue. Proin quam odio, fermentum ut est luctus, faucibus rutrum ex. Vestibulum bibendum feugiat nisl vitae vestibulum. Proin tincidunt egestas purus, id volutpat orci luctus sed. Nam fermentum tincidunt libero convallis vulputate. Donec vel tincidunt enim. Phasellus consequat sagittis ex.\n" +
                "\n" +
                "Etiam maximus molestie nulla vitae tincidunt. In gravida ex urna, sed tincidunt nulla sagittis id. Morbi nec lacinia odio. Cras vel augue et nibh hendrerit tincidunt semper vel ligula. Proin dapibus ligula sed diam mollis, pretium blandit elit sagittis. Curabitur eu hendrerit nunc, et auctor magna. Nunc elementum ante scelerisque ornare suscipit. Nam tincidunt consectetur metus, nec ullamcorper mauris tempor sit amet. Nulla in pharetra ligula, vel tristique sapien. Mauris id tincidunt enim, sed porttitor est. Pellentesque gravida vel lacus sed posuere. Suspendisse volutpat libero nec neque facilisis dignissim. Morbi non egestas velit, ac volutpat ipsum. "))

        articles.add(Article("Une Jeune artiste à décourvrir", "par Sam Guiro", "\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet vehicula finibus. Praesent ultricies est enim, non pellentesque odio eleifend ac. Donec vitae molestie libero. Vestibulum gravida tellus justo, eget venenatis sapien maximus in. Phasellus et eros sit amet ante congue pellentesque. Etiam laoreet maximus dignissim. Phasellus eget quam imperdiet, pretium nulla sit amet, porttitor eros. Vivamus egestas, metus sed finibus interdum, lectus risus condimentum ex, eu convallis lectus diam id lacus. Pellentesque cursus nunc sit amet vulputate pharetra.\n" +
                "\n" +
                "Praesent et gravida risus. Cras magna mauris, interdum a efficitur et, vulputate tempor dui. Cras tempus fringilla ligula eu congue. Proin quam odio, fermentum ut est luctus, faucibus rutrum ex. Vestibulum bibendum feugiat nisl vitae vestibulum. Proin tincidunt egestas purus, id volutpat orci luctus sed. Nam fermentum tincidunt libero convallis vulputate. Donec vel tincidunt enim. Phasellus consequat sagittis ex.\n" +
                "\n" +
                "Etiam maximus molestie nulla vitae tincidunt. In gravida ex urna, sed tincidunt nulla sagittis id. Morbi nec lacinia odio. Cras vel augue et nibh hendrerit tincidunt semper vel ligula. Proin dapibus ligula sed diam mollis, pretium blandit elit sagittis. Curabitur eu hendrerit nunc, et auctor magna. Nunc elementum ante scelerisque ornare suscipit. Nam tincidunt consectetur metus, nec ullamcorper mauris tempor sit amet. Nulla in pharetra ligula, vel tristique sapien. Mauris id tincidunt enim, sed porttitor est. Pellentesque gravida vel lacus sed posuere. Suspendisse volutpat libero nec neque facilisis dignissim. Morbi non egestas velit, ac volutpat ipsum. "))

        adapter = ArticleAdapter(articles, this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.list_album_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

    }

    override fun onClick(view: View) {
        if (view.tag != null) {
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