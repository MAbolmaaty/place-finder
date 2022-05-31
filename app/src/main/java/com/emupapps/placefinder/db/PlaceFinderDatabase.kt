package com.emupapps.placefinder.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.emupapps.placefinder.model.Bookmark

@Database(entities = arrayOf(Bookmark::class), version = 1)
abstract class PlaceFinderDatabase : RoomDatabase() {

    abstract fun bookmarkDao(): BookmarkDao

    companion object {

        private var instance: PlaceFinderDatabase? = null

        fun getInstance(context: Context): PlaceFinderDatabase {
            if (instance == null) {

                instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlaceFinderDatabase::class.java,
                    "PlaceFinder"
                ).build()
            }
            return instance as PlaceFinderDatabase
        }
    }
}