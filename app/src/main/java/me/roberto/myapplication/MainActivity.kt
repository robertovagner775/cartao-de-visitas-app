package me.roberto.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.roberto.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventListener()
    }
    private fun eventListener(){
        binding.btnfb.setOnClickListener{
            val intent = Intent(this, addBussinesActivity::class.java)
            startActivity( intent)
        }

    }

}