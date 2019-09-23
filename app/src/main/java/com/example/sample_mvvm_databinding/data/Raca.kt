package com.example.sample_mvvm_databinding.data

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Raca(@PrimaryKey var uid: Int,
                @ColumnInfo(name = "nome") var nome : String)