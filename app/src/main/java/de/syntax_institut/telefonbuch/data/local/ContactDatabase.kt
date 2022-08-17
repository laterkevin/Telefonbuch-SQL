package de.syntax_institut.telefonbuch.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntax_institut.telefonbuch.data.datamodels.Contact


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase: RoomDatabase() {
    abstract val contactDatabaseDao: ContactDatabaseDao
}

private lateinit var  INSTANCE: ContactDatabase

fun getDatabase(context: Context): ContactDatabase {
    synchronized(ContactDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                ContactDatabase::class.java,
                "contact_deluxe_database"
            )
                .build()
        }
    }
    return INSTANCE
}