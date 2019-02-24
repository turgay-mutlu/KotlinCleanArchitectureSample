package com.mutlu.turgay.kotlincleanarchitecturesample.base.network

import com.mutlu.turgay.kotlincleanarchitecturesample.BuildConfig
import com.mutlu.turgay.kotlincleanarchitecturesample.model.Discover
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


object Api {
    private val baseUrl = "https://api.themoviedb.org/3/"
    private val apiKey= "68e5dc11545a5567166e32c5c0cd6d82"
    private var service: NetworkService

    init {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val clientBuilder = OkHttpClient.Builder()
            .addInterceptor {
                val originalRequest = it.request()
                val originalUrl = originalRequest.url()

                val url = originalUrl.newBuilder().addQueryParameter("api_key", apiKey).build()
                val requestBuilder = originalRequest.newBuilder().url(url)


                it.proceed(requestBuilder.build())
            }
        if(BuildConfig.DEBUG){
            clientBuilder.addNetworkInterceptor(loggingInterceptor)
        }

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(clientBuilder.build())
            .build()

        service = retrofit.create(NetworkService::class.java)
    }

    fun getNewGuest(callback:Callback<ResponseBody>){
        sendRequest(service.getNewGuest(),callback)
    }

    fun discoverMovies(page:Int, callback: Callback<Discover>){
        sendRequest(service.discoverMovies(page),callback)
    }

    private fun <R> sendRequest(call: Call<R>, requestCallback: Callback<R>) {
        call.enqueue(requestCallback)
    }
}