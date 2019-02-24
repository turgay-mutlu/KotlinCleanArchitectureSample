package com.mutlu.turgay.kotlincleanarchitecturesample.base.network

import com.mutlu.turgay.kotlincleanarchitecturesample.model.Discover
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NetworkService {

    @GET("authentication/guest_session/new")
    fun getNewGuest(): Call<ResponseBody>

    @GET("discover/movie")
    fun discoverMovies(@Query("page") page:Int):Call<Discover>
}