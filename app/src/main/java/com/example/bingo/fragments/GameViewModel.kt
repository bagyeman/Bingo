package com.example.bingo.fragments

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // The random alphabet
    var letter = ""

    // Generates random alphabets
     private fun randomLetter() {
        letter = ('A'..'Z').random().toString()
    }


    init {
        randomLetter()
    }






}