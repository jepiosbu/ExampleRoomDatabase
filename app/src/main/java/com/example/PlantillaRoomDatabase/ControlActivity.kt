package com.example.PlantillaRoomDatabase

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.PlantillaRoomDatabase.Adapters.ControlAdapter
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityControlBinding

class ControlActivity : AppCompatActivity() {
    lateinit var binding: ActivityControlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityControlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
        refre()
    }

    fun llenar()  {
        var obj = rom.daoControlVacuna().get()
        binding.recy.adapter = ControlAdapter(obj)
    }

    fun refre()  {
        binding.refe.setOnRefreshListener {
            binding.refe.isRefreshing = false
            startActivity(Intent(this@ControlActivity, ControlActivity::class.java))
        }
    }
}
