package com.immortalidiot.customdatepicker.ui.components.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.immortalidiot.customdatepicker.ui.theme.boldLato12
import com.immortalidiot.customdatepicker.ui.theme.classicGray
import java.time.YearMonth

@Composable
fun Header(
    yearMonth: YearMonth,
    onPreviousMonth: (YearMonth) -> Unit,
    onNextMonth: (YearMonth) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = {
                onPreviousMonth.invoke(yearMonth.minusMonths(1))
            }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                tint = classicGray,
                contentDescription = "previous month"
            )
        }
        Text(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .align(Alignment.CenterVertically),
            text = yearMonth.getDisplayName(),
            textAlign = TextAlign.Center,
            style = boldLato12.copy(color = classicGray)
        )
        IconButton(
            onClick = {
                onNextMonth.invoke(yearMonth.plusMonths(1))
            }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                tint = classicGray,
                contentDescription = "next month"
            )
        }
    }
}