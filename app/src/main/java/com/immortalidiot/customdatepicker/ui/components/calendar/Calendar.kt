package com.immortalidiot.customdatepicker.ui.components.calendar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.immortalidiot.customdatepicker.ui.viewmodels.CalendarViewModel

@Composable
fun Calendar(
    viewModel: CalendarViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    Card(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
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