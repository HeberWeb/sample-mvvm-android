package com.example.sample_mvvm_databinding.data.remoto

import com.example.sample_mvvm_databinding.data.Raca
import com.example.sample_mvvm_databinding.data.RacaDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CaoCeoDataSource(val caoCeoApi: CaoCeoApi) : RacaDataSource {
    override fun listAll(success: (List<Raca>) -> Unit, failure: () -> Unit) {
        val  call = caoCeoApi.listRacas()
        call.enqueue(object: Callback<CaoCeoResponse>{
            override fun onFailure(call: Call<CaoCeoResponse>, t: Throwable) {
                failure()
            }

            override fun onResponse(
                call: Call<CaoCeoResponse>,
                response: Response<CaoCeoResponse>
            ) {
                if (response.isSuccessful){
                    val racas = mutableListOf<Raca>()
                    response.body()?.message?.forEach {
                        racas.add(Raca(it))
                    }
                    success(racas)
                } else {
                    failure()
                }
            }

        })
    }
}