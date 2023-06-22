package ru.iteco.fmhandroid.ui.testhelper

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import io.qameta.allure.kotlin.Allure
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkMessageIsDisplayed
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkText
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.chooseDate
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.chooseTime
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.claimsScreenText
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButtonWithText
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.replaceClaimCommentTextAndCloseKeyboard
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.replaceTextAndCloseKeyboard
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.scrollToClaimWithTitle
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.scrollToClaimWithTitleAndOpenIt
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.selectingChiefExecutor
import java.time.LocalTime

object ClaimsSectionHelper {

    fun clickMenuButton() {

        Allure.step("Нажатие на кнопку главного меню")

        clickButton(R.id.main_menu_image_button)

    }

    fun switchToClaimsSection() {

        Allure.step("Переход в секцию с претензиями")

        Thread.sleep(4000)

        clickMenuButton()

        clickButtonWithText(android.R.id.title, "Claims")

        claimsScreenText.check(matches(isDisplayed()))

    }

    fun addNewClaim(text:String,year:Int, month:Int, day:Int, hours:Int, minutes:Int, description:String ) {

        Allure.step("Создание новой претензии")

        Thread.sleep(4000)

        val title = text + LocalTime.now()

        clickMenuButton()

        clickButtonWithText(android.R.id.title, "Claims")

        clickButton(R.id.add_new_claim_material_button)

        replaceTextAndCloseKeyboard(R.id.title_edit_text, title)

        selectingChiefExecutor()

        chooseDate(R.id.date_in_plan_text_input_edit_text, year,  month,day )

        chooseTime(R.id.time_in_plan_text_input_layout, hours, minutes)

        replaceTextAndCloseKeyboard(R.id.description_edit_text, description)

        clickButton(R.id.save_button)

        Thread.sleep(1500)

        scrollToClaimWithTitle(R.id.claim_list_recycler_view, title)?.check(matches(isDisplayed()))

    }

    fun addNewClaimEmptyDateAndTime(text:String, description: String) {

        Allure.step("Создание новой претензии с пустым полем даты и времени")

        Thread.sleep(4000)

        val title = text + LocalTime.now()

        clickMenuButton()

        clickButtonWithText(android.R.id.title, "Claims")

        clickButton(R.id.add_new_claim_material_button)

        replaceTextAndCloseKeyboard(R.id.title_edit_text, title)

        selectingChiefExecutor()

        replaceTextAndCloseKeyboard(R.id.description_edit_text, description)

        clickButton(R.id.save_button)

        checkMessageIsDisplayed(android.R.id.message, "Fill empty fields")

    }

    fun addingNewClaimEmptyDescription(text: String,year:Int,month: Int,day: Int,hours: Int,minutes: Int) {

        Allure.step("Создание новой претензии с пустым полем описания")

        Thread.sleep(5000)

        val title = text + LocalTime.now()

        clickMenuButton()

        clickButtonWithText(android.R.id.title, "Claims")

        clickButton(R.id.add_new_claim_material_button)

        replaceTextAndCloseKeyboard(R.id.title_edit_text, title)

        selectingChiefExecutor()

        chooseDate(R.id.date_in_plan_text_input_edit_text, year, month, day)

        chooseTime(R.id.time_in_plan_text_input_layout, hours, minutes)

        clickButton(R.id.save_button)

        checkMessageIsDisplayed(android.R.id.message, "Fill empty fields")

    }

    fun addingNewClaimEmptyTitle(year: Int,month: Int,day: Int,hours: Int,minutes: Int,text: String) {

        Allure.step("Создание новой претензии с пустым полем заголовка")

        Thread.sleep(5000)

        clickMenuButton()

        clickButtonWithText(android.R.id.title, "Claims")

        clickButton(R.id.add_new_claim_material_button)

        selectingChiefExecutor()

        chooseDate(R.id.date_in_plan_text_input_edit_text, year, month, day)

        chooseTime(R.id.time_in_plan_text_input_layout, hours, minutes)

        replaceTextAndCloseKeyboard(R.id.description_edit_text, text)

        clickButton(R.id.save_button)

        checkMessageIsDisplayed(android.R.id.message, "Fill empty fields")

    }

    fun addingNewClaimAllEmpty() {

        Allure.step("Создание новой претензии со всеми пустыми полями")

        Thread.sleep(5000)

        clickMenuButton()

        clickButtonWithText(android.R.id.title, "Claims")

        clickButton(R.id.add_new_claim_material_button)

        clickButton(R.id.save_button)

        checkMessageIsDisplayed(android.R.id.message, "Fill empty fields")

    }

    fun addingClaimAndOpenIt(text:String,year:Int, month:Int, day:Int, hours:Int, minutes:Int, description:String) {

        Thread.sleep(4000)

        Allure.step("Создание новой претензии и ее последующее открытие")

        val title = text + LocalTime.now()

        clickMenuButton()

        clickButtonWithText(android.R.id.title, "Claims")

        clickButton(R.id.add_new_claim_material_button)

        replaceTextAndCloseKeyboard(R.id.title_edit_text, title)

        selectingChiefExecutor()

        chooseDate(R.id.date_in_plan_text_input_edit_text, year, month, day)

        chooseTime(R.id.time_in_plan_text_input_layout, hours, minutes)

        replaceTextAndCloseKeyboard(R.id.description_edit_text, description)

        clickButton(R.id.save_button)

        Thread.sleep(1500)

        scrollToClaimWithTitleAndOpenIt(R.id.claim_list_recycler_view, title)

        checkText(R.id.title_text_view, title)

    }

    fun addNewCommentToClaim(text:String,year:Int, month:Int, day:Int, hours:Int, minutes:Int, description:String ) {

        Thread.sleep(4000)

        Allure.step("Добавление нового комментария к ранее созданной претензии")

        val title = text + LocalTime.now()

        clickMenuButton()

        clickButtonWithText(android.R.id.title, "Claims")

        clickButton(R.id.add_new_claim_material_button)

        replaceTextAndCloseKeyboard(R.id.title_edit_text, title)

        selectingChiefExecutor()

        chooseDate(R.id.date_in_plan_text_input_edit_text, year, month, day)

        chooseTime(R.id.time_in_plan_text_input_layout, hours, minutes)

        replaceTextAndCloseKeyboard(R.id.description_edit_text, description)

        clickButton(R.id.save_button)

        Thread.sleep(1000)

        scrollToClaimWithTitleAndOpenIt(R.id.claim_list_recycler_view, title)

        Thread.sleep(1000)

        clickButton(R.id.add_comment_image_button)

        replaceClaimCommentTextAndCloseKeyboard(R.id.comment_text_input_layout,"Пробный комментарий")

        Thread.sleep(1000)

        clickButton(R.id.save_button)

        checkText(R.id.comment_description_text_view,"Пробный комментарий")

    }
}
