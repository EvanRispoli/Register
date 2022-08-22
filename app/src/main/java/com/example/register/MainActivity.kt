package com.example.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.register.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
    }

    private fun setup(){
        setupViews()
        setupClickListeners()


    }

    private fun setupClickListeners() {
        binding.btnBackground.setOnClickListener{
            //Open new window(Activity)
            openBackgroundChoice()

        }

    }

    private fun openBackgroundChoice() {
        val intent = Intent(this, BackgroundChoiceActivity::class.java)
        startActivity(intent)
    }

    private fun setupViews() {

    }

}