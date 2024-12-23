package com.oktaygenc.bipapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oktaygenc.bipapp.R
import com.oktaygenc.bipapp.ui.theme.AnaColor
import com.oktaygenc.bipapp.ui.theme.IconColor
import com.oktaygenc.bipapp.ui.theme.TextBlack
import com.oktaygenc.bipapp.ui.theme.TextGrey

@Composable
fun MessageItem(imageRes: Int, name: String, lastMessage: String, time: String, read: Boolean) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {}
        .padding(8.dp)) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(IconColor)
        ) {
            Image(painterResource(imageRes), "", Modifier.fillMaxSize())
        }


        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 17.sp, color = TextBlack)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = if (read) {
                        painterResource(R.drawable.readicon)
                    } else {
                        painterResource(R.drawable.readicon)
                    }, contentDescription = "", tint = if (read) {
                        AnaColor
                    } else {
                        TextGrey
                    }, modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = lastMessage, color = TextGrey)
            }
        }
        Text(text = time, color = TextGrey, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}
