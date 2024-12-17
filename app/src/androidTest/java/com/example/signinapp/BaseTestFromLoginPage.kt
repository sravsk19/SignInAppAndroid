package com.example.signinapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ActivityScenario
import org.junit.Before
import org.junit.Rule

open class BaseTestFromLoginPage {

    @get:Rule
    val testRule = createComposeRule()

    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    open fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }
}