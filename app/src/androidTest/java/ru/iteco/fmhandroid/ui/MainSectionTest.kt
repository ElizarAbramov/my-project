package ru.iteco.fmhandroid.ui

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.MainSectionHelper.clickNewsCard
import ru.iteco.fmhandroid.ui.testhelper.MainSectionHelper.clickOnAllClaimsButton
import ru.iteco.fmhandroid.ui.testhelper.MainSectionHelper.clickOnAllNewsButton
import ru.iteco.fmhandroid.ui.testhelper.MainSectionHelper.clickOnHidingNewsButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin


@LargeTest
@RunWith(
    AndroidJUnit4::class
)

class MainSectionTest {

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
    fun hidingAllNewsBlock() {

        clickOnHidingNewsButton()
    }

    @Test
    fun allNewsButtonFunctionality() {

        clickOnAllNewsButton()
    }

    @Test
    fun viewingDescriptionOfANewsItemInsideNewsBlock() {

        clickNewsCard()
    }


    @Test
    fun allClaimsButtonFunctionality() {

        clickOnAllClaimsButton()
    }
}
