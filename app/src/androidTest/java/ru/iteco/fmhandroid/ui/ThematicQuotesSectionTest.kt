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
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.successfulAuthorization
import ru.iteco.fmhandroid.ui.testhelper.ThematicQuotesSectionHelper.openQuotesCard
import ru.iteco.fmhandroid.ui.testhelper.ThematicQuotesSectionHelper.openQuotesSection

@LargeTest
@RunWith(AllureAndroidJUnit4::class)

class ThematicQuotesSectionTest : BaseClass() {

    @Before

    fun loginIfNotLogged() {

        if (!checkIfLogin()) {
            successfulAuthorization()
        }
    }


    @Test
    @DisplayName("Переход в секцию тематических цитат")
    @Description("Переход в секцию тематических цитат с использованием специальной кнопки на главном экране")
    fun showingThematicQuotesSection() {

        openQuotesSection()
        Allure.step("Переход в секцию тематических цитат осуществлен успешно")

    }

    @Test
    @DisplayName("Открытие карточки с цитатой")
    @Description("Открытие карточки с цитатой в разделе с тематическими цитатами")
    fun openQuotesCardDescription() {

        openQuotesCard()
        Allure.step("Карточка цитаты открывается успешно")

    }
}
