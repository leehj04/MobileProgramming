package com.example.eweek04a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.ui.theme.MyApplicationTheme
import com.example.eweek04a.uicomponents.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainScreen()
                // Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // MainScreen(modifier = Modifier.padding(innerPadding))
                    // Greeting(
                    //  name = "Android"
                    //  modifier = Modifier.padding(innerPadding)
                    //)
                //}
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}