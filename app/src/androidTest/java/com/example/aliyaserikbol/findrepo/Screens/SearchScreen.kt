package com.example.aliyaserikbol.findrepo.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.uiautomator.UiSelector
import com.example.aliyaserikbol.findrepo.R
import org.junit.Assert

class SearchScreen: BaseScreen(){

    init {
        onView(withId(R.id.searchEditText))
                .check(matches(isDisplayed()))
    }

    fun typeTextInSearchForReposField(text: String): SearchScreen{
        onView(withId(R.id.searchEditText))
                .perform(typeText(text))
        return this
    }

    fun typeTextInViewUsersReposField(text: String): SearchScreen{
        onView(withId(R.id.userRepoEditText))
                .perform(typeText(text))
        return this
    }

    fun tapOnSearchButton(): SearchResultScreen{
        onView(withId(R.id.searchButton))
                .perform(click())
        return SearchResultScreen()
    }

    fun tapOnViewButton(): SearchResultScreen{
        onView(withId(R.id.userRepoButton))
                .perform(click())
        return SearchResultScreen()
    }

    val errorMessage = uiDevice.findObject(UiSelector().resourceId("com.example.aliyaserikbol.findrepo:id/snackbar_text"))

    fun verifyErrorMessageIsExist(): SearchResultScreen{
        Assert.assertTrue("GitHub page isn’t open", errorMessage.waitForExists(5000))
        return SearchResultScreen()
    }
}