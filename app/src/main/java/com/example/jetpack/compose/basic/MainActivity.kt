package com.example.jetpack.compose.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val expand = remember { mutableStateOf(false) }
    val extraPadding = if (expand.value) 48.dp else 0.dp

        Surface(color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(modifier = Modifier
                                 .weight(1f)
                                 .padding(bottom = extraPadding)
                ) {
                    Text(text = "Hello, ")
                    Text(text = name)
                }
                ElevatedButton(onClick = { expand.value = !expand.value }) {
                    Text( if(expand.value) "Show Less" else "Show More")
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