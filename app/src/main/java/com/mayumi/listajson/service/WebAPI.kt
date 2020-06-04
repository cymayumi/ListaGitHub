package com.mayumi.listajson.service


import com.mayumi.listajson.model.Data
import com.mayumi.listajson.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebAPI {

    @GET("users")
    fun getList(): Call<List<Users>>

    @GET("users/{username}")
    fun getData(@Path("username") username : String): Call<Data>

}