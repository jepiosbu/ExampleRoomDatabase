package com.example.PlantillaRoomDatabase.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.PlantillaRoomDatabase.Entitys.Mascota
import com.example.PlantillaRoomDatabase.MainActivity
import com.example.PlantillaRoomDatabase.databinding.AdapterMascotaBinding

class MascotaAdapter(val mascota:List<Mascota>):RecyclerView.Adapter<MascotaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = AdapterMascotaBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bin(mascota[position])
    }

    override fun getItemCount(): Int {
        return mascota.size
    }

    class ViewHolder(private val binding:AdapterMascotaBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(mascota:Mascota){
            binding.id.setText(mascota.id.toString())
            binding.name.setText(mascota.name)
            binding.edad.setText(mascota.edad.toString())
            binding.tipom.setText(mascota.tipo_mascota_id.toString())
            binding.usuario.setText(mascota.usuario_id.toString())

            binding.eliminar.setOnClickListener {
                MainActivity.rom.daoMascota().delete(mascota)
            }
            binding.editar.setOnClickListener {
                binding.name.isEnabled = true
                binding.edad.isEnabled = true
                binding.tipom.isEnabled = true
                binding.usuario.isEnabled = true
                binding.editar.layoutParams.width = 100
                binding.editar.requestLayout()
                binding.save.layoutParams.width = 100
                binding.save.requestLayout()
            }
            binding.save.setOnClickListener {
                var obj= Mascota(mascota.id,binding.name.text.toString(),binding.edad.text.toString().toInt(),binding.tipom.text.toString().toInt(),binding.usuario.text.toString().toInt())
                binding.name.isEnabled = false
                binding.edad.isEnabled = false
                binding.tipom.isEnabled = false
                binding.usuario.isEnabled = false
                binding.editar.layoutParams.width = 200
                binding.editar.requestLayout()
                binding.save.layoutParams.width = 0
                binding.save.requestLayout()
                MainActivity.rom.daoMascota().update(obj)
            }
        }
    }
}