package edu.victorhom19.lab3_navigation

import android.content.Context
import android.content.pm.ActivityInfo
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import edu.victorhom19.lab3_navigation.Activity1
import edu.victorhom19.lab3_navigation.R
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @Test
    fun testAbout() {
        openAbout()
        checkView(R.id.activity_about)

    }

    @Test
    fun testForwardNavigation() {
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .perform(click())
        checkView(R.id.fragment2)
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird))
            .perform(click())
        checkView(R.id.fragment3)
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst))
            .perform(click())
        checkView(R.id.fragment1)
    }

    @Test
    fun testBackwardNavigation() {
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        checkView(R.id.activity_about)
        Espresso.pressBack()
        checkView(R.id.fragment3)
        Espresso.pressBack()
        checkView(R.id.fragment2)
        Espresso.pressBack()
        checkView(R.id.fragment1)
    }

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(Activity1::class.java)

    @Test
    fun testBackstack() {
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToFirst))
            .perform(click())
        Espresso.pressBackUnconditionally()
        assertTrue(activityScenarioRule.scenario.state.isAtLeast(Lifecycle.State.DESTROYED))
    }


    @Test
    fun testRotation() {
        rotateAndCheck(R.id.fragment1)
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .perform(click())
        rotateAndCheck(R.id.fragment2)
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird))
            .perform(click())
        rotateAndCheck(R.id.fragment3)

    }

    private fun rotateAndCheck(element: Int) {
        checkView(element)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        checkView(element)
        activityScenarioRule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        checkView(element)
        Thread.sleep(1000)
    }


    private fun checkView(element: Int) {
        when (element) {
            R.id.fragment1 -> {
                Espresso.onView(ViewMatchers.withId(R.id.fragment1))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

                Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

                Espresso.onView(ViewMatchers.withId(R.id.fragment2))
                    .check(ViewAssertions.doesNotExist())
                Espresso.onView(ViewMatchers.withId(R.id.fragment3))
                    .check(ViewAssertions.doesNotExist())
                Espresso.onView(ViewMatchers.withId(R.id.activity_about))
                    .check(ViewAssertions.doesNotExist())
            }
            R.id.fragment2 -> {
                Espresso.onView(ViewMatchers.withId(R.id.fragment2))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

                Espresso.onView(ViewMatchers.withId(R.id.bnToFirst))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                Espresso.onView(ViewMatchers.withId(R.id.bnToThird))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

                Espresso.onView(ViewMatchers.withId(R.id.fragment1))
                    .check(ViewAssertions.doesNotExist())
                Espresso.onView(ViewMatchers.withId(R.id.fragment3))
                    .check(ViewAssertions.doesNotExist())
                Espresso.onView(ViewMatchers.withId(R.id.activity_about))
                    .check(ViewAssertions.doesNotExist())
            }
            R.id.fragment3 -> {
                Espresso.onView(ViewMatchers.withId(R.id.fragment3))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

                Espresso.onView(ViewMatchers.withId(R.id.bnToFirst))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

                Espresso.onView(ViewMatchers.withId(R.id.fragment1))
                    .check(ViewAssertions.doesNotExist())
                Espresso.onView(ViewMatchers.withId(R.id.fragment2))
                    .check(ViewAssertions.doesNotExist())
                Espresso.onView(ViewMatchers.withId(R.id.activity_about))
                    .check(ViewAssertions.doesNotExist())
            }
            R.id.activity_about -> {
                Espresso.onView(ViewMatchers.withId(R.id.activity_about))
                    .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

            }
        }
    }

    @Test
    fun testUpNavigation() {
        Espresso.onView(ViewMatchers.withId(R.id.bnToSecond))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.bnToThird))
            .perform(click())
        openAbout()

        Espresso.onView(ViewMatchers.withId(R.id.activity_about))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers
            .withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.fragment3))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers
            .withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.fragment2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers
            .withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso.onView(ViewMatchers.withId(R.id.fragment1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}