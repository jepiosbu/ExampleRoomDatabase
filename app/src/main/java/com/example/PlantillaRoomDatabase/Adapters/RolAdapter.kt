package com.example.PlantillaRoomDatabase.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.PlantillaRoomDatabase.Entitys.Rol
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.AdapterRolBinding


class RolAdapter(val rol:List<Rol>):RecyclerView.Adapter<RolAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AdapterRolBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(rol[position])
    }

    override fun getItemCount(): Int {
        return rol.size
    }

    class ViewHolder(private val binding: AdapterRolBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(rol:Rol){
            binding.id.setText(rol.id.toString())
            binding.name.setText(rol.name)
            binding.eliminar.setOnClickListener {
                rom.daoRol().delete(rol)
            }
            binding.editar.setOnClickListener {
                binding.name.isEnabled = true
                binding.editar.layoutParams.width = 100
                binding.editar.requestLayout()
                binding.save.layoutParams.width = 100
                binding.save.requestLayout()
            }
            binding.save.setOnClickListener {
                var obj = Rol(rol.id,binding.name.text.toString())
                rom.daoRol().update(obj)
                binding.name.isEnabled = false
                binding.editar.layoutParams.width = 200
                binding.editar.requestLayout()
                binding.save.layoutParams.width = 0
                binding.save.requestLayout()
            }
        }
    }
}