package ru.iteco.fmhandroid.ui.testhelper

import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import io.qameta.allure.kotlin.Allure
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import ru.iteco.fmhandroid.R


object TestHelper {

    fun logout() {

        Allure.step("Осуществление логаута")

        Thread.sleep(5000)

        authorizationButton.perform(click())

        val materialTextView = onView(
            allOf(
                withId(android.R.id.title), withText("Log out")
            )
        )
        materialTextView.perform(click())

        authorizationText.check(matches(isDisplayed()))

    }


    fun chooseTime(matcher: Int, hours: Int, minutes: Int) {

        Allure.step("Выбор времени")

        val selectionTime = onView(
            allOf(
                withId(matcher),

                isDisplayed()
            )
        )
        selectionTime.perform(click())
        onView(isAssignableFrom(TimePicker::class.java)).perform(
            PickerActions.setTime(hours, minutes)

        )
        onView(withId(android.R.id.button1)).perform(click())

    }

    fun chooseDate(matcher: Int, year: Int, monthOfYear: Int, dayOfMonth: Int) {

        Allure.step("Выбор даты")

        onView(
            allOf(
                withId(matcher),

                isDisplayed()
            )
        ).perform(click())

        onView(withClassName(equalTo(DatePicker::class.java.name))).perform(
            PickerActions.setDate(
                year,
                monthOfYear,
                dayOfMonth
            )
        )
        onView(withId(android.R.id.button1)).perform(click())

    }

    // Main Section

    val hidingNewsBlockButton: ViewInteraction = onView(
        allOf(
            withId(R.id.expand_material_button),
            childAtPosition(
                childAtPosition(
                    withId(R.id.container_list_news_include_on_fragment_main),
                    0
                ),
                4
            ),
            isDisplayed()
        )
    )

    val allNewsButton: ViewInteraction = onView(withId(R.id.all_news_text_view))

    val filterNewsButton: ViewInteraction = onView(withId(R.id.filter_news_material_button))

    val filterClaimsButton: ViewInteraction = onView(withId(R.id.filters_material_button))

    val newsItemDescription: ViewInteraction = onView(
        allOf(
            withId(R.id.news_item_description_text_view),
            childAtPosition(
                childAtPosition(
                    withId(R.id.news_item_material_card_view),
                    0
                ),
                6
            ),
            isDisplayed()
        )
    )

    fun clickOnNewsItemCard() {

        Allure.step("Нажатие на карточку новости")

        val recyclerView = onView(
            allOf(
                withId(R.id.news_list_recycler_view),
                childAtPosition(
                    withId(R.id.all_news_cards_block_constraint_layout),
                    0
                )
            )
        )
        recyclerView.perform(
            RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(
                0,
                click()
            )
        )
    }

    fun clickButtonWithChildAtPosition(matcher: ViewInteraction) {

        Allure.step("Нажатие на кнопку с указанием ChildAtPosition")

        matcher.perform(click())

    }

    //    Authorization

    fun checkIfLogin(): Boolean {

        Allure.step("Проверка на наличие авторизации")

        Thread.sleep(5000)

        val isLogin: Boolean = try {
            onView(allOf(withId(R.id.main_swipe_refresh), isDisplayed())).perform(swipeDown())

            true
        } catch (err: NoMatchingViewException) {
          false

        }
        return isLogin
    }

    fun unsuccessfulAuthorization(login: String, password: String) {

        Allure.step("Неудачная авторизация")

        Thread.sleep(5000)

        replaceTextAndCloseKeyboard(R.id.login_text_input_edit_text, login)

        replaceTextAndCloseKeyboard(R.id.password_text_input_edit_text, password)

        clickButton(R.id.enter_button)

        Thread.sleep(3000)

        authorizationScreenText.check(matches(isDisplayed()))
    }

    fun successfulAuthorization() {

        Thread.sleep(5000)

        Allure.step("Удачная авторизация")

        val login = "login2"

        val password = "password2"

        replaceTextAndCloseKeyboard(R.id.login_text_input_edit_text, login)

        replaceTextAndCloseKeyboard(R.id.password_text_input_edit_text, password)

        clickButton(R.id.enter_button)

        Thread.sleep(3000)

        authorizationButton.check(matches(isDisplayed()))
    }

    fun replaceTextAndCloseKeyboard(matcher: Int, text: String) {

        Allure.step("Замена текста с последующим закртием клавиатуры")

        onView(
            allOf(
                withId(matcher), isDisplayed()
            )
        ).perform(click(), replaceText(text), closeSoftKeyboard())

    }

    fun clickButton(matcher: Int) {

        Allure.step("Нажатие на кнопку")

        onView(

            allOf(
                withId(matcher), isDisplayed()
            )
        ).perform(click())

    }

    val authorizationButton: ViewInteraction = onView(
        allOf(
            withId(R.id.authorization_image_button), isDisplayed()
        )
    )

    private val authorizationScreenText: ViewInteraction = onView(
        allOf(
            withText("Authorization"), isDisplayed()
        )
    )

    //Claims

    fun clickButtonWithText(matcher: Int, text: String) {

        Allure.step("Нажатие на кнопку с текстом")

        val claimsButton = onView(
            allOf(
                withId(matcher), withText(text),

                isDisplayed()
            )
        )
        claimsButton.perform(click())

    }

    fun replaceClaimCommentTextAndCloseKeyboard(matcher: Int, text: String) {

        Allure.step("Замена текста в поле комментария претензии и последующее закрытие клавиатуры")

        onView(
            allOf(
                isDescendantOfA(withId(matcher)),
                withClassName(endsWith("EditText"))
            )
        ).perform(
            replaceText(text)
        )
    }

    fun checkText(matcher: Int, text: String) {

        Allure.step("Проверка текста в сообщении")

        val errorMessage = onView(
            allOf(
                withId(matcher), withText(text),
                isDisplayed()
            )
        )
        errorMessage.check(matches(withText(text)))

    }

    val claimsScreenText: ViewInteraction = onView(
        allOf(
            withText("Claims"), isDisplayed()
        )
    )


    fun selectingChiefExecutor() {

        Allure.step("Выбор главного исполнителя")

        val executorField = onView(
            allOf(
                withId(R.id.executor_drop_menu_auto_complete_text_view),
                isDisplayed()
            )
        ).perform(click(), pressKey(KeyEvent.KEYCODE_DPAD_RIGHT))

        Thread.sleep(1000)

        executorField.perform(
            pressKey(KeyEvent.KEYCODE_ENTER), pressKey(KeyEvent.KEYCODE_DPAD_DOWN), pressKey(
                KeyEvent.KEYCODE_ENTER
            ), closeSoftKeyboard()

        )
    }

    fun scrollToClaimWithTitle(matcher: Int, text: String): ViewInteraction? {

        Allure.step("Прокручивание до претензии с заголовком")

        return onView(
            withId(matcher)
        ).perform(
            RecyclerViewActions.scrollTo<ViewHolder>(
                hasDescendant(
                    withText(text)
                )
            )

        )

    }

    fun scrollToClaimWithTitleAndOpenIt(matcher: Int, text: String): ViewInteraction? {

        return onView(
            withId(matcher)
        ).perform(
            RecyclerViewActions.actionOnItem<ViewHolder>(
                hasDescendant(
                    withText(text)
                ), click()
            )

        )

    }

    fun checkMessageIsDisplayed(matcher: Int, text: String) {

        Allure.step("Проверка отображения сообщения")

        val errorMessage = onView(
            allOf(
                withId(matcher), withText(text),
                isDisplayed()
            )
        )
        errorMessage.check(matches(withText(text)))
    }

//    News

    val newsScreenText: ViewInteraction = onView(
        allOf(
            withText("News"),
        )
    )

    val controlPanelText: ViewInteraction = onView(
        allOf(
            withText("Control panel"), isDisplayed()
        )
    )

    fun selectNewsCategory(text: String) {

        Allure.step("Выбор новостной категории")

        onView(withText(text))
            .inRoot(RootMatchers.isPlatformPopup())
            .perform(click())

    }

    fun scrollToNewsWithTitle(matcher: Int, text: String): ViewInteraction? {

        Allure.step("Прокрутка до новости с заголовком")

        return onView(
            withId(matcher)
        ).perform(
            RecyclerViewActions.scrollTo<ViewHolder>(
                hasDescendant(
                    withText(text)
                )
            )

        )
    }

//    About

    private val authorizationText: ViewInteraction = onView(
        allOf(
            withText("Authorization"),
            isDisplayed()
        )
    )


//    Thematic

    val quotesList: ViewInteraction = onView(
        allOf(
            withId(R.id.our_mission_item_list_recycler_view),

            isDisplayed()
        )
    )

    val mottoText: ViewInteraction = onView(
        allOf(
            withId(R.id.our_mission_title_text_view),

            isDisplayed()
        )
    )

    val quotesItem: ViewInteraction = onView(
        allOf(
            withId(R.id.our_mission_item_material_card_view),
            childAtPosition(
                withId(R.id.our_mission_item_list_recycler_view),
                0
            )
        )
    )
    val quotesText: ViewInteraction = onView(
        allOf(
            withId(R.id.our_mission_item_description_text_view),

            isDisplayed()
        )
    )
    val privacyPolicy: ViewInteraction = onView(
        allOf(
            withId(R.id.about_privacy_policy_value_text_view),
            withText("https://vhospice.org/#/privacy-policy/"),
            isDisplayed()
        )
    )

    val termsOfUse: ViewInteraction = onView(
        allOf(
            withId(R.id.about_terms_of_use_value_text_view),
            withText("https://vhospice.org/#/terms-of-use"),
            isDisplayed()
        )
    )
}


private fun childAtPosition(
    parentMatcher: Matcher<View>, position: Int
): Matcher<View> {

    return object : TypeSafeMatcher<View>() {
        override fun describeTo(description: Description) {
            description.appendText("Child at position $position in parent ")
            parentMatcher.describeTo(description)
        }

        public override fun matchesSafely(view: View): Boolean {
            val parent = view.parent
            return parent is ViewGroup && parentMatcher.matches(parent)
                    && view == parent.getChildAt(position)
        }
    }
}
