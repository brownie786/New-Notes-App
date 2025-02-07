package com.example.newnotesapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.newnotesapp.Model.Notes
import com.example.newnotesapp.R
import com.example.newnotesapp.ViewModel.NotesViewModel
import com.example.newnotesapp.databinding.FragmentCreateNotesBinding
import java.util.Date

class CreateNotesFragment : Fragment() {

    private lateinit var binding: FragmentCreateNotesBinding
    var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)

        binding.pRed.setOnClickListener {
            priority = "1"
            binding.pRed.setImageResource(R.drawable.baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.pGreen.setOnClickListener {
            priority = "2"
            binding.pGreen.setImageResource(R.drawable.baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.pYellow.setOnClickListener {
            priority = "3"
            binding.pYellow.setImageResource(R.drawable.baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)
        }

        binding.btnCreateSaveNotes.setOnClickListener {
             createNotes(it)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {
        val title = binding.editTitle.text.toString()
        val subTitle = binding.editSubTitle.text.toString()
        val notes = binding.editNotes.text.toString()

        // to get current system time
        val d = Date()
        val notesDate: CharSequence = android.text.format.DateFormat.format("MMMM d, yyyy", d.time)

        val data = Notes(
            null,
            title = title,
            subTitle = subTitle,
            notes = notes,
            date = notesDate.toString(),
            priority
        )
        viewModel.addNotes(data)

        Toast.makeText(requireContext(), "Notes Created Successfully", Toast.LENGTH_SHORT).show()

        Log.e("@@@@@", "createNotes: $notesDate")

        Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
    }

}