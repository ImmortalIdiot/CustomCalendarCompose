package com.immortalidiot.customdatepicker.ui.components.calendar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.immortalidiot.customdatepicker.ui.viewmodels.CalendarViewModel

@Composable
fun Calendar(
    viewModel: CalendarViewModel = CalendarViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        CustomCalendarWidget(
            days = DateStyle.daysOfWeek,
            yearMonth = uiState.yearMonth,
            dates = uiState.dates,
            onPreviousMonth = { previousMonth ->
                viewModel.toPreviousMonth(previousMonth)
            },
            onNextMonth = { nextMonth ->
                viewModel.toNextMonth(nextMonth)
            },
            onDateClickListener = {
                // TODO: show timetable
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CalendarPreview() {
    Calendar()
}