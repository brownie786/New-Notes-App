package com.example.newnotesapp.Repository

import androidx.lifecycle.LiveData
import com.example.newnotesapp.DAO.NotesDAO
import com.example.newnotesapp.Model.Notes

class NotesRepository(val dao: NotesDAO)  {

    fun getAllNotes(): LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun getHighNotes(): LiveData<List<Notes>> {
        return dao.getHighNotes()
    }

    fun getMediumNotes(): LiveData<List<Notes>> {
        return dao.getMediumNotes()
    }

    fun getLowNotes(): LiveData<List<Notes>> {
        return dao.getLowNotes()
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