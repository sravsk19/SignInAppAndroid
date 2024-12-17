package com.example.signinapp.page

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.signinapp.BasePage
import com.example.signinapp.page.LoginPage.LoginPageElements.PASSWORD
import com.example.signinapp.page.LoginPage.LoginPageElements.PASSWORD_PLACEHOLDER
import com.example.signinapp.page.LoginPage.LoginPageElements.SIGN_IN
import com.example.signinapp.page.LoginPage.LoginPageElements.TFL_ID
import com.example.signinapp.page.LoginPage.LoginPageElements.TFL_ID_PLACEHOLDER
import com.example.signinapp.page.LoginPage.LoginPageElements.TFL_LOGO

class LoginPage(testRule: ComposeTestRule) : BasePage(testRule) {

    object LoginPageElements {
        const val TFL_LOGO = "Transport For London Logo"
        const val TFL_ID = "TFL ID"
        const val PASSWORD = "Password"
        const val TFL_ID_PLACEHOLDER = "TFL ID…"
        const val PASSWORD_PLACEHOLDER = "Password…"
        const val SIGN_IN = "Sign in"
    }

    fun verifyLoginPageElements() {
        assertImageWithContentDescription(TFL_LOGO)
        assertTextWithContentDescription(TFL_ID)
        assertTextWithContentDescription(PASSWORD)
        assertTextInputIsDisplayed(TFL_ID_PLACEHOLDER)
        assertTextInputIsDisplayed(PASSWORD_PLACEHOLDER)
        assertTextOnButton(SIGN_IN)
    }

    fun loginWith(tflId: String = "tflId", password: String = "password") {
        enterText(TFL_ID_PLACEHOLDER, tflId)
        enterText(PASSWORD_PLACEHOLDER, password)
        tapSignInButton()
    }

    fun tapSignInButton() = tapTextButton(SIGN_IN)
}

internal fun onLoginPage(
    testRule: ComposeTestRule, func: LoginPage.() -> Unit
) = LoginPage(testRule).apply { func() }