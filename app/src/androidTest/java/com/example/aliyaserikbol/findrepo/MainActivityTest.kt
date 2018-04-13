package com.example.aliyaserikbol.findrepo

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.example.aliyaserikbol.findrepo.Screens.BaseScreen
import com.example.aliyaserikbol.findrepo.Screens.SearchScreen
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest() : BaseScreen() {
    @Rule @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
            MainActivity::class.java)

    @Test
    fun matchesLink(){
        val searchScreen = SearchScreen()
        val textSearchForRepo = "Kotlin"
        searchScreen.typeTextInSearchForReposField(textSearchForRepo)
        val searchResultScreen = SearchScreen().tapOnSearchButton()
        val gitHubScreen = searchResultScreen.tapOnARepoInSearchList()
        val actualUrl = gitHubScreen.actualUrl

        val expectedUrl = "https://github.com/JetBrains/kotlin"

        Assert.assertEquals("$actualUrl is equal $expectedUrl", expectedUrl, actualUrl)
    }

    @Test
    fun verifyEmptyViewUsersReposFieldHasErrorMessage(){
        val searchScreen = SearchScreen()
        val emptyText = ""
        searchScreen.typeTextInViewUsersReposField(emptyText)
        val searchResultScreen = searchScreen.tapOnViewButton()
        searchScreen.verifyErrorMessageIsExist()
    }

    @Test
    fun verifyBackWorksOnEachScreen(){
        val searchScreen = SearchScreen()
        val textSearchForRepo = "Kotlin"
        searchScreen.typeTextInSearchForReposField(textSearchForRepo)
        val searchResultScreen = SearchScreen().tapOnSearchButton()
        val gitHubScreen = searchResultScreen.tapOnARepoInSearchList()
        gitHubScreen.back()
        searchResultScreen.back()
    }
}




