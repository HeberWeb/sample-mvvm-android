package com.example.sample_mvvm_databinding.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sample_mvvm_databinding.data.Raca

interface RacaDao {
    @Query("SELECT * FROM raca")
    fun getAll():List<Raca>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg racas: Raca)

    @Delete
    fun delete(raca: Raca)
}