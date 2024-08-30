package com.immortalidiot.customdatepicker.ui.components.calendar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.immortalidiot.customdatepicker.ui.viewmodels.CalendarViewModel

@Composable
fun Calendar(
    calendarViewModel: CalendarViewModel
) {
    val uiState by calendarViewModel.uiState.collectAsState()

    CustomCalendarWidget(
        days = DateStyle.daysOfWeek,
        yearMonth = uiState.yearMonth,
        dates = uiState.dates,
        onPreviousMonth = { previousMonth ->
            calendarViewModel.toPreviousMonth(previousMonth)
        },
        onNextMonth = { nextMonth ->
            calendarViewModel.toNextMonth(nextMonth)
        },
        onDateClickListener = { selectedDate ->
            calendarViewModel.selectDate(selectedDate)
        }
    )
}

@Preview(showSystemUi = true)
@Composable
fun CalendarPreview() {
    val calendarViewModel: CalendarViewModel = viewModel()
    Calendar(calendarViewModel = calendarViewModel)
}
