package edu.victorhom19.lab3_navigation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText


private fun openAboutViaOptions() {
    openContextualActionModeOverflowMenu()
    onView(withText("Activity About"))
        .perform(click())
}

fun openAbout() = openAboutViaOptions()