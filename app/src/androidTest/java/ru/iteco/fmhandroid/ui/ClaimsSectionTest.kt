package ru.iteco.fmhandroid.ui

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
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
@RunWith(AndroidJUnit4::class)

class ClaimsSectionTest {

    @Before

    fun loginIfNotLogged() {

        if (!checkIfLogin()) {
            trueLogTruePass()
        }
    }

    @Rule
    @JvmField

    var mActivityScenarioRule = ActivityScenarioRule(AppActivity::class.java)

    @Test
    fun switchToClaimsSectionWithHamburgerMenu() {

        switchToClaimsSection()
    }

    @Test
    fun addingNewClaimWithValidFields() {

        addNewClaim("Андрей не выпил теблетки",2023,5,6,14,33,
            "Выпить нужно вовремя")
    }

    @Test
    fun addingNewClaimWithEmptyDateAndTimeFields() {

        addNewClaimEmptyDateAndTime("Дмитрий ушел спать рано","Разбудите его в двенадцать часов")
    }

    @Test
    fun addingNewClaimWithEmptyDescriptionField() {

        addingNewClaimEmptyDescription("Проветривать строго после уборки",2023,5,5,14,20)
    }

    @Test
    fun addingNewClaimWithEmptyTitleField() {

        addingNewClaimEmptyTitle(2023,5,4,13,55,"Денис любит слушать джаз по вечерам")
    }

    @Test
    fun addingNewClaimWithAllEmptyFields() {

        addingNewClaimAllEmpty()
    }

    @Test
    fun createClaimCardThenOpenIt() {

        addingClaimAndOpenIt("Мария гуляет с трех до четырех",2023,5,7,14,22,
            "Обязательно присматривайте за ней")
    }

    @Test
    fun createComment(){
         addNewCommentToClaim("Денис гуляет много",2023,5,6,12,33,
             "Он любит гулять")
    }
}
