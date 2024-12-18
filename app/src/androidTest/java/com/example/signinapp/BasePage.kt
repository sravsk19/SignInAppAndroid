package com.example.signinapp

import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyAncestor
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescriptionExactly
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDialog
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

    fun assertTextIsDisplayed(info: List<String>) =
        info.forEach { infoText ->
            testRule.onNodeWithContentDescription(infoText).isDisplayed()
        }

    fun assertTextIsDisplayed(text: String) =
        testRule.onNode(hasText(text)).assertIsDisplayed()

    fun verifyAlertDialog(
        titleText: String,
        descText: String,
        dismissText: String?,
        confirmText: String?,
    ) {
        textInAlertDialog(titleText).assertIsDisplayed()
        textInAlertDialog(descText).assertIsDisplayed()
        dismissText?.let { text ->
            getButtonInAlertDialog(text).assertIsDisplayed()
        }
        confirmText?.let { text ->
            getButtonInAlertDialog(text).assertIsDisplayed()
        }
    }

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

    fun tapAlertDialogButton(text: String) = testRule.onNode(
        hasText(text)
                and hasAnyAncestor(isDialog())
    ).performClick()

    /**************************
    Base private functions
     ***************************/
    private fun textInput(text: String) = testRule.onNode(
        hasText(text) and hasSetTextAction()
    )

    private fun textInAlertDialog(text: String) =
        testRule.onNode(hasText(text) and hasAnyAncestor(isDialog()))

    private fun getButtonInAlertDialog(buttonText: String) =
        testRule.onNode(
            hasText(buttonText) and hasRole(Role.Button)
                    and hasAnyAncestor(isDialog())
        )

    private fun hasRole(role: Role) =
        SemanticsMatcher.expectValue(SemanticsProperties.Role, role)
}