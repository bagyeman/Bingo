package com.example.bingo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bingo.R
import com.example.bingo.databinding.FragmentGameBinding
import com.example.bingo.databinding.FragmentScoreBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScoreFragment : Fragment(R.layout.fragment_score) {

//    private lateinit var viewModel: ScoreViewModel
    private val viewModel by viewModels<ScoreViewModel>()
    private val binding by dataBinding<FragmentScoreBinding>()
//    private lateinit var viewModelFactory: ScoreViewModelFactory
//    private lateinit var binding: FragmentScoreBinding



    //get argument from Game fragment
    private val args : ScoreFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //receive score argument in a variable
        val finalScore = args.score

        //set value to score Textview
        binding.scoreText.text = finalScore.toString()

        //set value to score Textview
        binding.scoreText.text = finalScore.toString()

        binding.playAgainButton.setOnClickListener {view : View ->

            view.findNavController().navigate(R.id.action_scoreFragment_to_gameFragment)
        }

   }




//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
////        binding = DataBindingUtil.inflate<FragmentScoreBinding>(
////            inflater,
////            R.layout.fragment_score, container, false
////        )
//
//        //receive score argument in a variable
//        val finalScore = args.score
//
////        viewModelFactory = ScoreViewModelFactory(finalScore)
//
//        //set value to score Textview
//        binding.scoreText.text = finalScore.toString()
//
//        binding.playAgainButton.setOnClickListener {view : View ->
//
//            view.findNavController().navigate(R.id.action_scoreFragment_to_gameFragment)
//        }
//
//
////        viewModel = ViewModelProvider(this, viewModelFactory).get(ScoreViewModel::class.java)
//
////        return binding.root
//    }


}