package com.example.PlantillaRoomDatabase.Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TipoMascota")
data class TipoMascota(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "name") val name:String
)
