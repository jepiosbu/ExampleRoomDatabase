package com.example.PlantillaRoomDatabase

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.PlantillaRoomDatabase.Entitys.ControlVacuna
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityRegistrarControlBinding

class RegistrarControlActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegistrarControlBinding
    var list0:MutableList<String> = mutableListOf()
    var listid:MutableList<Int> = mutableListOf()
    var list1:MutableList<String> = mutableListOf()
    var list1id:MutableList<Int> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarControlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
        create()
    }
    fun llenar(){
        var data = MainActivity.rom.daoMascota().get()
        data.forEach {
            list0.add(it.name)
            listid.add(it.id)
        }
        var data1= MainActivity.rom.daoVacuna().get()
        data1.forEach {
            list1.add(it.name)
            list1id.add(it.id)
        }
        var adaptert= ArrayAdapter<String>(this, R.layout.simple_list_item_1,list0)
        binding.txtmascota.adapter = adaptert
        var adapteru= ArrayAdapter<String>(this, R.layout.simple_list_item_1,list1)
        binding.txtvacuna.adapter = adapteru
    }
    fun create(){
        binding.button4.setOnClickListener {
            var obj=ControlVacuna(0,listid[binding.txtmascota.selectedItemPosition],list1id[binding.txtvacuna.selectedItemPosition])
            rom.daoControlVacuna().create(obj)
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            super.finish()
        }
    }
}