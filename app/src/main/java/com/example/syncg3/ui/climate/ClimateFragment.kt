package com.example.syncg3.ui.climate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.syncg3.R

class ClimateFragment : Fragment() {

    private lateinit var climateViewModel: ClimateViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        climateViewModel =
            ViewModelProviders.of(this).get(ClimateViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_climate, container, false)
        val textView: TextView = root.findViewById(R.id.text_climate)
        climateViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}