package edu.victorhom19.lab3_navigation

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.victorhom19.lab3_navigation.databinding.Fragment3Binding

class Fragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = Fragment3Binding.inflate(layoutInflater)
        val navController = findNavController()
        binding.bnToFirst.setOnClickListener {
            navController.navigate(R.id.action_fragment3_to_fragment1)
        }
        binding.bnToSecond.setOnClickListener {
            navController.navigate(R.id.action_fragment3_to_fragment2)
        }
        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return binding.root
    }

}