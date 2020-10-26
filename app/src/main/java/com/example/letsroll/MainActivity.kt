package com.example.letsroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.reactivex.rxjava3.disposables.Disposable

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
        dice_button.setOnClickListener() {
            Roll()
        }
    }

    public fun Roll() {
        viewModel.rollDice().subscribe(
                {
                DiceImageResoure = viewModel.getImageResource()
                diceImage.setImageResource(DiceImageResoure)
                },
                {

                },
        )
    }
}