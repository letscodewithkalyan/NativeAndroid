package com.kp.composearc.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State

class MainViewModel : ViewModel() {
    private val _theme = mutableStateOf(ThemeMode.SYSTEM)
    val theme: State<ThemeMode> = _theme

    fun setTheme(mode: ThemeMode) {
        _theme.value = mode
    }
}

enum class ThemeMode{ SYSTEM, DARK, LIGHT}
