package com.example.mvvmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var counterA = 0
        val viewModel = ViewModelProvider(this).get(CountViewModel::class.java)

        binding.button.setOnClickListener {
            //counterA
            counterA++
            binding.text1.text = counterA.toString()

            //counterB
            viewModel.counterB.value = viewModel.counterB.value!! + 1
        }

        //オブザーバーを置き、更新があったらUIを更新する
        val countObserver = Observer<Int>{ counter->
            binding.text2.text = counter.toString()
        }
        //アクティビティをオブザーバーとして渡す
        viewModel.counterB.observe(this,countObserver)
    }
}