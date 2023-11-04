package com.example.PlantillaRoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.PlantillaRoomDatabase.Adapters.TipoMascotaAdapter
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityTipoMascotaBinding

class TipoMascotaActivity : AppCompatActivity() {
    lateinit var binding: ActivityTipoMascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipoMascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter()
        fresh()
    }
    fun adapter(){
        var list = rom.daoTipoMascota().get()
        binding.recy.adapter = TipoMascotaAdapter(list)
    }

    fun fresh(){
        binding.refre.setOnRefreshListener {
            startActivity(Intent(this@TipoMascotaActivity,TipoMascotaActivity::class.java))
            binding.refre.isRefreshing = false
        }
    }
}