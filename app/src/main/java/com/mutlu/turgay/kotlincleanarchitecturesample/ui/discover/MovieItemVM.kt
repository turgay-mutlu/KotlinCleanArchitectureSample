package com.mutlu.turgay.kotlincleanarchitecturesample.ui.discover

import androidx.databinding.ObservableField
import com.mutlu.turgay.kotlincleanarchitecturesample.base.BaseViewModel
import com.mutlu.turgay.kotlincleanarchitecturesample.model.Movie


class MovieItemVM(var movie:ObservableField<Movie>): BaseViewModel()