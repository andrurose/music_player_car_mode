package com.example.syncg3.ui.phone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.syncg3.R

class PhoneFragment : Fragment() {

    private lateinit var phoneViewModel: PhoneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        phoneViewModel =
            ViewModelProviders.of(this).get(PhoneViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_phone, container, false)
        val textView: TextView = root.findViewById(R.id.text_phone)
        phoneViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}