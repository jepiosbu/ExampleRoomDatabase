package com.example.PlantillaRoomDatabase.DAOS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.PlantillaRoomDatabase.Entitys.ControlVacuna

@Dao
interface DaoControlVacuna {
    @Query("SELECT * FROM ControlVacuna")
    fun get():List<ControlVacuna>

    @Insert
    fun create(controlVacuna: ControlVacuna)

    @Update
    fun update(controlVacuna: ControlVacuna)

    @Delete
    fun delete(controlVacuna: ControlVacuna)
}