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

            binding.nameEditText.isCursorVisible = true
            binding.nameEditText.isFocusableInTouchMode = true
            binding.nameEditText.isFocusable = true

            binding.countryEditText.isCursorVisible = true
            binding.countryEditText.isFocusableInTouchMode = true
            binding.countryEditText.isFocusable = true

            binding.animalEditText.isCursorVisible = true
            binding.animalEditText.isFocusableInTouchMode = true
            binding.animalEditText.isFocusable = true

            binding.foodEditText.isCursorVisible = true
            binding.foodEditText.isFocusableInTouchMode = true
            binding.foodEditText.isFocusable = true

            if (bingoCountDownTimerState) {
                bingoCountDownTimerState = false
                binding.startStopButton.text = "Bingo Stop"
//                binding.startStopButton.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
                startTimerCounter()
            } else {
                bingoCountDownTimer.cancel()

                binding.nameEditText.isCursorVisible = false
                binding.nameEditText.isFocusableInTouchMode = false
                binding.nameEditText.isFocusable = false

                binding.countryEditText.isCursorVisible = false
                binding.countryEditText.isFocusableInTouchMode = false
                binding.countryEditText.isFocusable = false

                binding.animalEditText.isCursorVisible = false
                binding.animalEditText.isFocusableInTouchMode = false
                binding.animalEditText.isFocusable = false

                binding.foodEditText.isCursorVisible = false
                binding.foodEditText.isFocusableInTouchMode = false
                binding.foodEditText.isFocusable = false
            }

        }

        binding.nameEditText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {

                validateName()
            }
        }

        binding.countryEditText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validateCountry()
            }
        }

        binding.animalEditText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validateAnimal()
            }
        }

        binding.foodEditText.setOnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                validateFood()
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

    private fun validateName() {

        var namesOfPeople = listOf<String>("Aba", "Bel", "Kojo", "Adwoa", "Zain", "Norris", "Pam")
        var name = binding.nameEditText.text.toString()
        var nameFirstLetter: String
        var bingoLetter = binding.bingoLetterText.text


        if (name != "") {
            name = name.capitalize()
            nameFirstLetter = name.first().toString()
            if (nameFirstLetter == bingoLetter && namesOfPeople.contains(name)) {
                score += 10
                Toast.makeText(requireContext(), "You have: $score points", Toast.LENGTH_LONG).show()

            } else {

                Toast.makeText(requireContext(), "wrong", Toast.LENGTH_LONG).show()

            }
        }


    }

    private fun validateCountry() {

        var namesOfCountries = listOf<String>("Ghana","Togo","Berlin","Angola","Spain",
            "Portugal","Kenya","Norway")
        var country = binding.countryEditText.text.toString()
        var countryFirstLetter : String
        var bingoLetter = binding.bingoLetterText.text

        if (country!= "") {
            country = country.trim()
            country = country.capitalize()
            countryFirstLetter = country.first().toString()
            if (countryFirstLetter == bingoLetter && namesOfCountries.contains(country)){
                score+=10
                Toast.makeText(requireContext(), "You have : $score points", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(requireContext(), "You have: $score points", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun validateAnimal() {

        var namesOfAnimals = listOf<String>("Antelope","Dog","Cat","Sheep")
        var animal = binding.animalEditText.text.toString()
        var animalFirstLetter : String
        var bingoLetter = binding.bingoLetterText.text

        if (animal!= "") {
            animal = animal.trim()
            animal = animal.capitalize()
            animalFirstLetter = animal.first().toString()
            if (animalFirstLetter == bingoLetter && namesOfAnimals.contains(animal)){
                score+=10
                Toast.makeText(requireContext(), "You have : $score points", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(requireContext(), "You have: $score points", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun validateFood() {

        var namesOfFoods = listOf<String>("Gari","Bread","Rice","Apple","Cheese")
        var food = binding.foodEditText.text.toString()
        var foodFirstLetter : String
        var bingoLetter = binding.bingoLetterText.text

        if (food!= "") {
            food = food.trim()
            food = food.capitalize()
            foodFirstLetter = food.first().toString()
            if (foodFirstLetter == bingoLetter && namesOfFoods.contains(food)){
                score+=10
                Toast.makeText(requireContext(), "You have : $score points", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(requireContext(), "You have: $score points", Toast.LENGTH_LONG).show()
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







