package com.example.letsroll

import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class DiceViewModel : ViewModel() {

    private var imageResource: Int = -1

    fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        imageResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    fun getImageResource(): Int {
        return imageResource
    }
}