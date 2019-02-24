package com.mutlu.turgay.kotlincleanarchitecturesample.ui.discover

import androidx.databinding.ObservableBoolean
import com.mutlu.turgay.kotlincleanarchitecturesample.base.BaseViewModel
import com.mutlu.turgay.kotlincleanarchitecturesample.model.Discover
import com.mutlu.turgay.kotlincleanarchitecturesample.model.Movie
import com.mutlu.turgay.kotlincleanarchitecturesample.repository.DiscoverRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DiscoverVM: BaseViewModel() {
    val discoverRepository = DiscoverRepository()
    val movieList = ArrayList<Movie>()
    val isLoading = ObservableBoolean(false)
    val isError = ObservableBoolean(false)
    private var currentPage = 0

    init {
        isLoading.set(true)
        addMovies()
    }

    fun addMovies(){
        currentPage++
        discoverRepository.discoverMovies(currentPage,object : Callback<Discover> {
            override fun onFailure(call: Call<Discover>, t: Throwable) {
                isLoading.set(false)
                isError.set(true)
            }

            override fun onResponse(call: Call<Discover>, response: Response<Discover>) {
                isLoading.set(false)
                isError.set(false)
                val discover = response.body()
                movieList.addAll(discover!!.movies)
            }
        })
    }
}