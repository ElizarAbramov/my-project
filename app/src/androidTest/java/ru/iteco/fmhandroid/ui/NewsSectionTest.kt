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
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.NewsSectionHelper.controlPanel
import ru.iteco.fmhandroid.ui.testhelper.NewsSectionHelper.createNews
import ru.iteco.fmhandroid.ui.testhelper.NewsSectionHelper.switchToNewsSection
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin


@LargeTest
@RunWith(AllureAndroidJUnit4::class)
class NewsSectionTest {

    fun loginIfNotLogged() {

        if (checkIfLogin()) {
            trueLogTruePass()
        }
    }

    @Rule
    @JvmField
    var chain: RuleChain = RuleChain.outerRule(ActivityScenarioRule(AppActivity::class.java))
        .around(ScreenshotRule(ScreenshotRule.Mode.FAILURE, "screenshot"))

    @Test
    @DisplayName("Переход в секцию новостей")
    @Description("Переход в секцию новостей при помощи гамбургер-меню")
    fun switchToNewsSectionWithHamburgerMenu() {

        switchToNewsSection()
        Allure.step("Переход в секцию новостей осуществлен успешно")
    }

    @Test
    @DisplayName("Переход в панель управления новостями")
    @Description("Переход в секцию новостей с последующим переходом в панель упраления")
    fun switchToNewsControlPanel() {

        controlPanel()
        Allure.step("Переход в панель упраления новостями осуществлен успешно")
    }

    @Test
    @DisplayName("Создание новости")
    @Description(
        "Вписать в newsCategory одну из доступных категорий :\"Объявление\", \"День рождения\",\n" +
                "        // \"Зарпалата\", \"Профсоюз\", \"Праздник\",\"Массаж\", \"Благодарность\", \"Нужно помощь\"."
    )
    fun addingNews() {

        createNews(
            "Объявление",
            "Бориса навещают по вторникам",
            2023,
            5,
            10,
            15,
            45,
            "Чаще всего приходит его брат"
        )
        Allure.step("Новость создана успешно")
    }
}
