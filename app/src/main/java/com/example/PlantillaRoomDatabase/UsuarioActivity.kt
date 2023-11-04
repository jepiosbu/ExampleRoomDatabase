package com.example.PlantillaRoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.PlantillaRoomDatabase.Adapters.UsuarioAdapter
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityUsuarioBinding

class UsuarioActivity : AppCompatActivity() {
    lateinit var binding: ActivityUsuarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
        refresh()
    }
    fun llenar(){
        var obj = rom.daoUsuario().get()
        binding.recy.adapter = UsuarioAdapter(obj)
    }

    fun refresh(){
        binding.refre.setOnRefreshListener{
            binding.refre.isRefreshing = false
            startActivity(Intent(this@UsuarioActivity,UsuarioActivity::class.java))
        }
    }
}