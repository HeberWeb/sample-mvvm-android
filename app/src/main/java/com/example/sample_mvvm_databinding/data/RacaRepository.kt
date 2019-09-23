package com.example.sample_mvvm_databinding.data

class RacaRepository(private val remoteDataSource: RacaDataSource) :
    RacaDataSource {
    override fun listAll(success: (List<Raca>) -> Unit, failure: () -> Unit) {
        remoteDataSource.listAll(success, failure)
    }

//    override fun save(raca: Raca) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
}