/*
 * This code is modified from this source:
 * https://github.com/aws-samples/aws-device-farm-sample-app-for-android/blob/master/app/src/androidTest/java/com/amazonaws/devicefarm/android/referenceapp/BaseADFTest.java
 *
 * See copyright notice below.
 */

/*
 * Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.example.simplenumberapp

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith
import org.hamcrest.Matchers.not
import org.junit.Ignore

@Ignore
@RunWith(AndroidJUnit4::class)
open class BaseTest{

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    /**
     * Inputs text into a specific id
     *
     * @param id the input id
     * @param text the text to input
     */
    protected fun writeTextIntoTextBox(id: Int, text: String) {
        onView(withId(id)).perform(typeText(text))
    }

    /**
     * clicks an element id
     *
     * @param id the element id
     */
    protected fun clickId(id: Int) {
        onView(withId(id)).perform(click())
    }

    /**
     * Checks if id is displayed with expected text
     *
     * @param id the element id
     * @param textResource the string resource id of the expected text
     */
    protected fun checkIfIdIsDisplayedWithText(id: Int, textResource: Int) {
        onView(withId(id)).check(matches(withText(textResource))).check(matches(isDisplayed()))
    }

    /**
     * Checks if id is displayed with expected text
     *
     * @param id the element id
     * @param text the string of the expected text
     */
    protected fun checkIfIdIsDisplayedWithText(id: Int, text: String) {
        onView(withId(id)).check(matches(withText(text))).check(matches(isDisplayed()))
    }

    /**
     * Checks if a specific id is displayed
     * @param id the element id
     */
    protected fun checkIfIdDisplayed(id: Int) {
        onView(withId(id)).check(matches(isDisplayed()))
    }


    /**
     * Checks if a toast message is displayed
     * @param messageId the string resource of the expected toast message
     */
    protected fun verifyToastMessage(messageId: Int) {
        onView(withText(messageId)).inRoot(withDecorView(not(activity.activity.window.decorView)))
                .check(matches(isDisplayed()))
    }

    /**
     * Checks if a toast message is displayed
     * @param text the string of the expected toast message
     */
    protected fun verifyToastMessage(text: String) {
        onView(withText(text)).inRoot(withDecorView(not(activity.activity.window.decorView)))
                .check(matches(isDisplayed()))
    }

    /**
     * Convenience method to match a specific id with a specific content description resource id
     * @param id the element id
     * @param contentDescriptionId the elements content description id
     */
    protected fun checkIdWithContentDescription(id: Int, contentDescriptionId: Int) {
        onView(withId(id)).check(matches(withContentDescription(contentDescriptionId)))
    }

    /**
     * Convenience method to match a specific id with a specific content description
     * @param id the element id
     * @param contentDescription the expected content description
     */
    protected fun checkIdWithContentDescription(id: Int, contentDescription: String) {
        onView(withId(id)).check(matches(withContentDescription(contentDescription)))
    }
}


