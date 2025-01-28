package com.example.newnotesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newnotesapp.Model.Notes
import com.example.newnotesapp.R
import com.example.newnotesapp.databinding.ItemNotesBinding

class NotesAdapter(
    private val context: Context,
    private val notesList: List<Notes>
) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = ItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.noteTitle.text = data.title
        holder.binding.notesSubtitle.text = data.subTitle
        holder.binding.notesDate.text = data.date

        when (data.priority) {
            "1" -> holder.binding.notesPriority.setBackgroundResource(R.drawable.red_dot)
            "2" -> holder.binding.notesPriority.setBackgroundResource(R.drawable.green_dot)
            "3" -> holder.binding.notesPriority.setBackgroundResource(R.drawable.yellow_dot)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    class NotesViewHolder(val binding: ItemNotesBinding) :
        RecyclerView.ViewHolder(binding.root)
}
