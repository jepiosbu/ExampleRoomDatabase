package com.example.PlantillaRoomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.PlantillaRoomDatabase.Entitys.TipoMascota
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityRegistrarTipoMascotaBinding

class RegistrarTipoMascotaActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrarTipoMascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarTipoMascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        create()
    }
    fun create(){
        binding.button4.setOnClickListener {
            var obj = TipoMascota(0,binding.txt.text.toString())
            rom.daoTipoMascota().create(obj)
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            super.finish()
        }
    }
}