package com.example.sample_mvvm_databinding.data.local

//import com.example.sample_mvvm_databinding.data.Raca
//import com.example.sample_mvvm_databinding.data.RacaDataSource
//import com.example.sample_mvvm_databinding.util.AppExecutors
//
//class CaoCeoLocalDataSource(private val  dao: RacaDao, private val appExecutors: AppExecutors) :
//    RacaDataSource {
//    override fun listAll(success: (List<Raca>) -> Unit, failure: () -> Unit) {
//        appExecutors.roomThreadExecutor.execute{
//            val  racas = dao.getAll()
//            appExecutors.mainThreadExecutor.execute{success(racas)}
//        }
//    }
//
//    override fun save(raca: Raca) {
//        appExecutors.roomThreadExecutor.execute {
//            dao.insertAll(raca)
//        }
//    }
//}