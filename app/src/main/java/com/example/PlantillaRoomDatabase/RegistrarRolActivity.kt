package com.example.PlantillaRoomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.PlantillaRoomDatabase.Entitys.Rol
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityRegistrarRolBinding

class RegistrarRolActivity : AppCompatActivity() {
    lateinit var binding:ActivityRegistrarRolBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarRolBinding.inflate(layoutInflater)
        setContentView(binding.root)
        create()
    }
    fun create(){
        binding.button4.setOnClickListener {
            var obj= Rol(0,binding.txt.text.toString())
            rom.daoRol().create(obj)
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            super.finish()
        }

    }
}