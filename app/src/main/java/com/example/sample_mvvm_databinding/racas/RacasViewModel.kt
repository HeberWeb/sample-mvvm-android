package com.example.sample_mvvm_databinding.racas

import android.app.Application
import androidx.lifecycle.*
import com.example.sample_mvvm_databinding.R
import com.example.sample_mvvm_databinding.data.Raca
import com.example.sample_mvvm_databinding.data.RacaDataSource

class RacasViewModel(val repository : RacaDataSource, application: Application) :
    AndroidViewModel(application), LifecycleObserver {

    val racas = MutableLiveData<List<Raca>>().apply { value = emptyList() }
    val loadingVisibility = MutableLiveData<Boolean>().apply { value = false }
    val message = MutableLiveData<String>().apply { value = "" }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun load(){
        loadingVisibility.value = true
        message.value = ""

        repository.listAll({ items ->
            racas.value = (items)
            if (items.isEmpty()){
                message.value = getApplication<Application>().getString(R.string.sem_registros)
            }

            loadingVisibility.value = false
        }, {
            message.value = getApplication<Application>().getString(R.string.falha_na_listagem)
            loadingVisibility.value = false
        })
    }
}