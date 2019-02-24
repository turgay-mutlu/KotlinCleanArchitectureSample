package com.mutlu.turgay.kotlincleanarchitecturesample

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: ImageView, url: String?){
    val absuluteUrl= "https://image.tmdb.org/t/p/w185$url"
    Glide.with(imageView.context).load(absuluteUrl).into(imageView)
}