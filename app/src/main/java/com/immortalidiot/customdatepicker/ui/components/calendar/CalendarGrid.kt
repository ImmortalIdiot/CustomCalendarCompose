package com.immortalidiot.customdatepicker.ui.components.calendar

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.immortalidiot.customdatepicker.ui.theme.boldInter10
import com.immortalidiot.customdatepicker.ui.theme.boldInter14
import com.immortalidiot.customdatepicker.ui.theme.boldLato12
import com.immortalidiot.customdatepicker.ui.theme.classicGray
import com.immortalidiot.customdatepicker.ui.theme.primaryDarkBlue

@Composable
fun Content(
    dates: List<CalendarUiState.Date>,
    onDateClickListener: (CalendarUiState.Date) -> Unit,
) {
    Column(
        modifier = Modifier
            .border(
                shape = RoundedCornerShape(16.dp),
                color = primaryDarkBlue,
                width = 4.dp
            )
    ) {
        var index = 0
        repeat(6) {
            if (index >= dates.size) return@repeat
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(7) {
                    val item = if (index < dates.size) dates[index]
                    else CalendarUiState.Date.Empty
                    ContentItem(
                        date = item,
                        onClickListener = onDateClickListener,
                        modifier = Modifier.weight(1f)
                    )
                    index++
                }
            }
        }
    }
}

@Composable
fun ContentItem(
    date: CalendarUiState.Date,
    onClickListener: (CalendarUiState.Date) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.clickable { onClickListener(date) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = modifier
                .align(Alignment.Center)
                .padding(12.dp),
            text = date.dayOfMonth,
            style = boldLato12,
            color = if (date.isSelected) primaryDarkBlue
            else classicGray
        )
    }
}

@Composable
fun DayOfWeekItem(
    day: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = modifier
                .align(Alignment.Center)
                .padding(12.dp),
            text = day,
            style = boldLato12
        )
    }
}
