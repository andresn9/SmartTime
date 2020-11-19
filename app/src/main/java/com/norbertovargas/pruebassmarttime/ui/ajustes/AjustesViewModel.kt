package com.norbertovargas.pruebassmarttime.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AjustesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ajustes fragment"
    }
    val text: LiveData<String> = _text
}