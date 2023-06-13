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
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.AboutSectionHelper.aboutTest
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin

@LargeTest
@RunWith(AllureAndroidJUnit4::class)

class AboutSectionTest {

    @Before

    fun loginIfNotLogged() {

        if (!checkIfLogin()) {
            trueLogTruePass()
        }
    }

    @Rule
    @JvmField
    var chain: RuleChain = RuleChain.outerRule(ActivityScenarioRule(AppActivity::class.java))
        .around(ScreenshotRule(ScreenshotRule.Mode.FAILURE, "screenshot"))

    @Test
    @DisplayName("Переход в раздел О приложении")
    @Description("Переход в раздел О приложении при помощи гамбургер-меню")
    fun openAboutSectionWithHamburgerMenu() {

        aboutTest()
        Allure.step("Переход в раздел о приложении осуществлен")

    }
}
