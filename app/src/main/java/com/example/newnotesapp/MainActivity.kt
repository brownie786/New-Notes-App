package com.example.newnotesapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar) // Replace with your Toolbar's ID
        setSupportActionBar(toolbar)
//
//        val title = findViewById<TextView>(R.id.toolbar_title)
//        title.text = "My App"

        navController = findNavController(R.id.fragmentContainerView)
        setupActionBarWithNavController(navController)

    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }
}