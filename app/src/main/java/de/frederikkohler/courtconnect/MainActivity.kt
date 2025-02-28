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
import de.frederikkohler.courtconnect.di.myModule
import de.frederikkohler.courtconnect.ui.theme.CourtConnectTheme
import de.frederikkohler.courtconnect.viewModel.SignInViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        startKoin {
            modules(myModule)

            setContent {
                CourtConnectTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        val viewModel: SignInViewModel = koinViewModel<SignInViewModel>()
                        viewModel.user?.let {
                            LoginScreen(
                                name = "Android ${it.id}",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
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

