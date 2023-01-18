package com.example.navigationfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListAlbumFragment : Fragment(), View.OnClickListener {

    lateinit var albums: MutableList<Album>
    lateinit var adapter: AlbumAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albums = mutableListOf<Album>()
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))
        albums.add(Album("ACDC", "Nouveau album du groupe mythique"))

        adapter = AlbumAdapter(albums, this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.list_album_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            showAlbumDetail(view.tag as Int)
        }
    }

    fun showAlbumDetail(albumIndex: Int) {
        val album = albums[albumIndex]

        val intent = Intent(MainActivity(), AlbumDetailActivity::class.java)
        intent.putExtra(AlbumDetailActivity.EXTRA_ALBUM, album)
        intent.putExtra(AlbumDetailActivity.EXTRA_ALBUM_INDEX, -1)
        startActivity(intent)


    }

}