package com.example.sample_mvvm_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragmentTo(R.id.content_frame, createFragment())
    }

    fun createFragment(): RacaFragment{
        return RacaFragment.newInstance()
    }
}
