// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    // we dont apply this plugins for the project, to reduce build time.
    //todo research what this plugin does
    //fixme
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    //kotlin code static analyzer to improve writing code
    id("io.gitlab.arturbosch.detekt") version "1.23.1" //to execute it have to run the following command
    // on the terminal -> ./gradlew detekt

}