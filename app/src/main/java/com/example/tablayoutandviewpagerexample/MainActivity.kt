package com.example.tablayoutandviewpagerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.buttonView)
        navController = findNavController(R.id.container)
        bottomNav.setupWithNavController(navController)

        // Change the bar title according to the current fragment label
        val appBarConfig = AppBarConfiguration(
            setOf(R.id.mainFragment,
                R.id.firstFragment,
                R.id.secondFragment,
                R.id.thirdFragment)
        )
        setupActionBarWithNavController(navController, appBarConfig)
    }
}
