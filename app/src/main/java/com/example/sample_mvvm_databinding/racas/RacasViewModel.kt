package com.example.sample_mvvm_databinding.racas

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.example.sample_mvvm_databinding.R
import com.example.sample_mvvm_databinding.data.Raca
import com.example.sample_mvvm_databinding.data.RacaDataSource

class RacasViewModel(val repository : RacaDataSource, application: Application) :
    AndroidViewModel(application), LifecycleObserver {

    val racas = MutableLiveData<List<Raca>>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    private fun load(){
        loadingVisibility.set(true)
        message.set("")

        repository.listAll({ items ->
            racas.postValue(items)
            if (items.isEmpty()){
                message.set(getApplication<Application>().getString(R.string.sem_registros))
            }

            loadingVisibility.set(false)
        }, {
            message.set(getApplication<Application>().getString(R.string.falha_na_listagem))
            loadingVisibility.set(false)
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