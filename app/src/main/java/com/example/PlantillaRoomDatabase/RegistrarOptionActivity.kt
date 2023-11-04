package com.example.PlantillaRoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.PlantillaRoomDatabase.databinding.ActivityRegistrarOptionBinding

class RegistrarOptionActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrarOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        option()
    }
    fun option(){
        binding.button2.setOnClickListener {
            startActivity(Intent(this@RegistrarOptionActivity,RegistrarVacunaActivity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this@RegistrarOptionActivity,RegistrarRolActivity::class.java))
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(this@RegistrarOptionActivity,RegistrarTipoMascotaActivity::class.java))
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(this@RegistrarOptionActivity,RegistrarUsuarioActivity::class.java))
        }
        binding.button6.setOnClickListener {
            startActivity(Intent(this@RegistrarOptionActivity,RegistrarMascotaActivity::class.java))
        }
        binding.button7.setOnClickListener {
            startActivity(Intent(this@RegistrarOptionActivity,RegistrarControlActivity::class.java))
        }
    }
}