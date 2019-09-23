package com.example.sample_mvvm_databinding.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sample_mvvm_databinding.data.Raca

@Database(entities = arrayOf(Raca::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun racaDao(): RacaDao
}