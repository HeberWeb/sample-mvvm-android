package com.example.sample_mvvm_databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sample_mvvm_databinding.databinding.RacasFragmentBinding
import com.example.sample_mvvm_databinding.racas.RacasAdapter
import com.example.sample_mvvm_databinding.racas.RacasViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class RacaFragment : Fragment() {
    val viewModel: RacasViewModel by viewModel()

    companion object{
        fun newInstance(): RacaFragment {
            return RacaFragment()
        }
    }

    override fun onCreateView(
        @NonNull inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : RacasFragmentBinding = RacasFragmentBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.recyclerView.adapter = RacasAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.setLifecycleOwner(this)

        lifecycle.addObserver(viewModel)
        return binding.root
    }
}