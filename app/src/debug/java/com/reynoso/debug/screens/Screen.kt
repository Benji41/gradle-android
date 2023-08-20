package com.reynoso.debug.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.reynoso.experimentwithvariants.ui.theme.ExperimentWithVariantsTheme

@Composable
fun Screen(content : @Composable () -> Unit){
    ExperimentWithVariantsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content.invoke()
        }
    }
}