package com.oktaygenc.bipapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oktaygenc.bipapp.ui.theme.IconColor
import com.oktaygenc.bipapp.ui.theme.SecondColor
import com.oktaygenc.bipapp.ui.theme.SecondColorDark

@Composable
fun IconButtonWithText(
    iconRes: Int,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val darkTheme: Boolean = isSystemInDarkTheme()

    val selectedColor = SecondColor
    val defaultColor = if (darkTheme) SecondColorDark else IconColor

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = text,
            tint = if (isSelected) selectedColor else defaultColor,
            modifier = Modifier
                .size(25.dp)
                .clickable(onClick = onClick)
        )
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = if (isSelected) selectedColor else defaultColor
        )
    }
}