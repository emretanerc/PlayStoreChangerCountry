package com.etcmobileapps.playstorechangercountry


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.etcmobileapps.playstorechangercountry.databinding.ActivityMainBinding


private  lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}