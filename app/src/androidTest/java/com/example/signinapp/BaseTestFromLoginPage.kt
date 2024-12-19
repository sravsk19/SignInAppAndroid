package com.example.signinapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ActivityScenario
import org.junit.Before
import org.junit.Rule

open class BaseTestFromLoginPage {

    @get:Rule
    val testRule = createComposeRule()

    /**
     * ActivityScenario object to reference MainActivity from Target Application
     */
    private lateinit var scenario: ActivityScenario<MainActivity>

    /**
     * Set up function to launch MainActivity at beginning of each test
     */
    @Before
    open fun setUp() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }
}