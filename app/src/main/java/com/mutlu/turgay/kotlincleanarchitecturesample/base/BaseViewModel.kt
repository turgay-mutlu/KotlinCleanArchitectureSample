package com.mutlu.turgay.kotlincleanarchitecturesample.base

import androidx.lifecycle.ViewModel


abstract class BaseViewModel: ViewModel() {
    val Tag = javaClass.simpleName
}