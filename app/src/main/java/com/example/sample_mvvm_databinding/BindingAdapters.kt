package com.example.sample_mvvm_databinding

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.sample_mvvm_databinding.racas.AdapterItemsContract

class BindingAdapters {
    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun <T>setItems(recyclerView: RecyclerView, items: MutableLiveData<List<T>>) {

            recyclerView.adapter.let {
                if (it is AdapterItemsContract) {
                    val ref = it
                    items.value?.let{
                        ref.replaceItems(it)
                    }
                }
            }
        }
    }
}