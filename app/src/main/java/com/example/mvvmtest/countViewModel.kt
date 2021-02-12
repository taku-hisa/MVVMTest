package com.example.mvvmtest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CountViewModel : ViewModel() {
    //viewModelとしてデータを持ち続けたい値
    //var couterB : Int = 0

    val counterB : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    init{
        counterB.value = 0
    }
}