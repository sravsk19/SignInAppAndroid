package com.example.signinapp.uitest

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.core.app.ActivityScenario
import com.example.signinapp.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginTest {

    @get:Rule
    val testRule = createComposeRule()

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun validateSignInPage() {
        testRule.onNode(hasContentDescription("Transport For London Logo") and hasRole(Role.Image))
            .assertIsDisplayed()
        testRule.onNodeWithContentDescription("TFL ID").isDisplayed()
        testRule.onNodeWithContentDescription("Password").isDisplayed()
    }

    private fun hasRole(role: Role) =
        SemanticsMatcher.expectValue(SemanticsProperties.Role, role)
}