package com.example.PlantillaRoomDatabase.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.PlantillaRoomDatabase.Entitys.TipoMascota
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.TipomascotaAdapterBinding

class TipoMascotaAdapter(val tipomascota:List<TipoMascota>) : RecyclerView.Adapter<TipoMascotaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =
            TipomascotaAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bin(tipomascota[position])
    }

    override fun getItemCount(): Int {
        return tipomascota.size
    }

    class ViewHolder(private val binding: TipomascotaAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bin(tipomascota: TipoMascota) {
            binding.id.setText(tipomascota.id.toString())
            binding.name.setText(tipomascota.name)
            binding.eliminar.setOnClickListener {
                rom.daoTipoMascota().delete(tipomascota)
            }
            binding.editar.setOnClickListener {
                binding.editar.layoutParams.width = 100
                binding.editar.requestLayout()
                binding.save.layoutParams.width = 100
                binding.save.requestLayout()
                binding.name.isEnabled = true
            }
            binding.save.setOnClickListener {
                binding.editar.layoutParams.width = 200
                binding.editar.requestLayout()
                binding.save.layoutParams.width = 0
                binding.save.requestLayout()
                binding.name.isEnabled = false
                var obj = TipoMascota(tipomascota.id, binding.name.text.toString())
                rom.daoTipoMascota().update(obj)
            }
        }
    }
}