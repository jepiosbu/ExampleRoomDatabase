package com.example.PlantillaRoomDatabase.Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "ControlVacuna",
    foreignKeys = [
        ForeignKey(
            entity = Mascota::class,
            parentColumns = ["id"],
            childColumns = ["mascota_id"]
        ),
        ForeignKey(
            entity = Vacuna::class,
            parentColumns = ["id"],
            childColumns = ["vacuna_id"]
        )
    ]
)
data class ControlVacuna(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "mascota_id") val mascota_id:Int,
    @ColumnInfo(name = "vacuna_id") val vacuna_id:Int
)
