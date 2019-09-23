package com.example.sample_mvvm_databinding.data

interface RacaDataSource {
    fun listAll(success: (List<Raca>) -> Unit, failure: () -> Unit)

//    fun save(raca: Raca)
}