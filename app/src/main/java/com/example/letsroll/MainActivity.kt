package com.example.letsroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    private var DiceImageResoure = -1
    lateinit var viewModel : DiceViewModel
    private val workManager = WorkManager.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dice_button: Button = findViewById(R.id.tap_here_button)

        diceImage = findViewById(R.id.dice_image)
        viewModel = ViewModelProvider(this).get(DiceViewModel::class.java)
        DiceImageResoure = viewModel.getImageResource()

        if(DiceImageResoure != -1) {
            diceImage.setImageResource(DiceImageResoure)
        }

        dice_button.setOnClickListener { Roll() }
    }

     fun Roll() {
        val request = OneTimeWorkRequest.from(DiceWorker::class.java)

        workManager.enqueue(request)
        workManager.getWorkInfoByIdLiveData(request.id).observe(this, {
            if (it.state.isFinished) {
                viewModel.rollDice()
                DiceImageResoure = viewModel.getImageResource()
                diceImage.setImageResource(DiceImageResoure)
            }
        })

    }

}