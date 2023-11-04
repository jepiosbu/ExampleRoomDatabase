package com.example.PlantillaRoomDatabase.DAOS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.PlantillaRoomDatabase.Entitys.TipoMascota

@Dao
interface DaoTipoMascota {
    @Query("SELECT * FROM TipoMascota")
    fun get():List<TipoMascota>

    @Insert
    fun create(tipoMascota: TipoMascota)

    @Update
    fun update(tipoMascota: TipoMascota)

    @Delete
    fun delete(tipoMascota: TipoMascota)
}