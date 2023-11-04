package com.example.PlantillaRoomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.PlantillaRoomDatabase.Entitys.Mascota
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityRegistrarMascotaBinding

class RegistrarMascotaActivity : AppCompatActivity() {
    var list0:MutableList<String> = mutableListOf()
    var listid:MutableList<Int> = mutableListOf()
    var list1:MutableList<String> = mutableListOf()
    var list1id:MutableList<Int> = mutableListOf()
    lateinit var binding : ActivityRegistrarMascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarMascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
        create()
    }
    fun llenar(){
        var data = rom.daoTipoMascota().get()
        data.forEach {
            list0.add(it.name)
            listid.add(it.id)
        }
        var data1= rom.daoUsuario().get()
        data1.forEach {
            list1.add(it.name)
            list1id.add(it.id)
        }
        var adaptert= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list0)
        binding.txttipomascota.adapter = adaptert
        var adapteru= ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list1)
        binding.txtusuario.adapter = adapteru
    }

    fun create(){
        binding.button4.setOnClickListener {
            var obj=Mascota(0,binding.txtname.text.toString(),binding.txtedad.text.toString().toInt(),listid[binding.txttipomascota.selectedItemPosition],list1id[binding.txtusuario.selectedItemPosition])
            rom.daoMascota().create(obj)
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            super.finish()
        }
    }
}