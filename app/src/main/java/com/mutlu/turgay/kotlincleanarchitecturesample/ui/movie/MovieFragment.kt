package com.mutlu.turgay.kotlincleanarchitecturesample.ui.movie

import android.os.Bundle
import com.mutlu.turgay.kotlincleanarchitecturesample.R
import com.mutlu.turgay.kotlincleanarchitecturesample.base.BaseFragment
import com.mutlu.turgay.kotlincleanarchitecturesample.databinding.MovieFragmentBinding
import com.mutlu.turgay.kotlincleanarchitecturesample.model.Movie

class MovieFragment : BaseFragment<MovieVM,MovieFragmentBinding>() {
    override val layoutId: Int = R.layout.movie_fragment
    override val viewModelClass: Class<MovieVM> = MovieVM::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments!=null){
            if(arguments!!.containsKey(EXTRA_MOVIE)){
                viewModel.movie.set(arguments!!.getParcelable(EXTRA_MOVIE))
            }
        }
    }

    companion object {
        val EXTRA_MOVIE = "extra.movie"

        fun newInstance() = MovieFragment()
        fun newInstance(movie:Movie): MovieFragment{
            val fragment = MovieFragment()
            val args = Bundle()
            args.putParcelable(EXTRA_MOVIE,movie)
            fragment.arguments = args
            return fragment
        }
    }
}
