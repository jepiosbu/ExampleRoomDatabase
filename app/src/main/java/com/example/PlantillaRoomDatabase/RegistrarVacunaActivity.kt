package com.example.PlantillaRoomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.PlantillaRoomDatabase.Entitys.Vacuna
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityRegistrarVacunaBinding

class RegistrarVacunaActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrarVacunaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarVacunaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        create()
    }
    fun create(){
        binding.button4.setOnClickListener {
            var data=Vacuna(0,binding.txt.text.toString())
            rom.daoVacuna().post(data)
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            super.finish()
        }

    }
}