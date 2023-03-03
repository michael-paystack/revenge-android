package dev.paystack.revenge.example

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.paystack.revenge.example.ui.theme.RevengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RevengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = this@MainActivity::launchViewsActivity) {
                            Text(text = "Views Sample")
                        }
                        Button(onClick = this@MainActivity::launchComposeActivity) {
                            Text(text = "Compose Sample")
                        }
                    }
                }
            }
        }
    }

    private fun launchViewsActivity() {
        val intent = Intent(this, ViewsActivity::class.java)
        startActivity(intent)
    }

    private fun launchComposeActivity() {
        val intent = Intent(this, ComposeActivity::class.java)
        startActivity(intent)
    }
}
