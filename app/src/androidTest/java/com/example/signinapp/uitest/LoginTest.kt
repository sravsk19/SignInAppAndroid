package com.example.signinapp.uitest

import com.example.signinapp.BaseTestFromLoginPage
import com.example.signinapp.page.onLoginPage
import com.example.signinapp.page.onMyTfLPage
import org.junit.Test

class LoginTest : BaseTestFromLoginPage() {

    /**
     * Validates the Login Page elements are displayed
     */
    @Test
    fun validateSignInPage() {
        onLoginPage(testRule) {
            assertLoginPageElements()
        }
    }

    /**
     * Verifies error dialog with title and dismiss button is displayed
     * for submitting empty Login form
     */
    @Test
    fun verifyEmptySignInError() {
        onLoginPage(testRule) {
            loginWith(tflId = "", password = "")
            verifyLoginErrorDialog()
        }
    }

    /**
     * Verifies error dialog with title and dismiss button is displayed
     * for submitting incorrect Login form
     */
    @Test
    fun verifyIncorrectSignIn() {
        onLoginPage(testRule) {
            loginWith(tflId = "abc@test.com", password = "test1234")
            verifyLoginErrorDialog()
        }
    }

    /**
     * Verifies navigation to MyTfL page after successful Login
     */
    @Test
    fun verifySuccessfulLogin() {
        onLoginPage(testRule) {
            loginWith(tflId = "emma@tfl.gov.uk", password = "password123")
        }
        onMyTfLPage(testRule) {
            verifyMyTfLPageDisplayed()
        }
    }
}