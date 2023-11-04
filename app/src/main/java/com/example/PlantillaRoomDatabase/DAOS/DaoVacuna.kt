package com.example.PlantillaRoomDatabase.DAOS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.PlantillaRoomDatabase.Entitys.Vacuna

@Dao
interface DaoVacuna {
    @Query("SELECT * FROM Vacuna")
    fun get() : List<Vacuna>

    @Insert
    fun post(vacuna:Vacuna)

    @Update
    fun put(vacuna: Vacuna)

    @Delete
    fun delete(vacuna: Vacuna)
}