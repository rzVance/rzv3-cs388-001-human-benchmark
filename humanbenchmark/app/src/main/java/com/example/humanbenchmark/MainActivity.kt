package com.example.humanbenchmark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.humanbenchmark.R.*
import com.example.humanbenchmark.fragments.GameFragment
import com.example.humanbenchmark.fragments.LeaderboardFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val gameFragment = GameFragment()
        val leaderboardFragment = LeaderboardFragment()

        makeCurrentFragment(gameFragment)

        val bottomNavigationView: BottomNavigationView = findViewById(id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_game -> makeCurrentFragment(gameFragment)
                R.id.ic_leaderboard -> makeCurrentFragment(leaderboardFragment)
                else -> {
                    return@setOnItemSelectedListener true;
                }
            }
        }
    }

    private fun makeCurrentFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
        return true
    }
}