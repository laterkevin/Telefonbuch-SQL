package de.syntax_institut.telefonbuch.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import de.syntax_institut.telefonbuch.data.datamodels.Contact

@Dao
interface ContactDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Query("SELECT * FROM contact_list")
    fun getAll(): LiveData<List<Contact>>

    @Query("SELECT * FROM contact_list WHERE id = :id")
    fun getByID(id:Long): LiveData<Contact>

    @Query("DELETE FROM contact_list WHERE id = :id")
    suspend fun deleteById(id: Long)
}