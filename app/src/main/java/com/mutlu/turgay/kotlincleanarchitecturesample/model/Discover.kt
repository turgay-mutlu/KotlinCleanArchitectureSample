package com.mutlu.turgay.kotlincleanarchitecturesample.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class Discover (
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_results")
    val totalResults: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val movies: List<Movie>
)