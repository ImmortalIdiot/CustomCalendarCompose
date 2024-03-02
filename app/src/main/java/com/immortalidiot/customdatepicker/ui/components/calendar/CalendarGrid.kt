package com.immortalidiot.customdatepicker.ui.components.calendar

import android.content.ClipData.Item
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.immortalidiot.customdatepicker.ui.theme.boldInter10
import com.immortalidiot.customdatepicker.ui.theme.classicGray
import com.immortalidiot.customdatepicker.ui.theme.primaryDarkBlue
import com.immortalidiot.customdatepicker.ui.theme.semiBold10

@Composable
fun Content(
    dates: List<CalendarUiState.Date>,
    onDateClickListener: (CalendarUiState.Date) -> Unit
) {
    Column {
        var index = 0
        repeat(6) {
            if (index >= dates.size) return@repeat
            Row {
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
        modifier = modifier
            .clickable {
                onClickListener(date)
            }
    ) {
        Text(
            text = date.dayOfMonth,
            style = boldInter10.copy(color = if (date.isSelected) primaryDarkBlue
                                             else classicGray),
            modifier = modifier
                .align(Alignment.Center)
                .padding(10.dp)
        )
    }
}

@Composable
fun Item(
    day: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Text(
            modifier = modifier
                .align(Alignment.Center)
                .padding(10.dp),
            text = day,
            style = semiBold10
        )
    }
}