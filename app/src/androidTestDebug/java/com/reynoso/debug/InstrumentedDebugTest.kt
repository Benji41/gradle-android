package com.reynoso.debug

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class InstrumentedDebugTest {
    @Test
    fun useAppContext(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        println("instrumentation context ${InstrumentationRegistry.getInstrumentation().context}")
        println("app context ${InstrumentationRegistry.getInstrumentation().targetContext}")
        println(appContext.packageName)

        assertEquals("com.reynoso.experimentwithvariants.free.debug",appContext.packageName)
    }
}