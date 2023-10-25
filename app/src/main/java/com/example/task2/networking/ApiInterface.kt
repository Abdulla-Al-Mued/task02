package com.example.task2.networking

import com.example.task2.model.UserData
import com.example.task2.model.UserDataItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/characters")
    suspend fun getUsers() : Response<UserData>

    @GET("api/character/{id}")
    suspend fun getUserDetails(@Path("id") id: String) : Response<List<UserDataItem>>

}