package com.immortalidiot.customdatepicker.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.immortalidiot.customdatepicker.ui.components.calendar.CalendarDataSource
import com.immortalidiot.customdatepicker.ui.components.calendar.CalendarUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.YearMonth

class CalendarViewModel : ViewModel() {
    private val dataSource by lazy { CalendarDataSource() }

    private val _uistate = MutableStateFlow(CalendarUiState.Init)
    val uiState: StateFlow<CalendarUiState> = _uistate.asStateFlow()

    init {
        viewModelScope.launch {
            _uistate.update {
                it.copy(dates = dataSource.getDates(it.yearMonth))
            }
        }
    }

    fun toPreviousMonth(previousMonth: YearMonth) {
        viewModelScope.launch {
            _uistate.update {
                it.copy(
                    yearMonth = previousMonth,
                    dates = dataSource.getDates(previousMonth)
                )
            }
        }
    }

    fun toNextMonth(nextMonth: YearMonth) {
        viewModelScope.launch {
            _uistate.update {
                it.copy(
                    yearMonth = nextMonth,
                    dates = dataSource.getDates(nextMonth)
                )
            }
        }
    }
}
