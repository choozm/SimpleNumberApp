package com.example.simplenumberapp

import android.support.test.InstrumentationRegistry
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
class ToastButtonTest() : BaseTest() {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.simplenumberapp", appContext.packageName)
    }

    @Test
    fun testToastButton0() {
        testToastButtonN(0)
    }

    @Test
    fun testToastButton1() {
        testToastButtonN(1)
    }

    @Test
    fun testToastButton2() {
        testToastButtonN(2)
    }

    private fun testToastButtonN(n: Int) {
        if (n > 0) {
            for (i in 1..n) {
                clickId(R.id.count_button)
            }
        }

        clickId(R.id.toast_button)
        verifyToastMessage(activity.activity.resources.getQuantityString(R.plurals.numberOfTaps, n, n))
    }
}
