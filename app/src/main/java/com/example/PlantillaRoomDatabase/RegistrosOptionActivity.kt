package com.example.PlantillaRoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.PlantillaRoomDatabase.databinding.ActivityRegistrosOptionBinding

class RegistrosOptionActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegistrosOptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrosOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        option()
    }
    fun option(){
        binding.button.setOnClickListener {
            startActivity(Intent(this@RegistrosOptionActivity,VacunasActivity::class.java))
        }
        binding.button2.setOnClickListener {
            startActivity(Intent(this@RegistrosOptionActivity,TipoMascotaActivity::class.java))
        }
        binding.button3.setOnClickListener {
            startActivity(Intent(this@RegistrosOptionActivity,RolActivity::class.java))
        }
        binding.button4.setOnClickListener {
            startActivity(Intent(this@RegistrosOptionActivity,UsuarioActivity::class.java))
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(this@RegistrosOptionActivity,MascotaActivity::class.java))
        }
        binding.button6.setOnClickListener {
            startActivity(Intent(this@RegistrosOptionActivity,ControlActivity::class.java))
        }
    }
}