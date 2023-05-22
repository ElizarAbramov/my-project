package ru.iteco.fmhandroid.ui.testhelper

import androidx.test.espresso.action.ViewActions.click
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.authorizationButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButtonWithText
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.successfulAuthorization
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.unsuccessfulAuthorization

object AuthorizationHelper {

    fun clickAuthButton() {
        authorizationButton.perform(click())
    }

    fun clickLogoutButton() {

        clickButtonWithText(android.R.id.title, "Log out")
    }

    fun trueLogTruePass() {

        successfulAuthorization("login2", "password2")
    }

    fun trueLogWrongPass() {

        unsuccessfulAuthorization("login2", "parol")
    }

    fun wrongLogWrongPass() {

        unsuccessfulAuthorization("login", "parol")
    }

    fun wrongLogTruePass() {

        unsuccessfulAuthorization("login", "password2")
    }

    fun emptyLogEmptyPass() {

        unsuccessfulAuthorization("", "")
    }

    fun emptyLogTruePass() {

        unsuccessfulAuthorization("", "password2")
    }

    fun trueLogEmptyPass() {

        unsuccessfulAuthorization("login2", "")
    }

    fun backspaceLogTruePass() {
        unsuccessfulAuthorization("    ", "password2")
    }

    fun trueLogBackspacePass() {

        unsuccessfulAuthorization("login2", "    ")
    }

    fun backspaceLogBackspacePass() {

        unsuccessfulAuthorization("    ", "    ")
    }

    fun symbolsLogTruePass() {

        unsuccessfulAuthorization("!@#", "password2")
    }

    fun trueLogSymbolsPass() {

        unsuccessfulAuthorization("login2", "##%%$")
    }

    fun symbolsLogSymbolsPass() {

        unsuccessfulAuthorization("()^&*", "'$^:!-")
    }
}
