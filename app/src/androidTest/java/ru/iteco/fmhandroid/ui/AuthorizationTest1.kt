package ru.iteco.fmhandroid.ui

import BaseClass
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.Allure
import io.qameta.allure.kotlin.Description
import io.qameta.allure.kotlin.junit4.DisplayName
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.clickAuthButton
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.clickLogoutButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.successfulAuthorization
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.unsuccessfulAuthorization


@LargeTest
@RunWith(AllureAndroidJUnit4::class)

class AuthorizationTest1 : BaseClass() {

    @Before

    fun logoutIfLogged() {

        if (checkIfLogin()) {
            clickAuthButton()
            clickLogoutButton()

        }
    }


    @Test
    @DisplayName("Успешная авторизация")
    @Description("Успешная авторизация с валидным логином и паролем")
    fun authorizationTrueLogTruePass() {

        successfulAuthorization()
        Allure.step("Авторизация прошла успешно")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с невалдиным логином и паролем")
    fun authorizationWrongLogWrongPass() {

        unsuccessfulAuthorization("login", "parol")
        Allure.step("Авторизация не осуществлена")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с невалидным логином и валидным паролем")
    fun authorizationWrongLogTruePass() {

        unsuccessfulAuthorization("login", "password2")
        Allure.step("Авторизация не осуществлена")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с пустым полем логина и пароля")
    fun authorizationEmptyLogEmptyPass() {

        unsuccessfulAuthorization("", "")
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с валидным логином и невалидным паролем")
    fun authorizationTrueLogWrongPass() {

        unsuccessfulAuthorization("login2", "parol")
        Allure.step("Авторизация не осуществлена")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с пустым полем логина и валидным паролем")
    fun authorizationEmptyLogTruePass() {

        unsuccessfulAuthorization("", "password2")
        Allure.step("Авторизация не осуществлена")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с валидным логином и пустым полем пароля")
    fun authorizationTrueLogEmptyPass() {

        unsuccessfulAuthorization("login2", "")
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с вводом пробелов в поле логина и пароля")
    fun authorizationBackspaceLogBackspacePass() {

        unsuccessfulAuthorization("    ", "    ")
        Allure.step("Авторизация не осуществлена")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с вводом пробелов в поле логина и валидным паролем")
    fun authorizationBackspaceLogTruePass() {

        unsuccessfulAuthorization("    ", "password2")
        Allure.step("Авторизация не осуществлена")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с валидным логином и вводом пробелов в поле пароля")
    fun authorizationTrueLogBackspacePass() {

        unsuccessfulAuthorization("login2", "    ")
        Allure.step("Авторизация не осуществлена")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с вводом символов в поле логина и валидным паролем")
    fun authorizationSymbolsLogTruePass() {

        unsuccessfulAuthorization("!@#", "password2")
        Allure.step("Авторизация не осуществлена")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с валидным логином и вводом симолов в поле пароля")
    fun authorizationTrueLogSymbolsPass() {

        unsuccessfulAuthorization("login2", "##%%$")
        Allure.step("Авторизация не осуществлена")

    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с вводом символом в поле логина и пароля")
    fun authorizationSymbolsLogSymbolsPass() {

        unsuccessfulAuthorization("()^&*", "'$^:!-")
        Allure.step("Авторизация не осуществлена")
    }

}
