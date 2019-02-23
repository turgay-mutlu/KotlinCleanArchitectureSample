package com.mutlu.turgay.kotlincleanarchitecturesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mutlu.turgay.kotlincleanarchitecturesample.base.BaseActivity
import com.mutlu.turgay.kotlincleanarchitecturesample.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutRes: Int = R.layout.activity_main
}
