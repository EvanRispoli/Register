package com.example.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.register.databinding.ActivityBackgroundChoiceBinding
import com.example.register.databinding.ActivityMainBinding

class BackgroundChoiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBackgroundChoiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_background_choice)
        binding  = ActivityBackgroundChoiceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
    }

    private fun setup() {
        setupViews()
    }

    private fun setupViews() {
        var title = ""
        val name = intent.getStringExtra(MY_NAME)
        if (name.isNullOrBlank()){
            title += "Hi $name,\n"
        }
        title += "Chose the background color."

        binding.tvTitle.text = title
    }

    companion object{
        val MY_NAME = " My name"
    }
}