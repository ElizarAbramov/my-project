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
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.logout

@LargeTest
@RunWith(AllureAndroidJUnit4::class)

class LogoutTest {

    @Rule
    @JvmField
    var chain: RuleChain = RuleChain.outerRule(ActivityScenarioRule(AppActivity::class.java))
        .around(ScreenshotRule(ScreenshotRule.Mode.FAILURE, "screenshot"))

    @Before

    fun loginIfNotLogged() {

        if (!checkIfLogin()) {
            trueLogTruePass()
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
        trueLogTruePass()
        Allure.step("Авторизация после логаута успешно осуществлена")

    }
}
