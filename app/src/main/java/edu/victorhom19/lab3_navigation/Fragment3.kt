package edu.victorhom19.lab3_navigation

import android.os.Bundle
import android.view.*
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
        binding.switchToFirst.setOnClickListener {
            navController.navigate(R.id.action_fragment3_to_fragment1)
        }
        binding.switchToSecond.setOnClickListener {
            navController.navigate(R.id.action_fragment3_to_fragment2)
        }
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_item -> {
                val navController = findNavController()
                navController.navigate(R.id.action_to_activityAbout)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}