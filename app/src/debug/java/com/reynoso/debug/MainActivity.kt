package com.reynoso.debug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.reynoso.experimentwithvariants.BuildConfig
import com.reynoso.experimentwithvariants.R

import com.reynoso.experimentwithvariants.ui.theme.ExperimentWithVariantsTheme


class MainActivity : ComponentActivity() {
    //use control q to check documentation
    //use control o to override methods
    //use control i to implement methods
    //use command d to duplicate a line
    //use command backspace to delete a entire line by the position of the caret
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //you can access buildconfig file on the variants as well
        println(BuildConfig.UID)
        println(BuildConfig.BASE_URL)
        setContent { 
            ExperimentWithVariantsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Text(text = "hi coming from \"${BuildConfig.BUILD_TYPE}\" build type")
                        Image(painter = painterResource(id = R.drawable.baseline_tag_faces_24), contentDescription = "happy face")
                        Image(painter = painterResource(id = R.drawable.baseline_tag_faces_24), contentDescription = "happy face")
                        Image(painter = painterResource(id = R.drawable.baseline_tag_faces_24), contentDescription = "happy face")
                    }
                }
            }
        }
    }
}