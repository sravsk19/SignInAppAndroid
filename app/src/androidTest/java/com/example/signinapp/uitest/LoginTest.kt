package com.example.signinapp.uitest

import com.example.signinapp.BaseTestFromLoginPage
import com.example.signinapp.page.onLoginPage
import org.junit.Test

class LoginTest : BaseTestFromLoginPage() {

    @Test
    fun validateSignInPage() {
        onLoginPage(testRule) {
            verifyLoginPageElements()
        }
    }

    @Test
    fun verifyEmptySignInError() {
        onLoginPage(testRule) {
            loginWith(tflId = "", password = "")
            verifyLoginErrorDialog()
        }
    }

    @Test
    fun verifyIncorrectSignIn() {
        onLoginPage(testRule) {
            loginWith(tflId = "abc@test.com", password = "test1234")
            verifyLoginErrorDialog()
        }
    }
}