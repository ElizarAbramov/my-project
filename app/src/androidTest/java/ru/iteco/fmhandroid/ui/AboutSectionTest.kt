package ru.iteco.fmhandroid.ui


import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.AboutSectionHelper.aboutTest
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin


@LargeTest
@RunWith(AndroidJUnit4::class)

class AboutSectionTest {

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
    fun openAboutSectionWithHamburgerMenu() {

        aboutTest()
    }
}
