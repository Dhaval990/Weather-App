package com.app.weatherap.modules

import android.content.Context
import androidx.room.Room
import com.app.weatherap.DB.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class Database {
@Provides
   @Singleton
   fun provideDBInstance(@ApplicationContext applicationContext: Context): AppDatabase {
       return Room.databaseBuilder(
           applicationContext,
           AppDatabase::class.java, "AppDB"
       ).build()
   }

}