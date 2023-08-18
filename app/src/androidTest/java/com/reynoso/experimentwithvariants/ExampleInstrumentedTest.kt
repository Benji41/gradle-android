package com.reynoso.experimentwithvariants

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import com.reynoso.experimentwithvariants.test.R.drawable
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        R.drawable.baseline_tag_faces_24
        drawable.baseline_10k_24
        println(drawable.baseline_10k_24)
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.reynoso.experimentwithvariants", appContext.packageName)
    }
}