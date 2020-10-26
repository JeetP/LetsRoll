package com.example.letsroll

import androidx.lifecycle.ViewModel
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers



class DiceViewModel : ViewModel() {

    private var imageResource: Int = -1

    fun rollDice() : Observable<Unit> {
        return Observable.timer(2, TimeUnit.SECONDS)
                .map { imageResource = when(Random.nextInt(6) + 1)  {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }}
                .subscribeOn(Schedulers.newThread())
    }
    fun getImageResource(): Int {
        return imageResource
    }
}