package com.example.navigationfragment.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.navigationfragment.R
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory


class UserFragment : Fragment() {

    lateinit var userName: TextView
    lateinit var userAge: TextView
    lateinit var userAddress: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userName.findViewById<TextView>(R.id.username)
        userAge.findViewById<TextView>(R.id.user_age)
        userAddress.findViewById<TextView>(R.id.user_address)

        getUser(User)

    }

    private fun getUser(user: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val userService = retrofit.create(UserService::class.java)
        val result = userService.getUser(user)

        result.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    userName = result.name
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}