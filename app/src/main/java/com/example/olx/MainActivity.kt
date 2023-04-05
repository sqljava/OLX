package com.example.olx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.olx.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction()
            .add(R.id.main,HomeFragment()).commit()




    }
}