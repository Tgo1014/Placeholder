package tgo1014.placeholder.data.repositories.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import tgo1014.placeholder.data.repositories.daos.AnyDao
import tgo1014.placeholder.data.repositories.database.converters.AnyTypeConverter

@Database(entities = [], version = 1)
//@Database(entities = [(Artist::class), (BasicArtist::class)], version = 4)
@TypeConverters(AnyTypeConverter::class)

abstract class AppDatabase : RoomDatabase() {
    abstract fun anyDao(): AnyDao
}