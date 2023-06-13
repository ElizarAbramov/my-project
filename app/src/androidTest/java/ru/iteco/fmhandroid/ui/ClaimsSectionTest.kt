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
import ru.iteco.fmhandroid.ui.testhelper.ClaimsSectionHelper.addNewClaim
import ru.iteco.fmhandroid.ui.testhelper.ClaimsSectionHelper.addNewClaimEmptyDateAndTime
import ru.iteco.fmhandroid.ui.testhelper.ClaimsSectionHelper.addNewCommentToClaim
import ru.iteco.fmhandroid.ui.testhelper.ClaimsSectionHelper.addingClaimAndOpenIt
import ru.iteco.fmhandroid.ui.testhelper.ClaimsSectionHelper.addingNewClaimAllEmpty
import ru.iteco.fmhandroid.ui.testhelper.ClaimsSectionHelper.addingNewClaimEmptyDescription
import ru.iteco.fmhandroid.ui.testhelper.ClaimsSectionHelper.addingNewClaimEmptyTitle
import ru.iteco.fmhandroid.ui.testhelper.ClaimsSectionHelper.switchToClaimsSection
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin

@LargeTest
@RunWith(AllureAndroidJUnit4::class)


class ClaimsSectionTest {

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
    @DisplayName("Переход в раздел претензий")
    @Description("Переход в раздел претензий с использованием гамбургер-меню")
    fun switchToClaimsSectionWithHamburgerMenu() {

        switchToClaimsSection()
        Allure.step("Переход в раздел с претензиями осуществлен")
    }

    @Test
    @DisplayName("Создание новой претензии")
    @Description("Создание новой претензии с заполнением всех полей валидными данными")
    fun addingNewClaimWithValidFields() {

        addNewClaim(
            "Андрей не выпил теблетки", 2023, 5, 6, 14, 33,
            "Выпить нужно вовремя"
        )
        Allure.step("Претензия с заполнением всех полей валидными данными создана")
    }

    @Test
    @DisplayName("Создание новой претензии")
    @Description("Создание новой претензии с пустыми полями даты и времени")
    fun addingNewClaimWithEmptyDateAndTimeFields() {

        addNewClaimEmptyDateAndTime("Дмитрий ушел спать рано", "Разбудите его в двенадцать часов")
        Allure.step("Претензия с пустыми полями даты и времени не создана, появилось сообщение об ошибке Fill empty fields")
    }

    @Test
    @DisplayName("Создание новой претензии")
    @Description("Создание новой претензии с пустым полем описания")
    fun addingNewClaimWithEmptyDescriptionField() {

        addingNewClaimEmptyDescription("Проветривать строго после уборки", 2023, 5, 5, 14, 20)
        Allure.step("Претензия с пустым полем описания не создана, появилось сообщение об ошибке Fill empty fields")
    }

    @Test
    @DisplayName("Создание новой претензии")
    @Description("Создание новой претензии с пустым полем заголовка")
    fun addingNewClaimWithEmptyTitleField() {

        addingNewClaimEmptyTitle(2023, 5, 4, 13, 55, "Денис любит слушать джаз по вечерам")
        Allure.step("Претензия с пустым полем заголовка не создана, появилось сообщение об ошибке Fill empty fields")
    }

    @Test
    @DisplayName("Создание новой претензии")
    @Description("Создание новой претензии со всеми пустыми полями")
    fun addingNewClaimWithAllEmptyFields() {

        addingNewClaimAllEmpty()
        Allure.step("Претензия со всеми пустыми полями не создана, появилось сообщние об ошибке Fill empty fields")
    }

    @Test
    @DisplayName("Создание новой претензии")
    @Description("Создание новой претензии и открытие карточки этой претензии")
    fun createClaimCardThenOpenIt() {

        addingClaimAndOpenIt(
            "Мария гуляет с трех до четырех", 2023, 5, 7, 14, 22,
            "Обязательно присматривайте за ней"
        )
        Allure.step("Претензия создана, карточка созданной претензии открыта")
    }

    @Test
    @DisplayName("Добавление комментария к претензии ")
    @Description("Создание претензии и добавление комментария к этой же претензии")
    fun createComment() {
        addNewCommentToClaim(
            "Денис гуляет много", 2023, 5, 6, 12, 33,
            "Он любит гулять"
        )
        Allure.step("Претензия создана, комментарий к созданной претензии успешно добавлен")
    }
}
