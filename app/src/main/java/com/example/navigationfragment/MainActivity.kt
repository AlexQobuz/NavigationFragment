package com.example.navigationfragment

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.navigationfragment.home.HomeFragment
import com.example.navigationfragment.posts.PostsFragment
import com.example.navigationfragment.user.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    /**lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerviewUsers: RecyclerView*/
    // Je récupère BottomNavigationView
    lateinit var bottomNav : BottomNavigationView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())
        bottomNav = findViewById(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.posts -> {
                    loadFragment(PostsFragment())
                    true
                }
                R.id.users -> {
                    loadFragment(UserFragment())
                    true
                }
                else -> {
                    loadFragment(HomeFragment())
                    true
                }
            }
        }

    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_fragment, fragment)
        transaction.addToBackStack(PostsFragment().toString())
        transaction.commit()
    }


}




