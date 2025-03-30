package com.example.labone

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.labone.ui.theme.LabOneTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    private var myNameTextView: TextView? = null
    private var clickMyButton: Button? = null

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabOneTheme {
                MainScreen()
            }
        }
    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Main Activity", "onCreate called")
        setContentView(R.layout.activity_main)

        myNameTextView = findViewById(R.id.text)
        clickMyButton = findViewById(R.id.button)

        clickMyButton?.setOnClickListener {
            Log.d("MainActivity", "Button clicked")
            myNameTextView?.text = "On click"
        }
    }
}

@Composable fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        var text by remember { mutableStateOf("Mykhailo Vrana") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            Greeting(
                name = text,
                modifier = Modifier.padding(top = innerPadding.calculateTopPadding())
            )

            ClickMeButton(modifier = Modifier.padding(innerPadding)) {
                text = "Button clicked"
                Log.d("MainActivity", "onClick pressed")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Composable
fun ClickMeButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(onClick) {
        Text("Click Me")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabOneTheme {
        Greeting("Android")
    }
}