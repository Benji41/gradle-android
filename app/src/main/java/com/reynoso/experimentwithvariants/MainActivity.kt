package com.reynoso.experimentwithvariants

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.reynoso.experimentwithvariants.ui.theme.ExperimentWithVariantsTheme

class MainActivity : ComponentActivity() {

    val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val resultFromActivity = result.data?.getBundleExtra("tal")

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        /*

            ---------- GRADLEW ------
            is a small application included in the source code that downloads and launches gradle itself
            downloads the required gradle distribution, and launches gradle to build an application.

            ----- TOP LEVEL BUILD FIle -----
            it defines the common versions of plugins used by modules in a project


            ----- MODULE LEVEL BUILD FILE -----
            lets you configure build settings for the specific module it is located in.
            provides custom packaging options, as build variants


            ---------- PROPERTIES ------
            we have gradle.properties -> which we configure project-wide gradle settings as the heap

            local.properties -> which configures local environment properties for the build system.


            ---------- DEPENDENCIES -----------
            there could be local library module dependencies
            local binaries dependencies
            and remote dependencies




            ------------ JDK -----------

            jdk contains:
            tools, compiler, profiler,etc
            apis and libraries
            jvm to run the android studio IDE and the gradle build tool, not for running emulators.

            JBR - enhanced JDK distributed with android studio, which includes several optimizations for  use
            in android studio

            ---- ANDROID SDK----
            an android app can use some of the apis defined in a JDK, but not all of them
            the android sdk defines implementations of many java library functions as part of its
            available APIS, the compileSdk property specifies which android sdk version to use when compiling
            the source code.

            increasing the versioning of the compile options and target we need to increase the minimum
            api to run the app.







            -------------- BUILD VARIANTS ------------
            we create the build types and product flavors on the build.gradle module file

            we can customize suffixes and respective properties for build types and product flavors.

            by setting the project view mode to check our project, on the directory build/src
            if we create a new directory each build variant(combination of flavor dimensions and build types)
            which is called a "source set" and then assign the respective content(manifest,drawables, classes) for it.

            also exclusive content for tests source sets.

            each dependency type (implementation, testimplementation,androidtestimplementation, annotationProcessor), can be set to a specific
            build variant(flavor,build type) with the prefix name of the build variant.



            we can for instance create a base implementation for only a flavor, but this one applies
            to the different kind of build types.

            the main source set can use the resources and classes for each build variant

            but a build variant cant share its resources with another one.

            also the default content for a build variant is the main source set.

            we can also define common static values for each build type and product flavor

            and we access them through the BuildConfig class, which has to be enable in the buildFeatures clojure

            and then each time we change a build variant we will need to rebuild the project to rebuild this BuildConfig class
            and debug errors.



        * */
        setContent {
            ExperimentWithVariantsTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    println(resources.getIdentifier("baseline_supervised_user_circle_24","drawable",packageName))
                    Greeting("Android")
                }
            }
        }

        //launcher.launch(Intent(""))

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
    ExperimentWithVariantsTheme {
        Greeting("Android")
    }
}