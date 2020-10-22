package com.example.letsroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    private var DiceImageResoure = -1
    lateinit var viewModel : DiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dice_button: Button = findViewById(R.id.tap_here_button)
        diceImage = findViewById(R.id.dice_image)
        viewModel = ViewModelProviders.of(this).get(DiceViewModel::class.java)
        DiceImageResoure = viewModel.getImageResource()
        if(DiceImageResoure != -1) {
            diceImage.setImageResource(DiceImageResoure)
        }
        var UI_Button :Button = findViewById(R.id.button)
        UI_Button.setOnClickListener() {
            Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show()
        }
        dice_button.setOnClickListener() {
            Roll()
        }
    }

    public fun Roll() {
        viewModel.rollDice()
        DiceImageResoure = viewModel.getImageResource()
        diceImage.setImageResource(DiceImageResoure)
    }
}