package com.norbertovargas.pruebassmarttime.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.norbertovargas.pruebassmarttime.R

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: AjustesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(AjustesViewModel::class.java)
        val root = inflater.inflate(R.layout.calendar, container, false)

        return root
    }
}