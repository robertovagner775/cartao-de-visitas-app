package me.roberto.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.roberto.myapplication.data.BusinessCard
import me.roberto.myapplication.data.BussinesCardRepository

class MainViewModel(private val bussinesCardRepository: BussinesCardRepository) : ViewModel() {

    fun insert(businessCard: BusinessCard){
        bussinesCardRepository.insert(businessCard)

    }

    fun getAll( ) : LiveData<List<BusinessCard>> {
        return  bussinesCardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: BussinesCardRepository) :
        ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("unknow viewmodel class")
    }

}