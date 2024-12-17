package com.example.signinapp.page

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.signinapp.BasePage

class LoginPage(testRule: ComposeTestRule) : BasePage(testRule) {

    fun verifyLoginPageElements() {
        assertImageWithContentDescription("Transport For London Logo")
        assertTextWithContentDescription("TFL ID")
        assertTextWithContentDescription("Password")
        assertTextInputIsDisplayed("TFL ID…")
        assertTextInputIsDisplayed("Password…")
        assertTextOnButton("Sign in")
    }
}

internal fun onLoginPage(
    testRule: ComposeTestRule, func: LoginPage.() -> Unit
) = LoginPage(testRule).apply { func() }