package com.example.home6android3.ui.fragments.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.home6android3.R
import com.example.home6android3.databinding.FragmentHomeBinding
import com.example.home6android3.ui.adapter.PhotoAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()
    private val photoAdapter = PhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        goToInsert()
        subscribeToPhotos()
    }

    private fun goToInsert() {
        binding.fabGoToInsert.setOnClickListener {
            findNavController().navigate(R.id.insertFragment2)
        }
    }

    private fun initialize() {
        binding.rvPhotos.adapter = photoAdapter
    }

    private fun subscribeToPhotos() {
        viewModel.getPhotos().observe(viewLifecycleOwner) { photos ->
            photos?.let {
                photoAdapter.setPhotos(photos)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}