package com.example.PlantillaRoomDatabase.DAOS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.PlantillaRoomDatabase.Entitys.Mascota

@Dao
interface DaoMascota {
    @Query("SELECT * FROM Mascota")
    fun get():List<Mascota>

    @Insert
    fun create(mascota: Mascota)

    @Update
    fun update(mascota: Mascota)

    @Delete
    fun delete(mascota: Mascota)
}