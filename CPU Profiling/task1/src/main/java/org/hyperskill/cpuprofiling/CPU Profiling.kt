package org.hyperskill.cpuprofiling

import android.os.Trace
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.delay
import org.hyperskill.cpuprofiling.ui.theme.HyperskillTheme

@Composable
fun CpuProfiling() {
    HyperskillTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var hideButton by remember { mutableStateOf(false) }
                var showLoadingText by remember { mutableStateOf(false) }
                var launch by remember { mutableStateOf(false) }

                if (answer == solution) {
                    Text(text = "Congratulations! You found a slow function!")
                } else {

                    LaunchedEffect(key1 = launch) {
                        getProfileInfo()
                        hideButton = true
                    }

                    if (hideButton) {
                        Text(text = "Program is started.\n\nTry to inspect again?", textAlign = TextAlign.Center)
                        Button(onClick = {
                            hideButton = false
                            showLoadingText = false
                        }) {
                            Text(text = "Restart")
                        }
                    } else {
                        if (showLoadingText) {
                            Text("Loading...")
                        }
                        Button(onClick = {
                            showLoadingText = true
                            launch = !launch
                        }) {
                            Text(text = "Start")
                        }
                    }
                }
            }
        }
    }
}

suspend fun getProfileInfo() {
    Trace.beginSection("getProfileInfo")
    delay(3000)
    Trace.endSection()
}

val answer = "getProfileInfo"