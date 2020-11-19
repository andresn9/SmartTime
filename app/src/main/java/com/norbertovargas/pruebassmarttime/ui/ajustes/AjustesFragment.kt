package com.norbertovargas.pruebassmarttime.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.norbertovargas.pruebassmarttime.R

class AjustesFragment : Fragment() {

    private lateinit var ajustesViewModel: AjustesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        ajustesViewModel =
                ViewModelProvider(this).get(AjustesViewModel::class.java)
        val root = inflater.inflate(R.layout.ajustes, container, false)

        return root
    }
}