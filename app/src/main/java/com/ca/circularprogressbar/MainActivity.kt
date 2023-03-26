package com.ca.circularprogressbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ca.circular_progress_bar.ProgressBarHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ProgressBarHelper(this)

    }
}