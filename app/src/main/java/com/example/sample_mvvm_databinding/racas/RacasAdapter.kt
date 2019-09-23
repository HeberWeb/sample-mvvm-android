package com.example.sample_mvvm_databinding.racas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sample_mvvm_databinding.data.Raca
import com.example.sample_mvvm_databinding.databinding.RacasItemBinding

class RacasAdapter(var items: List<Raca>) : RecyclerView.Adapter<RacasAdapter.ViewHolder>(), AdapterItemsContract{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RacasItemBinding = RacasItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(items: List<*>) {
        this.items = items as List<Raca>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val binding: RacasItemBinding) :  RecyclerView.ViewHolder(binding.root){
        fun bind(raca: Raca) {
            binding.raca = raca
            binding.executePendingBindings()
        }

    }

}