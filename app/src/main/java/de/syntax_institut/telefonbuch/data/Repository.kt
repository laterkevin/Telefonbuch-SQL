package de.syntax_institut.telefonbuch.data

import android.util.Log
import androidx.lifecycle.LiveData
import de.syntax_institut.telefonbuch.data.datamodels.Contact
import de.syntax_institut.telefonbuch.data.local.ContactDatabase

const val TAG = "Repository"

/**
 * Hier werden die Daten aus der Database verwaltet
 */
class Repository(private val database: ContactDatabase) {

    // Speichert das Ergebnis der getAll() Anfrage des DAO als LiveData
    // TODO
    val contactList: LiveData<List<Contact>> = database.contactDatabaseDao.getAll()

    /**
     * Diese Funktion versucht mittels der insert Funktion des DAO einen neuen Kontakt einzufügen
     */
    // TODO
    suspend fun insert(contact: Contact) {
        try {
            database.contactDatabaseDao.insert(contact)
        } catch (e: Exception) {
            Log.d(TAG, "Failed to insert into Database: $e")
        }
    }

    /**
     * Diese Funktion versucht mittels der update Funktion des DAO einen Kontakt zu aktualisieren
     */
    // TODO
    suspend fun update(contact: Contact) {
        try {
            database.contactDatabaseDao.update(contact)
        } catch (e: Exception) {
            Log.d(TAG, "Failed to update Database: $e")
        }
    }

    /**
     * Diese Funktion versucht mittels der delete Funktion des DAO einen Kontakt zu löschen
     */
    // TODO
    suspend fun delete(id: Long) {
        try {
            database.contactDatabaseDao.deleteById(id)
        } catch (e: Exception) {
            Log.d(TAG, "Failed to delete from Database: $e")
        }
    }
}
