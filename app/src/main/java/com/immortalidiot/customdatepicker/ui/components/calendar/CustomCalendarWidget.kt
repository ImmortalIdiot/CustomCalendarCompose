package com.immortalidiot.customdatepicker.ui.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.immortalidiot.customdatepicker.ui.theme.ClassicGray
import com.immortalidiot.customdatepicker.ui.theme.LocalDimensions
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
    val dimensions = LocalDimensions.current
    val scheme = MaterialTheme.colorScheme
    val textColor = ClassicGray

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = scheme.onBackground)
            .padding(
                start = dimensions.horizontalEnlargedPadding,
                end = dimensions.horizontalEnlargedPadding
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Header(
            modifier = modifier,
            yearMonth = yearMonth,
            onPreviousMonth = onPreviousMonth,
            onNextMonth = onNextMonth
        )
        Column(
            modifier = modifier.border(
                shape = RoundedCornerShape(dimensions.shapeXLarge),
                color = textColor,
                width = dimensions.smallThickness
            ),
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
            Divider(
                modifier = modifier.fillMaxWidth(0.95f),
                color = textColor,
                thickness = dimensions.smallestThickness
            )
            Content(
                modifier = modifier,
                dates = dates,
                onDateClickListener = onDateClickListener
            )
        }
    }
}
