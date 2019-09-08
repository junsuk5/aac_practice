package com.jsoh.aac

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jsoh.aac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}

class MainViewModel: ViewModel() {
    var counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun addCounter() {
        counter.value = counter.value?.plus(1)
    }
}
