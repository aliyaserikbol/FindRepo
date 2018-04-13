package com.example.aliyaserikbol.findrepo.Screens

import android.support.test.uiautomator.UiSelector
import org.junit.Assert

class GitHubScreen: BaseScreen() {

    val url = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))

    val actualUrl get() = url.text

    init {
        Assert.assertTrue("GitHub page isn’t open", url.waitForExists(5000))
    }

    fun back(): SearchResultScreen{
        uiDevice.pressBack()
        return SearchResultScreen()
    }

}
