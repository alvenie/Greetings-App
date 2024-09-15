package com.example.greetingsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Start()
        }
    }
}

@Composable
fun Start(){
    var showText by remember { mutableStateOf(false) }
    var displayed by remember { mutableStateOf("") }
    var value by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .offset(x = 0.dp, y = 500.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Enter name") },
            singleLine = true,
            modifier = Modifier.padding(20.dp)
        )

        Button(onClick = {displayed = value
                         showText = true},
            modifier = Modifier
                .width(200.dp)
                .height(60.dp)
        ) {
            Text(text = "GetGreetings",
                fontSize = 24.sp,
                color = Color.Black
            )
        }

    }

    if (showText) {
        Greetings(
            name = displayed
        )
    }
}
@Composable
fun Greetings(name: String) {
    val currentTime = Calendar.getInstance()
    val currentHour = currentTime.get(Calendar.HOUR_OF_DAY)
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        if (name == "") {
            Text(
                text = "Please type your name!",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
        else if (currentHour < 12) {
            Text(
                text = "Good morning, $name!",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        } else if (currentHour < 17) {
                Text(
                    text = "Good afternoon, $name!",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp))
            }
        else {
            Text(
                text = "Good evening, $name!",
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingsPreview() {
    Start()
}