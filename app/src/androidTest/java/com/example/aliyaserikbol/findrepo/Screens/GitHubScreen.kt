package com.example.aliyaserikbol.findrepo.Screens

import android.support.test.uiautomator.UiSelector
import com.example.aliyaserikbol.findrepo.globalTimeOut
import org.junit.Assert

class GitHubScreen: BaseScreen() {

    val url = uiDevice.findObject(UiSelector().resourceId("com.android.chrome:id/url_bar"))

    val actualUrl get() = url.text

    init {
        Assert.assertTrue("GitHub page isn’t open", url.waitForExists(globalTimeOut))
    }

    fun back(): SearchResultScreen{
        uiDevice.pressBack()
        return SearchResultScreen()
    }

}
