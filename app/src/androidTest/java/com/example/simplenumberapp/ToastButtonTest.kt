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
    private var count = 0

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.example.simplenumberapp", appContext.packageName)
    }

    @Test
    fun testToastButton() {
        testToastButtonN(0)
        testToastButtonN(1)
        testToastButtonN(1)
        testToastButtonN(5)  // "You taps 7 times"
    }

    private fun testToastButtonN(n: Int) {
        if (n > 0) {
            for (i in 1..n) {
                clickId(R.id.count_button)
                count++
            }
        }

        clickId(R.id.toast_button)
        verifyToastMessage(activity.activity.resources.getQuantityString(R.plurals.numberOfTaps, count, count))
    }
}
