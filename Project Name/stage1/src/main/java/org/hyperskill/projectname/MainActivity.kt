package org.hyperskill.projectname

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.hyperskill.secretdiary.ui.theme.HyperskillTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HyperskillTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Hyperskill")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text("Hello, $name")
}

@Preview
@Composable
fun GreetingPreview() {
    HyperskillTheme {
        Greeting(name = "Hyperskill")
    }
}