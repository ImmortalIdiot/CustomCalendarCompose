package com.immortalidiot.customdatepicker.ui.components

import android.widget.CalendarView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun CustomDatePicker(
    modifier: Modifier = Modifier
) {
    var date by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AndroidView(
            factory = {
                CalendarView(it)
            },
            update = {
                it.setOnDateChangeListener {
                        _, year, month, day ->
                    date = "$day - ${month + 1} - $year"
                }
            })
    }
}

@Preview
@Composable
fun CustomDatePickerPreview() {
    CustomDatePicker()
}