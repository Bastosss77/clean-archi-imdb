package org.jazzilla.cleanarchitectuteimdb.presentation.common

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.findNavController
import org.jazzilla.cleanarchitectuteimdb.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
    }

    fun navigateBack() {

    }

    fun navigate(@IdRes to: Int) {

    }
}