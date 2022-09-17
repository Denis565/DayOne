package com.example.dayone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dayone.Fragment.*
import com.example.dayone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val homeFragment = HomeFragment()
    val profileFragment= ProfileFragment()
    val catalogFragment = CatalogFragment()
    val shoppingFragment = ShoppingFragment()
    val stillFragment= StillFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        makeCurrentFragment(homeFragment)

        binding.bottomNavigationBar.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_home->makeCurrentFragment(homeFragment)
                R.id.ic_profile->makeCurrentFragment(profileFragment)
                R.id.ic_search->makeCurrentFragment(catalogFragment)
                R.id.ic_shopping->makeCurrentFragment(shoppingFragment)
                R.id.ic_still->makeCurrentFragment(stillFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_wrapper, fragment)
            commit()
        }
    }
}