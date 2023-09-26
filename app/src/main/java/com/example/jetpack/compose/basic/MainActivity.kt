package com.example.jetpack.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import com.example.jetpack.compose.basic.ui.screen.MyApp
import com.example.jetpack.compose.basic.ui.theme.JetPackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeBasicTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}