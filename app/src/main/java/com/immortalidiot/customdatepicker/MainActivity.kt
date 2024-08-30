package com.immortalidiot.customdatepicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.immortalidiot.customdatepicker.ui.components.calendar.Calendar
import com.immortalidiot.customdatepicker.ui.theme.CustomDatePickerTheme
import com.immortalidiot.customdatepicker.ui.viewmodels.CalendarViewModel
import com.immortalidiot.customdatepicker.ui.viewmodels.ThemeViewModel

class MainActivity : ComponentActivity() {
    private val themeViewModel: ThemeViewModel by viewModels()
    private val calendarViewModel: CalendarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val currentTheme by themeViewModel.immutableState.collectAsState()
            val darkTheme = when (currentTheme) {
                ThemeViewModel.ThemeState.Dark -> true
                ThemeViewModel.ThemeState.Light -> false
                ThemeViewModel.ThemeState.System -> isSystemInDarkTheme()
            }

            CustomDatePickerTheme(darkTheme = darkTheme) {
                Calendar(calendarViewModel = calendarViewModel)
            }
        }
    }
}
