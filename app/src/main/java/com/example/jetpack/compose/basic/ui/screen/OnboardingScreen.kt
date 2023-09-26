package com.example.jetpack.compose.basic.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.compose.basic.ui.theme.JetPackComposeBasicTheme

@Composable
fun OnboardingScreen(onContinueClicked: ()->Unit,
    modifier: Modifier = Modifier) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked) {
            Text(text = "continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun Preview_OnboardingScreen() {
    JetPackComposeBasicTheme {
        OnboardingScreen(onContinueClicked = {})
    }
}