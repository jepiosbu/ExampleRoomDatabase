package com.example.PlantillaRoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.PlantillaRoomDatabase.Adapters.RolAdapter
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityRolBinding

class RolActivity : AppCompatActivity() {
    lateinit var binding : ActivityRolBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRolBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
        fresh()
    }
    fun llenar(){
        var obj = rom.daoRol().get()
        binding.recy.adapter = RolAdapter(obj)
    }
    fun fresh(){
        binding.refre.setOnRefreshListener {
            startActivity(Intent(this@RolActivity,RolActivity::class.java))
            binding.refre.isRefreshing = false
        }
    }
}