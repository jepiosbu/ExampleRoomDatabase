package com.example.PlantillaRoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.room.Room
import com.example.PlantillaRoomDatabase.DataBase.DB
import com.example.PlantillaRoomDatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
      lateinit var rom:DB
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        rom= Room.databaseBuilder(this, DB::class.java,"DB").allowMainThreadQueries().build()
        setContentView(binding.root)
        start()
    }
    fun start(){
        Handler().postDelayed({
                              startActivity(Intent(this@MainActivity,OptionActivity::class.java))
        },4000)
    }
}