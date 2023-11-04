package com.example.PlantillaRoomDatabase.DAOS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.PlantillaRoomDatabase.Entitys.Rol

@Dao
interface DaoRol {
    @Query("SELECT * FROM Rol")
    fun get():List<Rol>

    @Insert
    fun create(rol: Rol)

    @Update
    fun update(rol: Rol)

    @Delete
    fun delete(rol :Rol)
}