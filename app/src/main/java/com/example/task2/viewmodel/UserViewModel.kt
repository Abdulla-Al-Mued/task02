package com.example.task2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task2.model.UserData
import com.example.task2.model.UserDataItem
import com.example.task2.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUsers()
        }
    }

    fun getUserDetails(id : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUsersDetails(id)
        }
    }

    val userDetails : LiveData<UserDataItem>
        get() = repository.usersDetails

    val users : LiveData<UserData>
        get() = repository.users

}