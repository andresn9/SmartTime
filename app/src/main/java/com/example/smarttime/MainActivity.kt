package com.example.smarttime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        drawerLayout =  this.findViewById(R.id.drawer_layout)
        navigationView =  this.findViewById(R.id.nav_view)
        toolbar =this.findViewById(R.id.toolbar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.prueba)

        /*-------------Tool Bar----------*/
        setSupportActionBar(toolbar)

        /*-------------Nav Drawer Menu----------*/
         var toggle:ActionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState();

    }
}
