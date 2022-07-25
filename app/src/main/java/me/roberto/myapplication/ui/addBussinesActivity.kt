package me.roberto.myapplication.ui


import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import me.roberto.myapplication.App
import me.roberto.myapplication.R
import me.roberto.myapplication.data.BusinessCard
import me.roberto.myapplication.databinding.ActivityAddBussinesBinding


class addBussinesActivity : AppCompatActivity() {

    private  val binding by lazy { ActivityAddBussinesBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels { MainViewModelFactory((application as App).repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        eventListener()
    }
    private fun eventListener(){
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tiNome.editText?.text.toString(),
                empresa = binding.tiEmpresa.editText?.text.toString(),
                email = binding.tiEmail.editText?.text.toString(),
                telefone = binding.tiTelefone.editText?.text.toString(),
                background = binding.tiCor.editText?.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_sucess, Toast.LENGTH_SHORT).show()
        }

    }
}