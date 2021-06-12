package com.example.myapplication2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.databinding.ActivityMainBinding
import com.example.myapplication2.db.AdData

class MainActivity() : AppCompatActivity() {

    lateinit var response: AdData
    private val TAG = "SearchFragment"
    var android_id = ""

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}