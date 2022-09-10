package com.example.fitmax.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitmax.R
import com.example.fitmax.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setbottomnav()
    }

    fun setbottomnav() {
        binding.bnvNav.setOnItemSelectedListener {  item ->
            when(item.itemId){
                R.id.Plan ->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvMenus, PlanFragment()).commit()
                    true
                }
                R.id.Track ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvMenus,
                        TrackFragment()
                    ).commit()
                    true
                }
                R.id.Profile ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvMenus,
                        ProfileFragment()
                    ).commit()
                    true
                }
                else->false
            }
        }
    }

}