package com.example.sample_mvvm_databinding.data

import com.example.sample_mvvm_databinding.data.local.CaoCeoLocalDataSource

class RacaRepository(private val remoteDataSource: RacaDataSource, private val caoCeoLocalDataSource: CaoCeoLocalDataSource) :
    RacaDataSource {
    override fun listAll(success: (List<Raca>) -> Unit, failure: () -> Unit) {
        remoteDataSource.listAll({
            it.forEach(caoCeoLocalDataSource::save)
            success(it)
        }, {
            caoCeoLocalDataSource.listAll(success, failure)
        })
    }

    override fun save(raca: Raca) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}