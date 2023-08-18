package com.reynoso.dev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.reynoso.experimentwithvariants.BuildConfig
import com.reynoso.experimentwithvariants.R

import com.reynoso.experimentwithvariants.ui.theme.ExperimentWithVariantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println(BuildConfig.BASE_URL)
        setContent {
            ExperimentWithVariantsTheme {
                Surface(
                    color = Color.Red,
                    modifier = Modifier.fillMaxSize()
                ) {
                    MainScreenContent()
                }
            }
        }

    }
}

@Composable
fun MainScreenContent() {
    Column {
        Text(text = "hola desde dev env")
        Image(
            painter = painterResource(id = R.drawable.baseline_support_agent_24),
            contentDescription = "agent"
        )
        Image(
            painter = painterResource(id = R.drawable.baseline_support_agent_24),
            contentDescription = "agent"
        )

    }

}