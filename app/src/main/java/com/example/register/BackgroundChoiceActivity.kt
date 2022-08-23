package com.example.register

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.register.databinding.ActivityBackgroundChoiceBinding
import com.example.register.databinding.ActivityMainBinding

class BackgroundChoiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBackgroundChoiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_background_choice)
        binding = ActivityBackgroundChoiceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
    }

    private fun setup() {
        setupViews()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        setColorButton(binding.btnRed, R.color.red)
        setColorButton(binding.btnOrange, R.color.orange)
        setColorButton(binding.btnYellow, R.color.yellow)
        setColorButton(binding.btnGreen, R.color.green)
        setColorButton(binding.btnBlue, R.color.blue)
        setColorButton(binding.btnIndigo, R.color.indigo)
        setColorButton(binding.btnViolet, R.color.violet)
    }

    fun setColorButton(button: Button, color: Int){
        button.setOnClickListener {
            Intent().let { pickedColorIntent ->
                pickedColorIntent.putExtra(MainActivity.RAINBOW_COLOR, color)
                setResult(Activity.RESULT_OK, pickedColorIntent)
                finish()
            }
        }

    }


    private fun setupViews() {
        var title = ""
        val name = intent.getStringExtra(MY_NAME)
        if (!name.isNullOrBlank()) {
            title += "Hi $name\n"
        }
        title += "Chose the background color."

        binding.tvTitle.text = title
    }

    companion object {
        val MY_NAME = " My name"

    }
}