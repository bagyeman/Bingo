package com.example.bingo.fragments

import android.content.Context
import android.graphics.Color.red
import android.os.Bundle
import android.os.CountDownTimer
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.bingo.R
import com.example.bingo.databinding.FragmentGameBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var bingoCountDownTimer: CountDownTimer
    var bingoCountDownTimerState: Boolean = true
    var score: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val alphabets = ('A'..'Z')

        binding.bingoLetterText.text = alphabets.random().toString()

        binding.startStopButton.setOnClickListener {

            if (bingoCountDownTimerState) {
                bingoCountDownTimerState = false
                binding.startStopButton.text = "Bingo Stop"
//                binding.startStopButton.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
                startTimerCounter()
            } else {
                bingoCountDownTimer.cancel()
            }

        }

        binding.nameEditText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                checkName()
            }
        }


    }


    private fun startTimerCounter() {
        var counter = 30
        binding.bingoCountTime
        bingoCountDownTimer = object : CountDownTimer(31000, 1000) {
            override fun onFinish() {
            }

            override fun onTick(millisUntilFinished: Long) {
                binding.bingoCountTime.text = counter.toString()
                counter -= 1

            }

        }.start()

    }

    private fun checkName() {

        var namesOfPeople = listOf<String>("Aba", "Bel", "Kojo", "Adwoa")
        var name = binding.nameEditText.text.toString()
        var nameFirstLetter : String
        var bingoLetter = binding.bingoLetterText.text


        if (name != "") {
            nameFirstLetter = name.first().toString()
            if (nameFirstLetter == bingoLetter && namesOfPeople.contains(name)) {
                //Toast.makeText(requireContext(), "correct", Toast.LENGTH_LONG).show()
                Log.d("tag", "Correct")
            } else {
               // Toast.makeText(requireContext(), "wrong", Toast.LENGTH_LONG).show()
                Log.d("tag", "Wrong")

            }
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game, container, false
        )
        return binding.root


    }


}







