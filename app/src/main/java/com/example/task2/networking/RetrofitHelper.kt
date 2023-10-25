package com.example.task2.networking

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitHelper {

    private const val BASE_URL = "https://hp-api.onrender.com/"

    @Singleton
    @Provides
    fun getInstance() : Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun userApi(retrofit: Retrofit) : ApiInterface {

        return retrofit.create(ApiInterface::class.java)
    }


}