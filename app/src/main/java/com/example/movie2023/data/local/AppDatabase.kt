package com.example.movie2023.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class], version = 1)
abstract class  AppDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

//    //Singleton
//    companion object {
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            INSTANCE = INSTANCE ?: Room.databaseBuilder(
//                context.applicationContext, AppDatabase::class.java,
//                "movie_table"
//            ).build()
//
//            return INSTANCE!!
//        }
//
//        fun destroyInstance(){
//            INSTANCE = null
//        }
//
//    }

}