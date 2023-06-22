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
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.logout
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.successfulAuthorization

@LargeTest
@RunWith(AllureAndroidJUnit4::class)

class LogoutTest : BaseClass() {


    @Before

    fun loginIfNotLogged() {

        if (!checkIfLogin()) {
            successfulAuthorization()
        }
    }

    @Test
    @DisplayName("Осуществление логаута из профиля")
    @Description("Осуществление логаута из профиля кнопкой логаут")
    fun logoutTest() {

        logout()
        Allure.step("Логаут выполнен")

    }

    @Test
    @DisplayName("Осуществление логаута с последующей авторизацией")
    @Description("Производится логаут с последующим входом в аккаунт под валидными данными")
    fun loginAfterLogout() {

        logout()
        successfulAuthorization()
        Allure.step("Авторизация после логаута успешно осуществлена")

    }
}
