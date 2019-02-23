package com.mutlu.turgay.kotlincleanarchitecturesample.base

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.OnRebindCallback
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.mutlu.turgay.kotlincleanarchitecturesample.BR


abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : Fragment() {
    val TAG = javaClass.simpleName

    lateinit var viewModel: VM
    lateinit var binding: DB

    abstract val layoutId: Int
    abstract val viewModelClass: Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater,layoutId,container,false)
        binding.setLifecycleOwner(this)
        binding.setVariable(BR.vm,viewModel)
        binding.addOnRebindCallback(object : OnRebindCallback<ViewDataBinding>(){
            override fun onPreBind(binding: ViewDataBinding?): Boolean {
                val viewGroup = binding?.root as ViewGroup
                TransitionManager.beginDelayedTransition(viewGroup)
                return super.onPreBind(binding)
            }
        })
        return binding.root
    }

    fun loadFragment(containerId: Int, fragment: Fragment, fragmentManager: FragmentManager, addToBackStack:Boolean){
        val transaction = fragmentManager.beginTransaction()
        if(addToBackStack){
            transaction.addToBackStack("")
        }
        transaction.replace(containerId,fragment)
        transaction.commit()
    }
}