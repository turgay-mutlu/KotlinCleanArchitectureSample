package com.mutlu.turgay.kotlincleanarchitecturesample.ui.discover


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.LinearLayoutManager

import com.mutlu.turgay.kotlincleanarchitecturesample.R
import com.mutlu.turgay.kotlincleanarchitecturesample.base.BaseFragment
import com.mutlu.turgay.kotlincleanarchitecturesample.databinding.FragmentDiscoverBinding
import com.mutlu.turgay.kotlincleanarchitecturesample.model.Movie


class DiscoverFragment : BaseFragment<DiscoverVM, FragmentDiscoverBinding>() {

    override val layoutId: Int =R.layout.fragment_discover
    override val viewModelClass: Class<DiscoverVM> = DiscoverVM::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.layoutManager = LinearLayoutManager(this.context)
        val adapter = RvMovieAdapter(viewModel.movieList, object : RvMovieAdapter.ClickListener{
            override fun onItemClick(clickedView: View, movie: Movie) {
                Toast.makeText(context,"Hello" + movie.title,Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.isLoading.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback(){
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                adapter.notifyDataSetChanged()
            }
        })

        binding.rvMovies.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DiscoverFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
