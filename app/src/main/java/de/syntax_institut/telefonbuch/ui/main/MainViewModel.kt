package de.syntax_institut.telefonbuch.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import de.syntax_institut.telefonbuch.data.Repository
import de.syntax_institut.telefonbuch.data.datamodels.Contact
import de.syntax_institut.telefonbuch.data.local.getDatabase
import kotlinx.coroutines.launch

/**
 * Das ViewModel verwaltet die Zustände der App
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    // Die Instanz der Database wird mithilfe von getDatabase geladen und gespeichert
    // TODO
    private val database = getDatabase(application)

    // Eine Instanz (ein Objekt) des Repository wird erstellt und gepeichert
    // TODO
    private val repository = Repository(database)

    // Hier wird die Kontaktliste aus dem Repository gespeichert
    // TODO
    val contactList = repository.contactList

    // Die LiveData Variable completedAction speichert den Status der Aktion,
    // also ob der Kontakt bereits erfolgreich hinzugefügt/aktualisiert/gelöscht wurde
    // TODO
    private val _complete = MutableLiveData<Boolean>()
    val complete: LiveData<Boolean>
        get() = _complete

    /**
     * Diese Funktion fügt den Kontakt innerhalb einer Coroutine in die Database ein und setzt
     * den Status der Aktion anschließend auf erledigt
     */
    // TODO
    fun insertContact(contact: Contact) {
        viewModelScope.launch {
            repository.insert(contact)
            _complete.value = true
        }
    }

    /**
     * Diese Funktion aktualisiert den Kontakt in der Database innerhalb einer Coroutine und setzt
     * den Status der Aktion anschließend auf erledigt
     */
    // TODO
    fun updateContact(contact: Contact) {
        viewModelScope.launch {
            repository.update(contact)
            _complete.value = true
        }
    }

    /**
     * Diese Funktion löscht den Kontakt innerhalb einer Coroutine aus der Database und setzt
     * den Status der Aktion anschließend auf erledigt
     */
    // TODO
    fun deleteContact(id: Long) {
        viewModelScope.launch {
            repository.delete(id)
            _complete.value = true
        }
    }

    /**
     * Diese Funktion setzt den Status der Aktion auf "noch nicht erledigt"
     */
    // TODO
    fun unsetComplete() {
        _complete.value = false
    }
}
