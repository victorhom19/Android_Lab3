package edu.victorhom19.lab3_navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import edu.victorhom19.lab3_navigation.databinding.Activity2Binding

class Activity2 : AbstractActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnToFirst.setOnClickListener {
            finish()
        }
        binding.bnToThird.setOnClickListener {
            startActivity(Intent(this, Activity3::class.java))
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }



}
