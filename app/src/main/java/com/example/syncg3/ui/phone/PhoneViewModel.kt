package com.example.syncg3.ui.phone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PhoneViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is phone Fragment"
    }
    val text: LiveData<String> = _text
}