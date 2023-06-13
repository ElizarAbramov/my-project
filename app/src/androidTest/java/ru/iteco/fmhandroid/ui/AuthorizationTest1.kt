package ru.iteco.fmhandroid.ui

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import io.qameta.allure.android.rules.ScreenshotRule
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.Allure
import io.qameta.allure.kotlin.Description
import io.qameta.allure.kotlin.junit4.DisplayName
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
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
@RunWith(AllureAndroidJUnit4::class)

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
    var chain: RuleChain = RuleChain.outerRule(ActivityScenarioRule(AppActivity::class.java))
        .around(ScreenshotRule(ScreenshotRule.Mode.FAILURE, "screenshot"))

    @Test
    @DisplayName("Успешная авторизация")
    @Description("Успешная авторизация с валидным логином и паролем")
    fun authorizationTrueLogTruePass() {
        trueLogTruePass()
        Allure.step("Авторизация прошла успешно")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с невалдиным логином и паролем")
    fun authorizationWrongLogWrongPass() {

        wrongLogWrongPass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с невалидным логином и валидным паролем")
    fun authorizationWrongLogTruePass() {

        wrongLogTruePass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с пустым полем логина и пароля")
    fun authorizationEmptyLogEmptyPass() {

        emptyLogEmptyPass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с валидным логином и невалидным паролем")
    fun authorizationTrueLogWrongPass() {

        trueLogWrongPass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с пустым полем логина и валидным паролем")
    fun authorizationEmptyLogTruePass() {

        emptyLogTruePass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с валидным логином и пустым полем пароля")
    fun authorizationTrueLogEmptyPass() {

        trueLogEmptyPass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с вводом пробелов в поле логина и пароля")
    fun authorizationBackspaceLogBackspacePass() {

        backspaceLogBackspacePass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с вводом пробелов в поле логина и валидным паролем")
    fun authorizationBackspaceLogTruePass() {

        backspaceLogTruePass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с валидным логином и вводом пробелов в поле пароля")
    fun authorizationTrueLogBackspacePass() {

        trueLogBackspacePass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с вводом символов в поле логина и валидным паролем")
    fun authorizationSymbolsLogTruePass() {

        symbolsLogTruePass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с валидным логином и вводом симолов в поле пароля")
    fun authorizationTrueLogSymbolsPass() {

        trueLogSymbolsPass()
        Allure.step("Авторизация не осуществлена")
    }

    @Test
    @DisplayName("Неудачная авторизация")
    @Description("Неудачная авторизация с вводом символом в поле логина и пароля")
    fun authorizationSymbolsLogSymbolsPass() {

        symbolsLogSymbolsPass()
        Allure.step("Авторизация не осуществлена")
    }

}
