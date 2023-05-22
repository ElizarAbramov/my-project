package ru.iteco.fmhandroid.ui

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.NewsSectionHelper.controlPanel
import ru.iteco.fmhandroid.ui.testhelper.NewsSectionHelper.createNews
import ru.iteco.fmhandroid.ui.testhelper.NewsSectionHelper.switchToNewsSection
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin


@LargeTest
@RunWith(AndroidJUnit4::class)
class NewsSectionTest {

    fun loginIfNotLogged() {

        if (checkIfLogin()) {
            trueLogTruePass()
        }
    }

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(AppActivity::class.java)

    @Test
    fun switchToNewsSectionWithHamburgerMenu() {

        switchToNewsSection()
    }

    @Test
    fun switchToNewsControlPanel() {

        controlPanel()
    }

    @Test
    fun addingNews() {
        //Вписать в newsCategory одну из доступных категорий :"Объявление", "День рождения",
        // "Зарпалата", "Профсоюз", "Праздник","Массаж", "Благодарность", "Нужно помощь".
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
    }
}
