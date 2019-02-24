package com.mutlu.turgay.kotlincleanarchitecturesample.ui.discover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.mutlu.turgay.kotlincleanarchitecturesample.R
import com.mutlu.turgay.kotlincleanarchitecturesample.databinding.MovieItemBinding
import com.mutlu.turgay.kotlincleanarchitecturesample.model.Movie


class RvMovieAdapter(private val movies: ArrayList<Movie>, private val onClickListener: ClickListener) : RecyclerView.Adapter<RvMovieAdapter.RvMovieViewHolder>(){


    class RvMovieViewHolder(private val binding: MovieItemBinding, private val onClickListener: ClickListener): RecyclerView.ViewHolder(binding.root){
        fun bindTo(movie: Movie){
            binding.vm = MovieItemVM(ObservableField(movie))
            binding.executePendingBindings()
            onClickListener.onItemClick(binding.root,movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvMovieViewHolder {
        return RvMovieViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_item,parent,false), onClickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: RvMovieViewHolder, position: Int) {
        holder.bindTo(movies[position])
    }

    interface ClickListener{
        fun onItemClick(clickedView: View, movie: Movie)
    }
}