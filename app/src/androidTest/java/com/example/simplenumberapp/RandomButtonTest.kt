package com.example.simplenumberapp

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class RandomButtonTest() : BaseTest() {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.simplenumberapp", appContext.packageName)
    }

    @Test
    fun testRandomButton() {
        val max = 10
        for (i in 1..max) {
            clickId(R.id.count_button)
        }
        clickId(R.id.random_button)

        checkIfIdDisplayed(R.id.textview_random)
        onView(withId(R.id.textview_random)).check((matches(not(withText("R")))))

        pressBack()
    }
}
