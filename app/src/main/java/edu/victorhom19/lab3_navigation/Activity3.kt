package edu.victorhom19.lab3_navigation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import edu.victorhom19.lab3_navigation.databinding.Activity3Binding

class Activity3 : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnToFirst.setOnClickListener {
            startActivity(Intent(this, Activity1::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        }
        binding.bnToSecond.setOnClickListener {
            finish()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}