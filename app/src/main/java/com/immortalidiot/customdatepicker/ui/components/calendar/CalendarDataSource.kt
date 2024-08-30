package com.immortalidiot.customdatepicker.ui.components.calendar

import java.time.LocalDate
import java.time.YearMonth

class CalendarDataSource {

    fun getDates(yearMonth: YearMonth): List<CalendarUiState.Date> {
        return yearMonth
            .getDayStartingFromMonday()
            .map {
                CalendarUiState.Date(
                    dayOfMonth = if (it.monthValue == yearMonth.monthValue) {
                        "${it.dayOfMonth}"
                    } else {
                        ""
                        // TODO: fill the inactive days (days of the previous and next months)
                    },
                    isSelected = it.isEqual(LocalDate.now())
                            && it.monthValue == yearMonth.monthValue
                )
            }
    }
}
