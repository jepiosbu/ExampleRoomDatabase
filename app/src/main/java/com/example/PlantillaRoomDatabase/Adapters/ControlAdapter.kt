package com.example.PlantillaRoomDatabase.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.PlantillaRoomDatabase.Entitys.ControlVacuna
import com.example.PlantillaRoomDatabase.MainActivity.Companion.rom
import com.example.PlantillaRoomDatabase.databinding.AdapterControlBinding

class ControlAdapter(val control:List<ControlVacuna>):RecyclerView.Adapter<ControlAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AdapterControlBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(control[position])
    }

    override fun getItemCount(): Int {
        return control.size
    }

    class ViewHolder(private val binding: AdapterControlBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(control:ControlVacuna){
                binding.id.setText(control.id.toString())
                binding.mascota.setText(control.mascota_id.toString())
                binding.vacuna.setText(control.vacuna_id.toString())

                binding.eliminar.setOnClickListener {
                    rom.daoControlVacuna().delete(control)
                }
                binding.editar.setOnClickListener {
                    binding.mascota.isEnabled = true
                    binding.vacuna.isEnabled = true
                    binding.editar.layoutParams.width = 100
                    binding.editar.requestLayout()
                    binding.save.layoutParams.width = 100
                    binding.save.requestLayout()
                }
                binding.save.setOnClickListener {
                    var obj = ControlVacuna(
                        control.id,
                        binding.mascota.text.toString().toInt(),
                        binding.vacuna.text.toString().toInt()
                    )
                    binding.mascota.isEnabled = false
                    binding.vacuna.isEnabled = false
                    binding.editar.layoutParams.width = 200
                    binding.editar.requestLayout()
                    binding.save.layoutParams.width = 0
                    binding.save.requestLayout()
                    rom.daoControlVacuna().update(obj)
                }
            }
        }
    }