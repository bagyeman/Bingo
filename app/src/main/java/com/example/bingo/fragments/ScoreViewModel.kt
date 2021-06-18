package com.example.bingo.fragments

import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    var score = finalScore
}