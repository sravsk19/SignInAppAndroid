package com.example.signinapp.uitest

import com.example.signinapp.BaseTestFromLoginPage
import com.example.signinapp.page.onLoginPage
import com.example.signinapp.page.onMyTfLPage
import org.junit.Before
import org.junit.Test

class MyTfLTest : BaseTestFromLoginPage() {

    @Before
    override fun setUp() {
        super.setUp()
        onLoginPage(testRule) {
            loginWith(tflId = "emma@tfl.gov.uk", password = "password123")
        }
    }

    @Test
    fun validateMyTfLPage() {
        onMyTfLPage(testRule) {
            verifyMyTfLPage()
        }
    }

    @Test
    fun verifyCancelSignOut() {
        onMyTfLPage(testRule) {
            tapSignOutButton()
            verifyConfirmSignOutDialog()
            cancelSignOut()
            verifyMyTfLPage()
        }
    }

    @Test
    fun verifySignOutSuccess() {
        onMyTfLPage(testRule) {
            tapSignOutButton()
            verifyConfirmSignOutDialog()
            confirmSignOut()
        }
        onLoginPage(testRule) {
            verifyLoginPageElements()
        }
    }

}