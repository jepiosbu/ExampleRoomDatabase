package com.example.PlantillaRoomDatabase.Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Mascota",
    foreignKeys = [
            ForeignKey(
                entity = TipoMascota::class,
                parentColumns = ["id"],
                childColumns = ["tipo_mascota_id"],
            ),
            ForeignKey(
                entity = Usuario::class,
                parentColumns = ["id"],
                childColumns = ["usuario_id"]
            )
        ]
    )
data class Mascota(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "edad") val edad:Int,
    @ColumnInfo(name = "tipo_mascota_id") val tipo_mascota_id:Int,
    @ColumnInfo(name = "usuario_id") val usuario_id:Int
)
