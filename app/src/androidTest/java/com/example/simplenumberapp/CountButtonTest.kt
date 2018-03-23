package com.example.simplenumberapp

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CountButtonTest() : BaseTest() {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.simplenumberapp", appContext.packageName)
    }

    /**
     * Plain test code. Not using methods from BaseTest.
     */
    @Test
    fun testCountButton1() {
        onView(withId(R.id.count_button)).perform(click())
        onView(withId(R.id.count_textview)).check(matches(withText("1")))
    }

    /**
     * Using methods from BaseTest.
     */
    @Test
    fun testCountButton2() {
        clickId(R.id.count_button)
        checkIfIdIsDisplayedWithText(R.id.count_textview, "1")
    }

    @Test
    fun testCountButton3() {
        clickId(R.id.count_button)
        clickId(R.id.count_button)
        clickId(R.id.count_button)
        checkIfIdIsDisplayedWithText(R.id.count_textview, "3")
    }
}
