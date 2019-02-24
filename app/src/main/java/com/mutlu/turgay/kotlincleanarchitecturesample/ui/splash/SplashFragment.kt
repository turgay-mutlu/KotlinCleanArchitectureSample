package com.mutlu.turgay.kotlincleanarchitecturesample.ui.splash


import android.os.Bundle
import com.mutlu.turgay.kotlincleanarchitecturesample.R
import com.mutlu.turgay.kotlincleanarchitecturesample.base.BaseFragment
import com.mutlu.turgay.kotlincleanarchitecturesample.databinding.FragmentSplashBinding
import com.mutlu.turgay.kotlincleanarchitecturesample.ui.discover.DiscoverFragment


class SplashFragment : BaseFragment<SplashVM,FragmentSplashBinding>() {

    override val layoutId: Int = R.layout.fragment_splash
    override val viewModelClass: Class<SplashVM> = SplashVM::class.java

    override fun onResume() {
        super.onResume()
        loadFragment(R.id.container,DiscoverFragment.newInstance(),fragmentManager,false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SplashFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
