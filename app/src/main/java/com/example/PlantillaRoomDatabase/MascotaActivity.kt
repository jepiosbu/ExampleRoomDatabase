package com.example.PlantillaRoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.PlantillaRoomDatabase.Adapters.MascotaAdapter
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityMascotaBinding

class MascotaActivity : AppCompatActivity() {
    lateinit var binding : ActivityMascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
        refre()
    }
    fun llenar(){
        var obj = rom.daoMascota().get()
        binding.recy.adapter = MascotaAdapter(obj)
    }
    fun refre(){
        binding.refre.setOnRefreshListener {
            binding.refre.isRefreshing = false
            startActivity(Intent(this@MascotaActivity,MascotaActivity::class.java))
        }
    }
}