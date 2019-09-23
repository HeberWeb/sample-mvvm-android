package com.example.sample_mvvm_databinding

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


fun AppCompatActivity.addFragmentTo(containerId : Int, fragment: Fragment, tag: String = ""){
    supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()
}