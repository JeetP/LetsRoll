package com.example.letsroll

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {
    lateinit var context : Context
    lateinit var diceImage: ImageView
    private var DiceImageResoure = -1
    lateinit var viewModel : DiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        context = this
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
            requesTask().execute()
        }
    }

    public fun Roll() {
        viewModel.rollDice()
        DiceImageResoure = viewModel.getImageResource()
        diceImage.setImageResource(DiceImageResoure)
    }

    internal inner class requesTask: AsyncTask<Void,Void,String>() {
        override fun doInBackground(vararg params: Void?): String {
            sleep(10000)
            return "True"
        }

        override fun onPostExecute(result: String?) {
            Roll()
        }
    }

}