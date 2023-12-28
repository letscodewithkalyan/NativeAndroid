package com.example.mynotes.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.FileUtils
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import com.example.mynotes.R
import com.example.mynotes.databinding.FragmentLoginBinding
import com.example.mynotes.databinding.FragmentRegistrationBinding
import com.example.mynotes.viewmodels.AuthViewModel

class RegistrationFragment : Fragment() {

    private var _binding:FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addClickListeners()
    }

    var cameraUri : Uri? = null
    fun addClickListeners()
    {
        binding.pencilIcon.setOnClickListener {
            var cameraUri =  com.example.mynotes.utils.FileUtils.getImageUri(this.requireContext());
            val camerIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            camerIntent.putExtra(MediaStore.EXTRA_OUTPUT,cameraUri)
            cameraLauncher.launch(camerIntent)
        }
    }

    var cameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK && result.data?.data != null)
        {
            binding.userImage.setImageURI(result.data?.data);
            //Todo
        }
    }
}