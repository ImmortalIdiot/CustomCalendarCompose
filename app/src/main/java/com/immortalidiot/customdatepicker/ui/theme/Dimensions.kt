package com.immortalidiot.customdatepicker.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val verticalSSmall: Dp = 8.dp,
    val verticalXSmall: Dp = 10.dp,
    val verticalNormal: Dp = 12.dp,
    val verticalStandard: Dp = 16.dp,
    val verticalSLarge: Dp = 20.dp,
    val verticalXLarge: Dp = 32.dp,
    val verticalXXLarge: Dp = 40.dp,

    val verticalXSSmallPadding: Dp = 1.dp,
    val verticalMSmallPadding: Dp = 2.dp,
    val verticalSmallPadding: Dp = 4.dp,
    val verticalNormalPadding: Dp = 8.dp,
    val verticalBigPadding: Dp = 16.dp,

    val horizontalSmallPadding: Dp = 10.dp,
    val horizontalNormalPadding: Dp = 16.dp,
    val horizontalEnlargedPadding: Dp = 24.dp,
    val horizontalBigPadding: Dp = 32.dp,
    val horizontalVeryBigPadding: Dp = 60.dp,

    val normalPadding: Dp = 6.dp,
    val averagePadding: Dp = 12.dp,
    val bigPadding: Dp = 16.dp,

    val shapeSSmall: Dp = 2.dp,
    val shapeXSmall: Dp = 4.dp,
    val shapeNormal: Dp = 8.dp,
    val shapeSLarge: Dp = 10.dp,
    val shapeMLarge: Dp = 12.dp,
    val shapeXLarge: Dp = 16.dp,
    val shapeXLLarge: Dp = 20.dp,
    val shapeXXLLarge: Dp = 40.dp,

    val borderOne: Dp = 1.dp,
    val borderXSSmall: Dp = 2.dp,
    val borderSSmall: Dp = 3.dp,
    val borderNormal: Dp = 5.dp,
    val borderXLarge: Dp = 8.dp,

    val userAvatarRadius: Dp = 80.dp,

    val profileDialogMaxHeight: Dp = 200.dp,
    val profileDialogMaxWidth: Dp = 300.dp,
    val deleteAccountDialogHeight: Dp = 160.dp,
    val deleteAccountDialogWidth: Dp = 350.dp,

    val buttonWidth: Dp = 80.dp,

    val smallestThickness: Dp = 1.dp,
    val smallThickness: Dp = 2.dp
)

val LocalDimensions = compositionLocalOf { Dimensions() }
