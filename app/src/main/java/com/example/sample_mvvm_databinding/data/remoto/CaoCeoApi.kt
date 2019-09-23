package com.example.sample_mvvm_databinding.data.remoto

import retrofit2.Call
import retrofit2.http.GET

interface CaoCeoApi {
    @GET("breeds/list")
    fun listRacas(): Call<CaoCeoResponse>
}