package com.example.jetpack.compose.basic.ui.screen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpack.compose.basic.ui.theme.JetPackComposeBasicTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
         CardContent(name = name)
    }
}

@Composable
fun CardContent(name: String) {
    var expand by rememberSaveable { mutableStateOf(false) }
//    val extraPadding by animateDpAsState (
//        if (expand) 48.dp else 0.dp,
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy,
//            stiffness = Spring.StiffnessLow)
//    )

        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(12.dp)
            ) {
                Text(text = "Hello, ")
                Text(text = name,
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    ))
                if (expand) {
                    Text(
                        text = ("Composem ipsum color sit lazy " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }
//            ElevatedButton(onClick = { expand = !expand }) {
//                Text( if(expand) "Show Less" else "Show More")
//            }
            IconButton(onClick = { expand = !expand }) {
                Icon(imageVector = if(expand) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expand) "Show less" else "Show more")
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

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "Dark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    JetPackComposeBasicTheme {
        Greetings()
    }
}