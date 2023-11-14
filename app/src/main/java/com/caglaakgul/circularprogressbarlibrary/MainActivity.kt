package com.caglaakgul.circularprogressbarlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R
import com.caglaakgul.circularprogressbarlibrary.ui.theme.CircularProgressBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircularProgressBarTheme {
               /* Box(modifier = Modifier.fillMaxSize()) {
                    com.caglaakgul.circularprogressbar.ImagePreview(
                        image = painterResource(id = R.drawable.ic_call_answer_video),
                        description = "Hello Library",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(150.dp)
                    )
                }

                */
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CircularProgressBarTheme {
     /*   Box(modifier = Modifier.fillMaxSize()) {
            com.caglaakgul.circularprogressbar.ImagePreview(
                image = painterResource(id = R.drawable.ic_call_answer_video),
                description = "Hello Library",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(150.dp)
            )
        }

      */
    }
}