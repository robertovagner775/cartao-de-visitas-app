package me.roberto.myapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.roberto.myapplication.databinding.ActivityAddBussinesBinding

class addBussinesActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityAddBussinesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBussinesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventListener()
    }
    private fun eventListener(){

    }
}