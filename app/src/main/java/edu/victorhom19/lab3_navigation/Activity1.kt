package edu.victorhom19.lab3_navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import edu.victorhom19.lab3_navigation.databinding.Activity1Binding

class Activity1 : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnToSecond.setOnClickListener {
            startActivity(Intent(this, Activity2::class.java))
        }
    }

}