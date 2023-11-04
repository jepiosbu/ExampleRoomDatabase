package com.example.PlantillaRoomDatabase.Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Usuario",
    foreignKeys = [
        ForeignKey(
            entity = Rol::class,
            parentColumns = ["id"],
            childColumns = ["rol_id"]
        )
    ]
)
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "correo") val correo:String,
    @ColumnInfo(name = "password") val password:String,
    @ColumnInfo(name = "rol_id") val rol_id:Int
)
