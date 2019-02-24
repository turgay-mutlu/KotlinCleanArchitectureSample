package com.mutlu.turgay.kotlincleanarchitecturesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mutlu.turgay.kotlincleanarchitecturesample.base.BaseActivity
import com.mutlu.turgay.kotlincleanarchitecturesample.databinding.ActivityMainBinding
import com.mutlu.turgay.kotlincleanarchitecturesample.ui.splash.SplashFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutRes: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadFragment(binding.container.id,SplashFragment.newInstance(),false)
    }
}
