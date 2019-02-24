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
import com.mutlu.turgay.kotlincleanarchitecturesample.ui.movie.MovieFragment


class DiscoverFragment : BaseFragment<DiscoverVM, FragmentDiscoverBinding>() {

    override val layoutId: Int =R.layout.fragment_discover
    override val viewModelClass: Class<DiscoverVM> = DiscoverVM::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.rvMovies.setHasFixedSize(true)
        binding.rvMovies.layoutManager = LinearLayoutManager(this.context)
        val adapter = RvMovieAdapter(viewModel.movieList, RvMovieAdapter.OnClickListenerDataBinding(object : RvMovieAdapter.ClickListener{
                override fun onItemClick(movie: Movie, clickedView: View) {
                    loadFragment(R.id.container,MovieFragment.newInstance(movie),fragmentManager,true)
                }
            })
        )

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
