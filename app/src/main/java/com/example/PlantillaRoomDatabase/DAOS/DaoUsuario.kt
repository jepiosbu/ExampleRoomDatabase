package com.example.PlantillaRoomDatabase.DAOS

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.PlantillaRoomDatabase.Entitys.Usuario

@Dao
interface DaoUsuario {
    @Query("SELECT * FROM Usuario")
    fun get():List<Usuario>

    @Insert
    fun create(usuario: Usuario)

    @Update
    fun update(usuario: Usuario)

    @Delete
    fun delete(usuario: Usuario)
}