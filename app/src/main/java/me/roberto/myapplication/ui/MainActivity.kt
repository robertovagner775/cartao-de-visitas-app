package me.roberto.myapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import me.roberto.myapplication.App
import me.roberto.myapplication.databinding.ActivityMainBinding
import me.roberto.myapplication.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    private val mainViewModel: MainViewModel by viewModels { MainViewModelFactory((application as App).repository) }

    private val adapter by lazy { BussinesCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCardBusiness.adapter = adapter
        allBusinessCard()
        eventListener()
    }
    private fun eventListener(){
        binding.btnfb.setOnClickListener{
            val intent = Intent(this, addBussinesActivity::class.java)
            startActivity( intent)
        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)

        }

    }
    private fun allBusinessCard() {
        mainViewModel.getAll().observe(this, { businessCard ->
            adapter.submitList(businessCard)

        })
    }

}