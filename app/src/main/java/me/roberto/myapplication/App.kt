package me.roberto.myapplication

import android.app.Application
import me.roberto.myapplication.data.AppDatabase
import me.roberto.myapplication.data.BussinesCardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BussinesCardRepository(database.businessDao()) }
}