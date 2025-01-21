package com.example.newnotesapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.newnotesapp.Database.NotesDatabase
import com.example.newnotesapp.Model.Notes
import com.example.newnotesapp.Repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    // Properly initialize the repository
    private val repository: NotesRepository

    // Initialization block
    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDAO()
        repository = NotesRepository(dao) // Initialize the repository only once
    }

    // Function to add notes
    fun addNotes(notes: Notes) {
        repository.insertNotes(notes)
    }

    // Function to retrieve all notes as LiveData
    fun getNotes(): LiveData<List<Notes>> {
        return repository.getAllNotes()
    }

    // Function to delete a note by ID
    fun deleteNotes(id: Int) {
        repository.deleteNotes(id)
    }

    // Function to update an existing note
    fun updateNotes(notes: Notes) {
        repository.updateNotes(notes)
    }
}
