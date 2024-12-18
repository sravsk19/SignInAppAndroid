package com.example.signinapp.page

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.signinapp.BasePage
import com.example.signinapp.page.MyTfLPage.MyTfLPageElements.CANCEL
import com.example.signinapp.page.MyTfLPage.MyTfLPageElements.MY_TFL_TITLE
import com.example.signinapp.page.MyTfLPage.MyTfLPageElements.SIGN_OUT
import com.example.signinapp.page.MyTfLPage.MyTfLPageElements.SIGN_OUT_ALERT_MESSAGE
import com.example.signinapp.page.MyTfLPage.MyTfLPageElements.SIGN_OUT_ALERT_TITLE

class MyTfLPage(
    testRule: ComposeTestRule
) : BasePage(testRule) {

    object MyTfLPageElements {
        const val SIGN_OUT = "Sign Out"
        const val MY_TFL_TITLE = "My TfL"

        const val SIGN_OUT_ALERT_TITLE = "Sign Out?"
        const val SIGN_OUT_ALERT_MESSAGE = "Are you sure you want to sign out?"
        const val CANCEL = "Cancel"
    }

    fun verifyMyTfLPage() {
        assertTextOnButton(SIGN_OUT)
        assertTextIsDisplayed(
            listOf(
                "Name: Emma Smith",
                "Role: Senior Test Analyst",
                "Office: Pier Walk"
            )
        )
    }

    fun verifyConfirmSignOutDialog() {
        verifyAlertDialog(SIGN_OUT_ALERT_TITLE, SIGN_OUT_ALERT_MESSAGE, CANCEL, SIGN_OUT)
    }

    fun verifyMyTfLPageDisplayed() = assertTextIsDisplayed(MY_TFL_TITLE)
    fun tapSignOutButton() = tapTextButton(SIGN_OUT)
    fun confirmSignOut() = tapAlertDialogButton(SIGN_OUT)
    fun cancelSignOut() = tapAlertDialogButton(CANCEL)
}

internal fun onMyTfLPage(
    testRule: ComposeTestRule,
    func: MyTfLPage.() -> Unit
) = MyTfLPage(testRule).apply { func() }