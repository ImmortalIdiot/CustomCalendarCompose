package com.immortalidiot.customdatepicker.ui.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.immortalidiot.customdatepicker.ui.theme.ClassicGray
import com.immortalidiot.customdatepicker.ui.theme.boldLato14
import com.immortalidiot.customdatepicker.ui.theme.mediumInter12

@Composable
fun Content(
    dates: List<CalendarUiState.Date>,
    onDateClickListener: (CalendarUiState.Date) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column {
        var index = 0
        repeat(6) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(7) {
                    val item = if (index < dates.size) {
                        dates[index]
                    } else {
                        CalendarUiState.Date.Empty
                    }

                    ContentItem(
                        date = item,
                        onClickListener = if (item != CalendarUiState.Date.Empty) {
                            onDateClickListener
                        } else {
                            null
                        },
                        modifier = modifier.weight(1f)
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
    onClickListener: ((CalendarUiState.Date) -> Unit)?,
    modifier: Modifier = Modifier
) {
    val scheme = MaterialTheme.colorScheme

    Box(
        modifier = modifier.clickable(
            enabled = onClickListener != null,
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            onClickListener?.invoke(date)
        },
        contentAlignment = Alignment.Center
    ) {
        if (date.isSelected) {
            Box(
                modifier = modifier
                    .size(40.dp)
                    .clip(shape = CircleShape)
                    .background(color = scheme.primary),
                contentAlignment = Alignment.Center
            ) {
                ItemText(
                    modifier = modifier,
                    text = date.dayOfMonth,
                    color = scheme.primaryContainer
                )
            }
        } else {
            ItemText(
                modifier = modifier,
                text = date.dayOfMonth,
                color = ClassicGray
            )
        }
    }
}

@Composable
fun ItemText(
    color: Color,
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier.padding(12.dp),
        text = text,
        style = boldLato14,
        color = color,
        textAlign = TextAlign.Center
    )
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
            text = day.uppercase(),
            style = mediumInter12.copy(color = ClassicGray)
        )
    }
}
