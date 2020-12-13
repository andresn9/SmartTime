package com.norbertovargas.pruebassmarttime

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import basededatos.SmartTimeOpenHelper
import kotlinx.android.synthetic.main.stats.*

class StatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.stats)


    }
}