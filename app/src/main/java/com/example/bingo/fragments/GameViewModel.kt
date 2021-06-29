package com.example.bingo.fragments

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel(application: Application) : AndroidViewModel(application) {

    // The random alphabet
    var letter = ""

    private lateinit var bingoCountDownTimer: CountDownTimer

    private val _bingoText = MutableLiveData<String>()
    val bingoText : LiveData<String> = _bingoText

    private val _bingoButtonState = MutableLiveData(true)
    val bingoButtonState : LiveData<Boolean> = _bingoButtonState

    private val _counter = MutableLiveData(30)
    val counter : LiveData<Int> = _counter

    private val _done = MutableLiveData<Boolean>()
    val done : LiveData<Boolean> = _done

    // Generates random alphabets
     private fun randomLetter() {
        letter = ('A'..'Z').random().toString()
    }

    // Change Bingo button text
    private fun changeBingoButtonText(bingoText : String) {
        _bingoText.value = bingoText
    }


    fun changeBingoButtonState() {
        // check the current value in bingo button and reverse it
        _bingoButtonState.value?.let { isTrue ->
            // change button state so UI reacts to the changes
            if (isTrue) {
                _bingoButtonState.value = false
                changeBingoButtonText("Bingo Stop")
                startTimerCounter()
            } else {
//                _bingoButtonState.value = true
                  _done.value = true
                bingoCountDownTimer.cancel()

            }

        }
    }

    fun startTimerCounter() {
        bingoCountDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _counter.value = (counter.value)?.minus(1)
            }

            override fun onFinish() {
                        _done.value = true
            }

        } .start()

    }




    init {
        randomLetter()
    }






}