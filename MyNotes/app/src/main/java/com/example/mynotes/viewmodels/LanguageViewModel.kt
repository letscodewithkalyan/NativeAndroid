package com.example.mynotes.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mynotes.utils.Constants
import com.example.mynotes.utils.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var preferences: Preferences
    fun saveLanguage(language: String){
        preferences.saveString(Constants.USER_LANGUAGE, language)
    }
}