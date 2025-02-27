package de.frederikkohler.courtconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.frederikkohler.courtconnect.data.repository.Repository
import de.frederikkohler.courtconnect.ui.theme.CourtConnectTheme

class MainActivity : ComponentActivity() {
    val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourtConnectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
 
@Composable
fun LoginScreen(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(text = name)
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        name = "asdsa",
        modifier = Modifier.padding()
    )
}