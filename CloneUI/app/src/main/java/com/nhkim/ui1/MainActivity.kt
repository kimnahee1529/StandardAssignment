package com.nhkim.ui1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nhkim.ui1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainFragment = MainFragment()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.main_container, mainFragment)
                commit()
            }
        }

        binding.navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home1_icon -> {
                    loadFragment(MainFragment())
                    true
                }
                R.id.heart_icon -> {
                    loadFragment(FavoritesFragment())
                    true
                }
                else -> false
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }

}