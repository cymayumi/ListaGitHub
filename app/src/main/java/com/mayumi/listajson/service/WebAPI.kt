package com.mayumi.listajson.service

import com.mayumi.listajson.model.Star
import retrofit2.Call
import retrofit2.http.GET

interface WebAPI {

    @GET("repositories")
    fun getList(): Call<List<Star>>

}