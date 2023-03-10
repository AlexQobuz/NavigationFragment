package com.example.navigationfragment.album

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.navigationfragment.R

class AlbumDetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        val EXTRA_ALBUM = "album"
        val EXTRA_ALBUM_INDEX = "albumIndex"
    }

    lateinit var album: Album
    var albumIndex: Int = -1

    lateinit var titleView: TextView
    lateinit var desciptionView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_detail)

        // je récupère ma toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar_album_detail)
        // J'affiche ma toolbar
        setSupportActionBar(toolbar)
        // J'affiche le bouton de retour
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val album = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Album>(EXTRA_ALBUM, Album::class.java)
        } else {
            intent.getParcelableExtra<Album>(EXTRA_ALBUM)
        }

        albumIndex = intent.getIntExtra(EXTRA_ALBUM_INDEX, -1)

        titleView = findViewById(R.id.title_detail_album) as TextView
        desciptionView = findViewById(R.id.description_album) as TextView

        titleView.text = album!!.title
        desciptionView.text = album.description

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}