package com.example.PlantillaRoomDatabase.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.PlantillaRoomDatabase.Entitys.Usuario
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.AdapterUsuarioBinding

class UsuarioAdapter(val usuario: List<Usuario>):RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AdapterUsuarioBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(usuario[position])
    }

    override fun getItemCount(): Int {
        return usuario.size
    }

    class ViewHolder(val binding: AdapterUsuarioBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(usuario: Usuario){
            binding.id.setText(usuario.id.toString())
            binding.name.setText(usuario.name)
            binding.correo.setText(usuario.correo)
            binding.password.setText(usuario.password)
            binding.rol.setText(usuario.rol_id.toString())

            binding.eliminar.setOnClickListener {
                rom.daoUsuario().delete(usuario)
            }
            binding.editar.setOnClickListener {
                binding.name.isEnabled = true
                binding.correo.isEnabled = true
                binding.password.isEnabled = true
                binding.rol.isEnabled = true
                binding.editar.layoutParams.width = 100
                binding.editar.requestLayout()
                binding.save.layoutParams.width = 100
                binding.save.requestLayout()
            }
            binding.save.setOnClickListener {
                var obj=Usuario(usuario.id,binding.name.text.toString(),binding.correo.text.toString(),binding.password.text.toString(),binding.rol.text.toString().toInt())
                binding.name.isEnabled = false
                binding.correo.isEnabled = false
                binding.password.isEnabled = false
                binding.rol.isEnabled = false
                binding.editar.layoutParams.width = 200
                binding.editar.requestLayout()
                binding.save.layoutParams.width = 0
                binding.save.requestLayout()
                rom.daoUsuario().update(obj)
            }
        }
    }
}