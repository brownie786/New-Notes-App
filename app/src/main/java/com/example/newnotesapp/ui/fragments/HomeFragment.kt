package com.example.newnotesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.newnotesapp.R
import com.example.newnotesapp.ViewModel.NotesViewModel
import com.example.newnotesapp.databinding.FragmentHomeBinding
import com.example.newnotesapp.ui.adapter.NotesAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        binding.rcvAllNotes.layoutManager = staggeredGridLayoutManager

        binding.allNotes.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.filterHigh.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner) { notesList ->
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.filterMedium.setOnClickListener {
            viewModel.getMediumNotes().observe(viewLifecycleOwner) { notesList ->
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.filterLow.setOnClickListener {
            viewModel.getLowNotes().observe(viewLifecycleOwner) { notesList ->
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        return binding.root
    }
}