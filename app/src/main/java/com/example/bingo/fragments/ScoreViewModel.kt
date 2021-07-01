package com.example.bingo.fragments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(application : Application) : AndroidViewModel(application) {

    val _score = MutableLiveData<Int>()
    val score : LiveData<Int> = _score

    init {
        _score.value = 0
    }
}