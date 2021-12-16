package edu.victorhom19.lab3_navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.victorhom19.lab3_navigation.databinding.Fragment1Binding

class Fragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = Fragment1Binding.inflate(layoutInflater)
        val navController = findNavController()
        binding.bnToSecond.setOnClickListener {
            navController.navigate(R.id.action_fragment1_to_fragment2)
        }
        setHasOptionsMenu(true)

        return binding.root
    }



//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.about_item -> {
//                val navController = findNavController()
//                navController.navigate(R.id.action_to_activityAbout)
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }



}