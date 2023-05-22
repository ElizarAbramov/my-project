package ru.iteco.fmhandroid.ui.testhelper;

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.clickButtonWithText
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.privacyPolicy
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.termsOfUse

object AboutSectionHelper {

    fun aboutTest() {

        Thread.sleep(5000)

        clickButton(R.id.main_menu_image_button)

        clickButtonWithText(android.R.id.title, "About")

        privacyPolicy.check(matches(withText("https://vhospice.org/#/privacy-policy/")))

        termsOfUse.check(matches(withText("https://vhospice.org/#/terms-of-use")))
    }

}
