package com.example.jetpack.compose.basic.ui.screen

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.compose.basic.ui.theme.JetPackComposeBasicTheme

@Composable
fun Greeting(name: String) {
    var expand by rememberSaveable { mutableStateOf(false) }
    val extraPadding by animateDpAsState (
                if (expand) 48.dp else 0.dp,
                animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessLow)
    )

    Surface(color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            ElevatedButton(onClick = { expand = !expand }) {
                Text( if(expand) "Show Less" else "Show More")
            }
        }
    }
    //Text(text = "Hello $name!", modifier = Modifier.fillMaxWidth())
}

@Composable
fun Greetings(modifier: Modifier = Modifier,
              names :List<String> = List(1000) {"$it"}) {
    LazyColumn(modifier = modifier.padding(vertical = 8.dp)) {
        items(items = names) {name->
            Greeting(name = name)
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if(shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false})
        } else {
            Greetings()
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun MyAppPreview() {
    JetPackComposeBasicTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingsPreview() {
    JetPackComposeBasicTheme {
        Greetings()
    }
}