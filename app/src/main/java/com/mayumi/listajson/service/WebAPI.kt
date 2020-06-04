package com.mayumi.listajson.service


import com.mayumi.listajson.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface WebAPI {

    @GET("users")
    fun getList(): Call<List<Users>>

}