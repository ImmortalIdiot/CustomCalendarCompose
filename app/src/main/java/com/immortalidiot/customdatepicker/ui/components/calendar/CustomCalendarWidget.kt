package com.immortalidiot.customdatepicker.ui.components.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.immortalidiot.customdatepicker.ui.theme.lightGray
import java.time.YearMonth

@Composable
fun CustomCalendarWidget(
    modifier: Modifier = Modifier,
    days: Array<String>,
    yearMonth: YearMonth,
    dates: List<CalendarUiState.Date>,
    onPreviousMonth: (YearMonth) -> Unit,
    onNextMonth: (YearMonth) -> Unit,
    onDateClickListener: (CalendarUiState.Date) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            repeat(days.size) {
                val item = days[it]
                DayOfWeekItem(
                    day = item,
                    modifier = modifier.weight(1f)
                )
            }
        }
        Header(
            yearMonth = yearMonth,
            onPreviousMonth = onPreviousMonth,
            onNextMonth = onNextMonth
        )
        Divider(
            modifier = modifier.fillMaxWidth(0.9f),
            color = lightGray,
            thickness = 1.dp
        )
        Spacer(modifier = modifier.padding(bottom = 20.dp))
        Content(
            dates = dates,
            onDateClickListener = onDateClickListener
        )
    }
}
