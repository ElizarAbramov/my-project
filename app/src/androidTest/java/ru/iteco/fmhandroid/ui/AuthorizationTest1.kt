package ru.iteco.fmhandroid.ui

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.backspaceLogBackspacePass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.backspaceLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.clickAuthButton
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.clickLogoutButton
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.emptyLogEmptyPass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.emptyLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.symbolsLogSymbolsPass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.symbolsLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogBackspacePass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogEmptyPass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogSymbolsPass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogWrongPass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.wrongLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.wrongLogWrongPass
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin


@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)

class AuthorizationTest1 {

    @Before

    fun logoutIfLogged() {

        if (checkIfLogin()) {
            clickAuthButton()
            clickLogoutButton()

        }
    }

    @Rule
    @JvmField

    var mActivityScenarioRule = ActivityScenarioRule(AppActivity::class.java)


    @Test
    fun authorizationTrueLogTruePass() {
        trueLogTruePass()
    }

    @Test
    fun authorizationWrongLogWrongPass() {

        wrongLogWrongPass()
    }

    @Test
    fun authorizationWrongLogTruePass() {

        wrongLogTruePass()
    }

    @Test
    fun authorizationEmptyLogEmptyPass() {

        emptyLogEmptyPass()
    }

    @Test
    fun authorizationTrueLogWrongPass() {

        trueLogWrongPass()
    }

    @Test
    fun authorizationEmptyLogTruePass() {

        emptyLogTruePass()
    }

    @Test
    fun authorizationTrueLogEmptyPass() {

        trueLogEmptyPass()
    }

    @Test
    fun authorizationBackspaceLogBackspacePass() {

        backspaceLogBackspacePass()
    }

    @Test
    fun authorizationBackspaceLogTruePass() {

        backspaceLogTruePass()
    }

    @Test
    fun authorizationTrueLogBackspacePass() {

        trueLogBackspacePass()
    }

    @Test
    fun authorizationSymbolsLogTruePass() {

        symbolsLogTruePass()
    }

    @Test
    fun authorizationTrueLogSymbolsPass() {

        trueLogSymbolsPass()
    }

    @Test
    fun authorizationSymbolsLogSymbolsPass() {

        symbolsLogSymbolsPass()
    }

}
