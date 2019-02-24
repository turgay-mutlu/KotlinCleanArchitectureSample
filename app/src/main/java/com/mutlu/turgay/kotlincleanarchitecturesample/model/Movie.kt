package com.mutlu.turgay.kotlincleanarchitecturesample.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("title")
    val title: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("genre_ids")
    val genreIds :List<Int>,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String
) : Parcelable