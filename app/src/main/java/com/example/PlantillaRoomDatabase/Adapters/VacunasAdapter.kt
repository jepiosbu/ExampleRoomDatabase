package com.example.PlantillaRoomDatabase.Adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.PlantillaRoomDatabase.Entitys.Vacuna
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.AdapterVacunasBinding


class VacunasAdapter(val vacunas: List<Vacuna>):RecyclerView.Adapter<VacunasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterVacunasBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return vacunas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bin(vacunas[position])
    }

    class ViewHolder(private val binding: AdapterVacunasBinding): RecyclerView.ViewHolder(binding.root){
        fun bin(vacuna:Vacuna){
            binding.id.setText(vacuna.id.toString())
            binding.name.setText(vacuna.name)
            binding.eliminar.setOnClickListener {
                rom.daoVacuna().delete(vacuna)
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
                var obj = Vacuna(vacuna.id,binding.name.text.toString())
                rom.daoVacuna().put(obj)
            }
        }
    }
}