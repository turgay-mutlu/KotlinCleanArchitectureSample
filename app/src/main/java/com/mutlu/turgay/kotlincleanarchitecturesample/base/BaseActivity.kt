package com.mutlu.turgay.kotlincleanarchitecturesample.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseActivity<DB : ViewDataBinding>: AppCompatActivity() {
    val TAG = javaClass.simpleName

    lateinit var binding: DB
    abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,layoutRes)
    }

    fun loadFragment(containerId:Int, fragment: Fragment, addToBackStack:Boolean){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if(addToBackStack){
            fragmentTransaction.addToBackStack("")
        }
        fragmentTransaction.replace(containerId,fragment)
        fragmentTransaction.commit()
    }
}