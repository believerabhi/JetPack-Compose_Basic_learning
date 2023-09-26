package com.example.jetpack.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
        Surface(color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Hello, ")
                    Text(text = name)
                }
                ElevatedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Show More")
                }
            }
        }
        //Text(text = "Hello $name!", modifier = Modifier.fillMaxWidth())
}

@Composable
fun MyApp(modifier: Modifier = Modifier,
          names :List<String> = listOf("World","compose")
) {
    Surface(modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = modifier.padding(vertical = 8.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }

    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    JetPackComposeBasicTheme {
       MyApp()
    }
}