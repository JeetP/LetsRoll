package com.example.letsroll

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class DiceWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        sleep(2000)

        return Result.success()
    }
}