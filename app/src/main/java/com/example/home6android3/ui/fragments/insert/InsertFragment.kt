package com.example.home6android3.ui.fragments.insert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.home6android3.R
import com.example.home6android3.data.local.preference.PreferencesHelper
import com.example.home6android3.data.remote.models.Photo
import com.example.home6android3.databinding.FragmentInsertBinding
import com.example.home6android3.ui.utils.UiState
import com.google.android.material.snackbar.Snackbar

class InsertFragment : Fragment() {

    private var _binding: FragmentInsertBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<InsertViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInsertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addPhoto()
        subscribeToPhoto(view)
    }

    private fun addPhoto() = with(binding) {
        btnAdd.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val url = etUrl.text.toString().trim()
            val thumbnailUrl = etThumbnailUrl.text.toString().trim()
            PreferencesHelper.photoId = PreferencesHelper.photoId++

            viewModel.addPhoto(
                Photo(
                    albumId = 100,
                    id = PreferencesHelper.photoId,
                    title = title,
                    url = url,
                    thumbnailUrl = thumbnailUrl
                )
            )
        }
    }

    private fun subscribeToPhoto(view: View) {
        viewModel.photoLiveData.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is UiState.Loading -> {}
                is UiState.Error -> {
                    uiState.message?.let { Snackbar.make(view, it, Snackbar.LENGTH_SHORT).show() }
                }

                is UiState.Success -> {
                    Snackbar.make(view, getString(R.string.success_message), Snackbar.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}