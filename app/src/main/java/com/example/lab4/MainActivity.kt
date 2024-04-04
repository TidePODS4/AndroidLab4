package com.example.lab4

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_master, MovieListFragment())
                .commit()
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            clearDetailFragmentContainer()
        }
    }

    private fun clearDetailFragmentContainer() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentById(R.id.detail_fragment_container)
        if (fragment != null) {
            fragmentManager.beginTransaction().remove(fragment).commit()
        }
    }

}
