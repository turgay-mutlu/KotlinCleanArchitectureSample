package com.mutlu.turgay.kotlincleanarchitecturesample.ui.movie

import androidx.databinding.ObservableField
import com.mutlu.turgay.kotlincleanarchitecturesample.base.BaseViewModel
import com.mutlu.turgay.kotlincleanarchitecturesample.model.Movie

class MovieVM : BaseViewModel() {
    var movie: ObservableField<Movie> = ObservableField()
}
