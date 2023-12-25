package com.example.mynotes.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.mynotes.MainActivity
import com.example.mynotes.databinding.FragmentLanguageBinding
import com.example.mynotes.utils.Constants
import com.example.mynotes.viewmodels.LanguageViewModel

class LanguageFragment : Fragment() {
    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = _binding!!

    private val languageViewModel by activityViewModels<LanguageViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLanguageBinding.inflate(inflater, container, false)
        binding.applyButton.setOnClickListener{
            onApplyLanguage()
        }
        return binding.root
    }

    fun onApplyLanguage(){
         val checkedButtonId = binding.languageGroup.checkedRadioButtonId
         if(checkedButtonId == binding.englishButton.id){
             languageViewModel.saveLanguage(Constants.ENGLISH)
         }else if(checkedButtonId == binding.arabicButton.id){
             languageViewModel.saveLanguage(Constants.ARABIC)
         }else if(checkedButtonId == binding.frenchButton.id){
             languageViewModel.saveLanguage(Constants.FRENCH)
         }

        val intent = Intent(activity,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity?.startActivity(intent)
    }
}