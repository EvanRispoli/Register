package com.example.register

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.register.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val backgroundColorLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val color = result.data?.getIntExtra(RAINBOW_COLOR, R.color.white)
        setBackgroundColor(color!!)
    }

    fun openChoseBackgroundLauncher(){
        val intent = Intent(this, BackgroundChoiceActivity::class.java)
        backgroundColorLauncher.launch(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setup()
    }

    private fun setup() {
        setupViews()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnBackground.setOnClickListener {
            //Open new window(Activity)

            if (binding.inputName.text.isNullOrBlank()) {
//                openBackgroundChoice()
//                openBackgroundChoiceToResponse()
                openChoseBackgroundLauncher()
            } else {
                openBackgroundChoice(binding.inputName.text.toString())
            }

        }

    }

    private fun openBackgroundChoice() {
        val intent = Intent(this, BackgroundChoiceActivity::class.java)
        startActivity(intent)
    }

    private fun openBackgroundChoice(name: String) {
        val intent = Intent(this, BackgroundChoiceActivity::class.java)
        intent.putExtra(BackgroundChoiceActivity.MY_NAME, name)
        startActivity(intent)
    }

    private fun openBackgroundChoiceToResponse() {
        val intent = Intent(this, BackgroundChoiceActivity::class.java)
//        Open the activity waiting an answer
        startActivityForResult(intent, BackgroundChoiceActivity_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == BackgroundChoiceActivity_REQUEST_CODE) {
//          Receive a response from activity with the requestcode BackgroundChoiceActivity_REQUEST_CODE
            val color = data?.getIntExtra(RAINBOW_COLOR, Color.parseColor(DEFAULT_COLOR))
//        If color is not null do :
            color?.let {
                setBackgroundColor(it)
            }
        }
    }

    private fun setBackgroundColor(color: Int) {
        binding.mainLayout.setBackgroundColor(
            ContextCompat.getColor(
                this,
                color
            )
        )

    }

    private fun setupViews() {

    }

    companion object {
        val BackgroundChoiceActivity_REQUEST_CODE = 1
        val RAINBOW_COLOR = "RAINBOW_COLOR"
        val DEFAULT_COLOR = "#FFFFFF"
    }

}