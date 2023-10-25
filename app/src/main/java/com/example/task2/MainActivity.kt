package com.example.task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task2.adapter.UserAdapter
import com.example.task2.model.UserDataItem
import com.example.task2.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var userAdapter: UserAdapter
    private lateinit var userList : ArrayList<UserDataItem>
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userList = ArrayList()

        recyclerView = findViewById(R.id.userRecView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(userList, this)
        recyclerView.adapter = userAdapter


        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]


        userViewModel.users.observe(this, Observer {

            val userInfo = it

            userList.clear()
            userList.addAll(userInfo)


            userAdapter.notifyDataSetChanged()

            userInfo.forEach{result ->
                Log.d("User Item", result.name + result.actor)
            }


        })

    }
}