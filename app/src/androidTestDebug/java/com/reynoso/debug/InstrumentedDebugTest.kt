package com.reynoso.debug

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import com.reynoso.experimentwithvariants.test.R
import org.hamcrest.MatcherAssert.*

@RunWith(AndroidJUnit4::class)
class InstrumentedDebugTest {
    @Test
    fun useAppContext(){
        //uses the app context or main sourceSet.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        //uses the androidTest sourceSet context.
        println("instrumentation context ${InstrumentationRegistry.getInstrumentation().context}")
        println("app context ${InstrumentationRegistry.getInstrumentation().targetContext}")
        println(appContext.packageName)

        val drawable = InstrumentationRegistry.getInstrumentation().context.getDrawable(R.drawable.baseline_10k_24)
        println(drawable)
        //todo
        //validate why the R generated class member of the drawable changes its id on runtime
        assertEquals("android.graphics.drawable.VectorDrawable@b6e53b9",drawable.toString())
        assertEquals("com.reynoso.experimentwithvariants.free.debug",appContext.packageName)
    }
}