package com.example.task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.task2.databinding.ActivityUserDetailsBinding
import com.example.task2.model.UserDataItem
import com.example.task2.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetails : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var binding : ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userId: String? = intent.getStringExtra("userID").toString()

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.userDetails.observe(this, Observer {

            setUserDetails(it)

        })

        if (userId != null) {
            userViewModel.getUserDetails(userId)
        }

    }

    private fun setUserDetails(userDataItem: UserDataItem) {

        Glide.with(this).load(userDataItem.image).into(binding.circularImage)

        binding.name.text = userDataItem.name
//        binding.alterName.text = userDataItem.alternate_names[0] + "\n" + userDataItem.alternate_names[1]
        binding.species.text = userDataItem.species
        binding.gender.text = userDataItem.gender
        binding.dob.text = userDataItem.dateOfBirth
        binding.houseName.text = userDataItem.house
    }
}