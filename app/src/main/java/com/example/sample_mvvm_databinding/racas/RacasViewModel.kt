package com.example.sample_mvvm_databinding.racas

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.sample_mvvm_databinding.R
import com.example.sample_mvvm_databinding.data.Raca
import com.example.sample_mvvm_databinding.data.RacaDataSource

class RacasViewModel(val repository : RacaDataSource, application: Application) :
    AndroidViewModel(application), LifecycleObserver {

    val racas = MutableLiveData<List<Raca>>().apply { value = emptyList() }
    val loadingVisibility = MutableLiveData<Boolean>().apply { value = false }
    val message = MutableLiveData<String>().apply { value = "" }

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

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(){
        Log.d("TESTE", "ON_START")
        load()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        Log.d("TESTE", "ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d("TESTE", "PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d("TESTE", "ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d("TESTE", "ON_STOP")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d("TESTE", "ON_DESTROY")
    }
}