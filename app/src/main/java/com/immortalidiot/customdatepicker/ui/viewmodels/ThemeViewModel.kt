package com.immortalidiot.customdatepicker.ui.viewmodels

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ThemeViewModel : ViewModel() {

    @Immutable
    sealed class ThemeState {
        object Light : ThemeState()
        object Dark : ThemeState()
        object System : ThemeState()
    }

    private val mutableState = MutableStateFlow<ThemeState>(ThemeState.System)
    val immutableState: StateFlow<ThemeState> = mutableState.asStateFlow()

    fun onLightTheme() { mutableState.value = ThemeState.Light }
    fun onDarkTheme() { mutableState.value = ThemeState.Dark }
    fun onSystemTheme() { mutableState.value = ThemeState.System }
}
