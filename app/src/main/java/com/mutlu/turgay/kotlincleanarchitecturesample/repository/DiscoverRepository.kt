package com.mutlu.turgay.kotlincleanarchitecturesample.repository

import com.mutlu.turgay.kotlincleanarchitecturesample.base.network.Api
import com.mutlu.turgay.kotlincleanarchitecturesample.model.Discover
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class DiscoverRepository {
    private val api = Api

    fun discoverMovies(page: Int, callback: Callback<Discover>){
        api.discoverMovies(page, callback)
    }
}