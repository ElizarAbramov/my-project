package ru.iteco.fmhandroid.ui.testhelper

import androidx.test.espresso.action.ViewActions.click
import io.qameta.allure.kotlin.Allure
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.authorizationButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButtonWithText

object AuthorizationHelper {

    fun clickAuthButton() {

        Allure.step("Нажатие на authorizationButton")

        authorizationButton.perform(click())

    }

    fun clickLogoutButton() {

        Allure.step("Нажатие на кнопку логаута")

        clickButtonWithText(android.R.id.title, "Log out")

    }

}
