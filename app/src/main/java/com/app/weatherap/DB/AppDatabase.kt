package com.app.weatherap.DB

import androidx.paging.DataSource
import androidx.room.*


@Database(entities = arrayOf(City::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()


@Entity
data class City(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)


@Dao
interface UserDao {
    @Query("SELECT * FROM City")
    suspend fun getAll(): DataSource.Factory<Int, List<City>>

}

