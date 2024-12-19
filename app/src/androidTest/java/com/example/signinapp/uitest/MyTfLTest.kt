package com.example.signinapp.uitest

import com.example.signinapp.BaseTestFromLoginPage
import com.example.signinapp.page.onLoginPage
import com.example.signinapp.page.onMyTfLPage
import org.junit.Before
import org.junit.Test

class MyTfLTest : BaseTestFromLoginPage() {

    /**
     * Setup function to navigate to MyTfL Page, this function will Login using valid credentials from Login Page
     */
    @Before
    override fun setUp() {
        super.setUp()
        onLoginPage(testRule) {
            loginWith(tflId = "emma@tfl.gov.uk", password = "password123")
        }
    }

    /**
     * Verifies MyTfL Page initial state
     */
    @Test
    fun validateMyTfLPage() {
        onMyTfLPage(testRule) {
            assertMyTfLPageIsDisplayed()
        }
    }

    /**
     * Verifies app doesn't navigates to Other screens after Cancelling confirm SignOut AlertDialog
     */
    @Test
    fun verifyCancelSignOut() {
        onMyTfLPage(testRule) {
            tapSignOutButton()
            verifyConfirmSignOutDialog()
            cancelSignOut()
            assertMyTfLPageIsDisplayed()
        }
    }

    /**
     * Verifies navigating back to Login page after successful SignOut
     */
    @Test
    fun verifySignOutSuccess() {
        onMyTfLPage(testRule) {
            tapSignOutButton()
            verifyConfirmSignOutDialog()
            confirmSignOut()
        }
        onLoginPage(testRule) {
            assertLoginPageElements()
        }
    }

}