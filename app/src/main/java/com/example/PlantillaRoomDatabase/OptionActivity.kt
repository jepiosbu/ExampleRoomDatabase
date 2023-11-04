package com.example.PlantillaRoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.PlantillaRoomDatabase.databinding.ActivityOptionBinding

class OptionActivity : AppCompatActivity() {
    lateinit var binding: ActivityOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        option()
    }
    fun option(){
        binding.button.setOnClickListener {
            startActivity(Intent(this@OptionActivity,RegistrarOptionActivity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this@OptionActivity,RegistrosOptionActivity::class.java))
        }
    }
}