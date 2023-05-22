package ru.iteco.fmhandroid.ui

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.AuthorizationHelper.trueLogTruePass
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.logout

@LargeTest
@RunWith(
    AndroidJUnit4::class
)
class LogoutTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(AppActivity::class.java)

    @Before

    fun loginIfNotLogged() {

        if (!checkIfLogin()) {
            trueLogTruePass()
        }
    }

    @Test
    fun logoutTest() {

        logout()

    }

    @Test
    fun loginAfterLogout() {

        logout()
        trueLogTruePass()

    }
}
