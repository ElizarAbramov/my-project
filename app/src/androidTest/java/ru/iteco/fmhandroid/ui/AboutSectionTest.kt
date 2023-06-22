package ru.iteco.fmhandroid.ui

import BaseClass
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.Description
import io.qameta.allure.kotlin.junit4.DisplayName
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.AboutSectionHelper.aboutTest
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.successfulAuthorization

@LargeTest
@RunWith(AllureAndroidJUnit4::class)

class AboutSectionTest : BaseClass() {

    @Before

    fun loginIfNotLogged() {

        if (!checkIfLogin()) {
            successfulAuthorization()
        }
    }

    @Test
    @DisplayName("Переход в раздел О приложении")
    @Description("Переход в раздел О приложении при помощи гамбургер-меню")
    fun openAboutSectionWithHamburgerMenu() {

        aboutTest()

    }
}
