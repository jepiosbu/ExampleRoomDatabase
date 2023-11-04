package com.example.PlantillaRoomDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.PlantillaRoomDatabase.Entitys.Usuario
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.ActivityRegistrarUsuarioBinding

class RegistrarUsuarioActivity : AppCompatActivity() {
    var list:MutableList<String> = mutableListOf()
    var list1:MutableList<Int> = mutableListOf()
    lateinit var binding: ActivityRegistrarUsuarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenar()
        create()
    }
    fun llenar(){
        var rol= rom.daoRol().get()
        rol.forEach {
            list.add(it.name)
            list1.add(it.id)
        }
        var adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)
        binding.txtrol.adapter = adapter
    }
    fun create()
    {
        binding.button4.setOnClickListener {
            var obj= Usuario(0,binding.txtname.text.toString(),binding.txtcorreo.text.toString(),binding.txtpassword.text.toString(),list1[binding.txtrol.selectedItemPosition])
            rom.daoUsuario().create(obj)
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            super.finish()
        }
    }
}