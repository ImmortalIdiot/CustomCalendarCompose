package com.immortalidiot.customdatepicker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.immortalidiot.customdatepicker.R

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val InterFontFamily = FontFamily(
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold)
)

val LatoFontFamily = FontFamily(
    Font(R.font.lato_bold, FontWeight.Bold)
)

private val mediumInterStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Medium,
)

private val semiBoldInterStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.SemiBold,
)

private val boldInterStyle = TextStyle(
    fontFamily = InterFontFamily,
    fontWeight = FontWeight.Bold,
)

private val boldLatoStyle = TextStyle(
    fontFamily = LatoFontFamily,
    fontWeight = FontWeight.Bold
)

val boldInter36 = boldInterStyle.copy(fontSize = 36.sp)
val boldInter24 = boldInterStyle.copy(fontSize = 24.sp)
val boldInter20 = boldInterStyle.copy(fontSize = 20.sp)
val boldInter16 = boldInterStyle.copy(fontSize = 16.sp)
val boldInter14 = boldInterStyle.copy(fontSize = 14.sp)
val boldInter10 = boldInterStyle.copy(fontSize = 10.sp)

val boldLato18 = boldLatoStyle.copy(fontSize = 18.sp)
val boldLato17 = boldLatoStyle.copy(fontSize = 17.sp)
val boldLato16 = boldLatoStyle.copy(fontSize = 16.sp)
val boldLato13 = boldLatoStyle.copy(fontSize = 13.sp)
val boldLato12 = boldLatoStyle.copy(fontSize = 12.sp)

val semiBold10 = semiBoldInterStyle.copy(fontSize = 10.sp)