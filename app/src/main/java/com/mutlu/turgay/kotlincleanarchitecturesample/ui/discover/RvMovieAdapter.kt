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


class RvMovieAdapter(private val movies: ArrayList<Movie>, private val clickListenerDataBinding: OnClickListenerDataBinding) : RecyclerView.Adapter<RvMovieAdapter.RvMovieViewHolder>(){

    class RvMovieViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindTo(movie: Movie, onClickListenerDataBinding: OnClickListenerDataBinding){
            binding.vm = MovieItemVM(ObservableField(movie))
            binding.executePendingBindings()
            onClickListenerDataBinding.movie= movie
            binding.root.setOnClickListener(onClickListenerDataBinding)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvMovieViewHolder {
        return RvMovieViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_item,parent,false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: RvMovieViewHolder, position: Int) {
        val mClick = OnClickListenerDataBinding(clickListenerDataBinding.clickListener)
        holder.bindTo(movies[position],mClick)
    }

    interface ClickListener{
        fun onItemClick(movie: Movie,clickedView: View)
    }

    class OnClickListenerDataBinding(var clickListener: ClickListener): View.OnClickListener{
        var movie: Movie? = null
        override fun onClick(v: View?) {
            if (v != null && movie !=null) {
                clickListener.onItemClick(movie!!, v)
            }
        }
    }
}