package ru.iteco.fmhandroid.ui.testhelper

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import io.qameta.allure.kotlin.Allure
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

        Allure.step("Нажатие на кнопку сокрытия новостного блока")

        Thread.sleep(5000)

        clickButtonWithChildAtPosition(hidingNewsBlockButton)

        allNewsButton.check(matches(not(isDisplayed())))

    }

    fun clickOnAllNewsButton() {

        Allure.step("Нажатие на кнопку отображения всех новостей")

        Thread.sleep(5000)

        clickButton(R.id.all_news_text_view)

        filterNewsButton.check(matches(isDisplayed()))

    }

    fun clickNewsCard() {

        Allure.step("Нажатие на карточку новости в новостном блоке")

        Thread.sleep(5000)

        clickOnNewsItemCard()

        newsItemDescription.check(matches(isDisplayed()))

    }

    fun clickOnAllClaimsButton() {

        Allure.step("Нажатие на кнопку отображения всех претензий")

        Thread.sleep(5000)

        clickButton(R.id.all_claims_text_view)

        filterClaimsButton.check(matches(isDisplayed()))

    }
}
