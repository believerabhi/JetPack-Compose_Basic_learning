package com.example.jetpack.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Composable
fun Greeting(name: String) {
    Column {
        Surface(color = MaterialTheme.colorScheme.primary) {
            Text(text = "Hello $name!", modifier = Modifier.padding(8.dp))
        }
        Text(text = "Hello $name!")
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Surface(modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
       Greeting(name = "Idiot")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeBasicTheme {
       MyApp()
    }
}