package com.example.PlantillaRoomDatabase.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.PlantillaRoomDatabase.DAOS.DaoControlVacuna
import com.example.PlantillaRoomDatabase.DAOS.DaoMascota
import com.example.PlantillaRoomDatabase.DAOS.DaoRol
import com.example.PlantillaRoomDatabase.DAOS.DaoTipoMascota
import com.example.PlantillaRoomDatabase.DAOS.DaoUsuario
import com.example.PlantillaRoomDatabase.DAOS.DaoVacuna
import com.example.PlantillaRoomDatabase.Entitys.ControlVacuna
import com.example.PlantillaRoomDatabase.Entitys.Mascota
import com.example.PlantillaRoomDatabase.Entitys.Rol
import com.example.PlantillaRoomDatabase.Entitys.TipoMascota
import com.example.PlantillaRoomDatabase.Entitys.Usuario
import com.example.PlantillaRoomDatabase.Entitys.Vacuna

@Database(
    entities = [Vacuna::class,TipoMascota::class,Rol::class,Usuario::class,Mascota::class,ControlVacuna::class],
    version = 1
)
abstract class DB():RoomDatabase(){
    abstract fun daoVacuna(): DaoVacuna
    abstract fun daoTipoMascota(): DaoTipoMascota
    abstract fun daoRol(): DaoRol
    abstract fun daoUsuario(): DaoUsuario
    abstract fun daoMascota(): DaoMascota
    abstract fun daoControlVacuna(): DaoControlVacuna
}