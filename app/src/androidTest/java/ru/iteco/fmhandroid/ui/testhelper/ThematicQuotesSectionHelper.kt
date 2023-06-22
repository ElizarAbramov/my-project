package ru.iteco.fmhandroid.ui.testhelper

import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import io.qameta.allure.kotlin.Allure
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.mottoText
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.quotesItem
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.quotesList
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.quotesText

object ThematicQuotesSectionHelper {

    fun openQuotesSection() {

        Allure.step("Открытие секции тематических цитат")

        Thread.sleep(5000)

        clickButton(R.id.our_mission_image_button)

        quotesList.check(matches(isDisplayed()))

        mottoText.check(matches(isDisplayed()))
    }

    fun openQuotesCard() {

        Allure.step("Открытие карточки тематической цитаты")

        Thread.sleep(5000)

        clickButton(R.id.our_mission_image_button)

        quotesItem.perform(click())

        quotesText.check(matches(isDisplayed()))
    }
}