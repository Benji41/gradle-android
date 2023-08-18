import java.rmi.server.UID
import java.util.UUID


plugins {
    id("com.android.application") //applies the android gradle plugin, to the module and lets us use the android block.
    id("org.jetbrains.kotlin.android") // enables kotlin support for android development
    id("com.google.devtools.ksp") // enables ksp processor
}

//set the tool chain by function, contains java compiler used to build any java source code, also runs the kotlin compiler
kotlin{
    jvmToolchain(17)
}

//configure all android specific build options, which dont come by default for gradle(enabled by the plugin).
android {
    namespace =
        "com.reynoso.experimentwithvariants" //app name space. used primarily to access app resources

    compileSdk =
        33 // specifies the android API level, gradle should use to compile the app (means you can use the api features in this API and lower)
            //enables new functionality but dosent brake the current behavior of already produced app.
            //thats why always has to be the highest sdk to ensure new features are available and
            // still remain compatible to older versions.


    ///encapsulates default settings and entries for all build variants.
    defaultConfig {
        applicationId =
            "com.reynoso.experimentwithvariants" //uniquely identifies the package for publishing.
        minSdk = 24 // minimum api level required to run the app


        /*
            specifies the api level used to be design and test the app, the current version of android to test the app
            the set of api tools that are defined on the target sdk are the same ones used by newer api version, instead of our code updating to be
            compatible with a newer api version.


        */
        targetSdk = 31

        versionCode = 1 //defines the version number of the app
        versionName = "1.0" //user-friendly version name of the app

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    //developer facing attributes which represent stages of development
    buildTypes {
        //default build types
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            //static variable which changes by build type
            buildConfigField("String", "BASE_URL", "www.google.com")
        }

        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true

            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://developer.android.com/build/build-variants\""
            )

        }

        //custom build type
        create("dev") {
            applicationIdSuffix = ".dev"

            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://developer.android.com/guide/topics/resources/providing-resources\""
            )
            signingConfig = signingConfigs.getByName("debug")


        }

    }

    flavorDimensions += "features"
    //user facing attributes which represent the app versions available to the user
    productFlavors {

        create("free") {
            dimension = "features"
            applicationIdSuffix = ".free"
            versionNameSuffix = "-free"
            //static variable which changes by product flavor
            //each time you make a change to any build type or flavor you will need to sync the gradle
            //and also rebuild the project
            buildConfigField(
                type = "String",
                name = "UID",
                value = "\"${UUID.randomUUID()}\""
            )
        }

        create("paid") {
            dimension = "features"
            applicationIdSuffix = ".paid"
            versionNameSuffix = "-paid"

        }
    }






    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 //determines which java language features are available during compilation
        targetCompatibility = JavaVersion.VERSION_17 //specifying both target compatibility and jvm target
        // determines the java class-format version used when generating bytecode for compiled java and kotlin source, respectively
    }
    kotlinOptions {
        jvmTarget = "17" // source code for target (test)
        //this set of  java versioning does not affect in which jdk is used to run the gradle itself.
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    //annotation processor
    ksp("androidx.room:room-compiler:2.5.2")

    //remote dependency for the debug build type
    //camel case prefix of the build type or variant type of dependency with first letter upper case.
    "debugImplementation"("com.airbnb.android:lottie:6.1.0")


    //shared remote dependencies
    implementation("com.facebook.shimmer:shimmer:0.5.0")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}