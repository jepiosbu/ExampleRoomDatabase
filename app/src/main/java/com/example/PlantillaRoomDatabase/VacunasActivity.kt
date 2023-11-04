package com.example.PlantillaRoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.PlantillaRoomDatabase.Adapters.VacunasAdapter
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityVacunasBinding

class VacunasActivity : AppCompatActivity() {
    lateinit var binding: ActivityVacunasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVacunasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
        refrescar()
    }
     fun llenar(){
         var vacuna= rom.daoVacuna().get()
         binding.recy.adapter = VacunasAdapter(vacuna)

     }
    fun refrescar(){
        binding.refrescar.setOnRefreshListener {
            startActivity(Intent(this@VacunasActivity,VacunasActivity::class.java))
            binding.refrescar.isRefreshing = false
        }
    }

}