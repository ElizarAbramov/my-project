package ru.iteco.fmhandroid.ui.testhelper

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButtonWithText
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.newsScreenText
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.testhelper.ClaimsSectionHelper.clickMenuButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.chooseDate
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.chooseTime
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.controlPanelText
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.replaceTextAndCloseKeyboard
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.scrollToNewsWithTitle
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.selectNewsCategory
import java.time.LocalTime

object NewsSectionHelper {

    fun switchToNewsSection() {
        Thread.sleep(4000)

        clickButton(R.id.main_menu_image_button)

        clickButtonWithText(android.R.id.title, "News")

        newsScreenText.check(matches(isDisplayed()))
    }

    fun controlPanel() {

        Thread.sleep(4000)

        clickButton(R.id.main_menu_image_button)

        clickButtonWithText(android.R.id.title, "News")

        clickButton(R.id.edit_news_material_button)

        controlPanelText.check(matches(isDisplayed()))
    }

    fun createNews(
        newsCategory: String,
        titleText: String,
        year: Int,
        month: Int,
        day: Int,
        hours: Int,
        minutes: Int,
        description: String
    ) {
        val title = titleText + LocalTime.now()

        Thread.sleep(4000)

        clickMenuButton()

        clickButtonWithText(android.R.id.title, "News")

        clickButton(R.id.edit_news_material_button)

        clickButton(R.id.add_news_image_view)

        clickButton(R.id.text_input_end_icon)

        selectNewsCategory(newsCategory)

        replaceTextAndCloseKeyboard(
            R.id.news_item_title_text_input_edit_text,
            title
        )

        chooseDate(R.id.news_item_publish_date_text_input_edit_text, year, month, day)

        chooseTime(R.id.news_item_publish_time_text_input_edit_text, hours, minutes)

        replaceTextAndCloseKeyboard(
            R.id.news_item_description_text_input_edit_text,
            description
        )

        clickButton(R.id.save_button)

        scrollToNewsWithTitle(
            R.id.news_list_recycler_view,
            title
        )?.check(
            matches(
                isDisplayed()
            )
        )
    }
}