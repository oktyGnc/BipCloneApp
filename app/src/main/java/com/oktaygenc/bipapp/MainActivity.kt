package com.oktaygenc.bipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.oktaygenc.bipapp.ui.screen.MainScreen
import com.oktaygenc.bipapp.ui.theme.BipAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BipAppTheme {
                MainScreen()
            }
        }
    }
}

@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    BipAppTheme {
        MainScreen()
    }
}