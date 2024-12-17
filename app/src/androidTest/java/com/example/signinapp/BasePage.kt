package com.example.signinapp

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescriptionExactly
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput

open class BasePage(private val testRule: ComposeTestRule) {

    /**************************
    Base Assertions on pageObjects
    ****************************/
    fun assertTextInputIsDisplayed(textInput: String) {
        textInput(textInput).assertIsDisplayed()
    }

    fun assertTextOnButton(text: String) = testRule.onNode(
        hasText(text)
                and hasRole(Role.Button)
                and hasClickAction()
    ).assertIsDisplayed()

    fun assertImageWithContentDescription(image: String) =
        testRule.onNode(hasContentDescriptionExactly(image) and hasRole(Role.Image))
            .assertIsDisplayed()

    fun assertTextWithContentDescription(text: String) =
        testRule.onNodeWithContentDescription(text).isDisplayed()

    /**************************
    Base Actions on pageObjects
     ***************************/
    fun tapTextButton(text: String) = testRule.onNode(
        hasText(text)
                and hasRole(Role.Button)
                and hasClickAction()
    ).performClick()

    fun enterText(text: String, textToEnter: String) =
        textInput(text).performTextInput(textToEnter)

    /**************************
    Base private functions
     ***************************/
    private fun textInput(text: String) = testRule.onNode(
        hasText(text) and hasSetTextAction()
    )

    private fun hasRole(role: Role) =
        SemanticsMatcher.expectValue(SemanticsProperties.Role, role)
}