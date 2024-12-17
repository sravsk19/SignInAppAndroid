package com.example.signinapp.page

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription


class LoginPage(private val testRule: ComposeTestRule) {

    fun verifyLoginPageElements() {
        testRule.onNode(hasContentDescription("Transport For London Logo") and hasRole(Role.Image))
            .assertIsDisplayed()
        testRule.onNodeWithContentDescription("TFL ID").isDisplayed()
        testRule.onNodeWithContentDescription("Password").isDisplayed()
    }

    private fun hasRole(role: Role) =
        SemanticsMatcher.expectValue(SemanticsProperties.Role, role)
}

internal fun onLoginPage(
    testRule: ComposeTestRule,
    func: LoginPage.() -> Unit
) = LoginPage(testRule).apply { func() }