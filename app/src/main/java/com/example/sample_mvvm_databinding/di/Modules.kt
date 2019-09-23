package com.example.sample_mvvm_databinding.di

import com.example.sample_mvvm_databinding.data.RacaDataSource
import com.example.sample_mvvm_databinding.data.RacaRepository
import com.example.sample_mvvm_databinding.data.remoto.CaoCeoApi
import com.example.sample_mvvm_databinding.data.remoto.CaoCeoDataSource
import com.example.sample_mvvm_databinding.racas.RacasViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val AppModule = module {
    single { Retrofit.Builder().baseUrl("https://dog.ceo/api/").addConverterFactory(GsonConverterFactory.create()).build() }
    single { (get() as Retrofit).create(CaoCeoApi::class.java) }

    single ("api"){ CaoCeoDataSource(get()) as RacaDataSource }
    single("repository"){ RacaRepository(get("api")) as RacaDataSource }
    viewModel { RacasViewModel(get("repository"), androidApplication())}
}

val appModules = listOf(AppModule)