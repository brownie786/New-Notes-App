package com.example.newnotesapp.Repository

import androidx.lifecycle.LiveData
import com.example.newnotesapp.DAO.NotesDAO
import com.example.newnotesapp.Model.Notes

class NotesRepository(val dao: NotesDAO)  {

    fun getAllNotes(): LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes){
        dao.insertNotes(notes)
    }

    fun  deleteNotes(id: Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes){
        dao.updateNotes(notes)
    }
}