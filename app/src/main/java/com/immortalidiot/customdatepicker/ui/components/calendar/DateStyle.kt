package com.immortalidiot.customdatepicker.ui.components.calendar

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

object DateStyle {
    val daysOfWeek: Array<String>
        get() {
            val daysOfWeek = Array(7) { "" }
            for (day in DayOfWeek.values()) {
                val localizedDateName = day.getDisplayName(TextStyle.SHORT, Locale.getDefault())
                daysOfWeek[day.value - 1] = localizedDateName
            }
            return daysOfWeek
        }
}

/*
    The extension function that is needed for to make the days of week start on Monday
    (Russian localization)
 */
fun YearMonth.getDayStartingFromMonday(): List<LocalDate> {
    val firstDayOfMonth = LocalDate.of(year, month, 1)
    val firstMondayOfMonth = firstDayOfMonth.with(DayOfWeek.MONDAY)
    val firstDayOfNextMonth = firstDayOfMonth.plusMonths(1)

    return generateSequence(firstMondayOfMonth) {
        it.plusDays(1)
    }
        .takeWhile { it.isBefore(firstDayOfNextMonth) }
        .toList()
}

fun YearMonth.getDisplayName(): String {
    return "${month.getDisplayName(TextStyle.FULL, Locale.getDefault())} $year"
}