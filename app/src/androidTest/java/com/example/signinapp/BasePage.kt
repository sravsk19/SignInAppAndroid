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

    /**
     * Assert for TextInput view with placeholder text is displayed
     * @param placeholderText TextInput Placeholder
     */
    fun assertTextInputIsDisplayed(placeholderText: String) {
        textInput(placeholderText).assertIsDisplayed()
    }

    /**
     * Assert for Text on a Button with Role.Button and have a clickAction enabled and is displayed
     * @param text Button Text
     */
    fun assertTextOnButton(text: String) = testRule.onNode(
        hasText(text)
                and hasRole(Role.Button)
                and hasClickAction()
    ).assertIsDisplayed()

    /**
     * Assert for Image with ContentDescription and has Role Image is displayed
     * @param imageContentDescription Image contentDescription
     */
    fun assertImageWithContentDescription(imageContentDescription: String) =
        testRule.onNode(hasContentDescriptionExactly(imageContentDescription) and hasRole(Role.Image))
            .assertIsDisplayed()

    /**
     * Assert for Text with ContentDescription is displayed
     * @param text TextView contentDescription
     */
    fun assertTextWithContentDescription(text: String) =
        testRule.onNodeWithContentDescription(text).isDisplayed()

    /**
     * Assert for Text with ContentDescription from an array is displayed
     * @param info list of text contentDescriptions
     */
    fun assertTextIsDisplayed(info: List<String>) =
        info.forEach { infoText ->
            testRule.onNodeWithContentDescription(infoText).isDisplayed()
        }

    /**
     * Assert for Text is displayed
     * @param text Text
     */
    fun assertTextIsDisplayed(text: String) =
        testRule.onNode(hasText(text)).assertIsDisplayed()

    /**
     * Assert for AlertDialog
     *
     * @param titleText AlertDialog Title text
     * @param descText AlertDialog descText
     * @param dismissText AlertDialog dismiss button text (nullable)
     * @param confirmText AlertDialog confirm button text (nullable)
     */
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

    /**
     * Tap action on Button with Text
     * @param text Button Text
     */
    fun tapTextButton(text: String) = testRule.onNode(
        hasText(text)
                and hasRole(Role.Button)
                and hasClickAction()
    ).performClick()

    /**
     * Enter Text action on TextInput with placeholder
     * @param placeholderText TextInput placeholder text
     * @param textToEnter String to input
     */
    fun enterText(placeholderText: String, textToEnter: String) =
        textInput(placeholderText).performTextInput(textToEnter)

    /**
     * Tap action on Alert Dialog button
     * @param text Button Text
     */
    fun tapAlertDialogButton(text: String) = testRule.onNode(
        hasText(text)
                and hasAnyAncestor(isDialog())
    ).performClick()


    /**
     * Locator for TextInput by Placeholder Text
     * @param placeholderText TextInput placeholder text
     */
    private fun textInput(placeholderText: String) = testRule.onNode(
        hasText(placeholderText) and hasSetTextAction()
    )

    /**
     * Locator for Text in AlertDialog
     * @param text Text
     */
    private fun textInAlertDialog(text: String) =
        testRule.onNode(hasText(text) and hasAnyAncestor(isDialog()))

    /**
     * Locator for Button by Text in AlertDialog
     * @param buttonText ButtonText
     */
    private fun getButtonInAlertDialog(buttonText: String) =
        testRule.onNode(
            hasText(buttonText) and hasRole(Role.Button)
                    and hasAnyAncestor(isDialog())
        )

    /**
     * Semantic Matcher to filter elements by Role
     * @param role Role Semantic Property
     */
    private fun hasRole(role: Role) =
        SemanticsMatcher.expectValue(SemanticsProperties.Role, role)
}