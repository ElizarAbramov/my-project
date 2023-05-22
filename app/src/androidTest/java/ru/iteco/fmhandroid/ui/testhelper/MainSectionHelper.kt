package ru.iteco.fmhandroid.ui.testhelper

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.hamcrest.Matchers.not
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.allNewsButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButtonWithChildAtPosition
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickOnNewsItemCard
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.filterClaimsButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.filterNewsButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.hidingNewsBlockButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.newsItemDescription

object MainSectionHelper {

    fun clickOnHidingNewsButton() {

        Thread.sleep(5000)

        clickButtonWithChildAtPosition(hidingNewsBlockButton)

        allNewsButton.check(matches(not(isDisplayed())))
    }

    fun clickOnAllNewsButton() {

        Thread.sleep(5000)

        clickButton(R.id.all_news_text_view)

        filterNewsButton.check(matches(isDisplayed()))
    }

    fun clickNewsCard(){

        Thread.sleep(5000)

        clickOnNewsItemCard()

        newsItemDescription.check(matches(isDisplayed()))

    }

    fun clickOnAllClaimsButton(){

        Thread.sleep(5000)

        clickButton(R.id.all_claims_text_view)

        filterClaimsButton.check(matches(isDisplayed()))


    }
}