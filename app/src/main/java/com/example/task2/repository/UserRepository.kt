package com.example.task2.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.task2.model.UserData
import com.example.task2.model.UserDataItem
import com.example.task2.networking.ApiInterface
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiInterface: ApiInterface) {

    private val usersLiveData : MutableLiveData<UserData> = MutableLiveData()
    private val usersDetailsLiveData : MutableLiveData<UserDataItem> = MutableLiveData()

    val users : LiveData<UserData>
        get() = usersLiveData


    suspend fun getUsers(){
        val result = apiInterface.getUsers()

        if (result.body() != null){
            usersLiveData.postValue(result.body())
        }

    }

    val usersDetails : LiveData<UserDataItem>
        get() = usersDetailsLiveData


    suspend fun getUsersDetails(id : String){
        val result = apiInterface.getUserDetails(id)


        if (result.body() != null){
            usersDetailsLiveData.postValue(result.body()!![0])
        }
        else{
            Log.d("API", "NULL")
        }

    }

}