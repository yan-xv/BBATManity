package com.rsschool.finaltask.yanxv.bbatmanity.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.get
import androidx.navigation.findNavController
import com.rsschool.finaltask.yanxv.bbatmanity.R
import com.rsschool.finaltask.yanxv.bbatmanity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var _menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        _menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                findNavController(binding.myNavHostFragment.id)
                    .navigate(R.id.action_mainFragment_to_settingsFragment)
                item.isVisible = false

                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                return true
            }
            android.R.id.home -> {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                if ( this::_menu.isInitialized && _menu.size() > 0 )
                    _menu[0].isVisible = true
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}