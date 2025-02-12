package com.example.newnotesapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newnotesapp.DAO.NotesDAO
import com.example.newnotesapp.Model.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {
// abstract class fun's do not have fun body

    abstract fun myNotesDAO(): NotesDAO

    companion object{
        @Volatile //it means this can be easily accessed
         var INSTANCE: NotesDatabase?= null

        fun getDatabaseInstance(context: Context): NotesDatabase{

            val tempInstance= INSTANCE
            if(tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val roomDatabaseInstance =
                    Room.databaseBuilder(context, NotesDatabase::class.java, "Notes").allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }
        }
    }

}