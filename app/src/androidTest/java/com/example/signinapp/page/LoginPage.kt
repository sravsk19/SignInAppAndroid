package com.example.signinapp.page

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.signinapp.BasePage
import com.example.signinapp.page.LoginPage.LoginPageElements.DONE
import com.example.signinapp.page.LoginPage.LoginPageElements.LOGIN_ERROR_MESSAGE
import com.example.signinapp.page.LoginPage.LoginPageElements.LOGIN_ERROR_TITLE
import com.example.signinapp.page.LoginPage.LoginPageElements.PASSWORD
import com.example.signinapp.page.LoginPage.LoginPageElements.PASSWORD_PLACEHOLDER
import com.example.signinapp.page.LoginPage.LoginPageElements.SIGN_IN
import com.example.signinapp.page.LoginPage.LoginPageElements.TFL_ID
import com.example.signinapp.page.LoginPage.LoginPageElements.TFL_ID_PLACEHOLDER
import com.example.signinapp.page.LoginPage.LoginPageElements.TFL_LOGO

class LoginPage(testRule: ComposeTestRule) : BasePage(testRule) {

    /**
     * Login page elements used in the App
     */
    object LoginPageElements {
        const val TFL_LOGO = "Transport For London Logo"
        const val TFL_ID = "TFL ID"
        const val PASSWORD = "Password"
        const val TFL_ID_PLACEHOLDER = "TFL ID…"
        const val PASSWORD_PLACEHOLDER = "Password…"
        const val SIGN_IN = "Sign in"

        const val LOGIN_ERROR_TITLE = "Login Error"
        const val LOGIN_ERROR_MESSAGE =
            "Looks like either your Username or Password is incorrect. Please try again."
        const val DONE = "Done"

    }

    fun assertLoginPageElements() {
        assertImageWithContentDescription(TFL_LOGO)
        assertTextWithContentDescription(TFL_ID)
        assertTextWithContentDescription(PASSWORD)
        assertTextInputIsDisplayed(TFL_ID_PLACEHOLDER)
        assertTextInputIsDisplayed(PASSWORD_PLACEHOLDER)
        assertTextOnButton(SIGN_IN)
    }

    fun verifyLoginErrorDialog() {
        verifyAlertDialog(LOGIN_ERROR_TITLE, LOGIN_ERROR_MESSAGE, null, DONE)
        tapTextButton(DONE)
    }

    /**
     * Login with valid/invalid/empty values
     * @param tflId text (email address format)
     * @param password password text
     */
    fun loginWith(tflId: String, password: String) {
        enterText(TFL_ID_PLACEHOLDER, tflId)
        enterText(PASSWORD_PLACEHOLDER, password)
        tapSignInButton()
    }

    private fun tapSignInButton() = tapTextButton(SIGN_IN)
}

internal fun onLoginPage(
    testRule: ComposeTestRule, func: LoginPage.() -> Unit
) = LoginPage(testRule).apply { func() }