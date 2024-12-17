package com.example.signinapp.page

import androidx.compose.ui.test.junit4.ComposeTestRule
import com.example.signinapp.BasePage
import com.example.signinapp.page.MyTfLPage.MyTfLPageElements.MY_TFL_TITLE
import com.example.signinapp.page.MyTfLPage.MyTfLPageElements.SIGN_OUT

class MyTfLPage(
    testRule: ComposeTestRule
) : BasePage(testRule) {

    object MyTfLPageElements {
        const val SIGN_OUT = "Sign Out"
        const val MY_TFL_TITLE = "My TfL"
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

    fun verifyMyTfLPageDisplayed() = assertTextIsDisplayed(MY_TFL_TITLE)
}

internal fun onMyTfLPage(
    testRule: ComposeTestRule,
    func: MyTfLPage.() -> Unit
) = MyTfLPage(testRule).apply { func() }