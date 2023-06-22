package ru.iteco.fmhandroid.ui

import BaseClass
import androidx.test.filters.LargeTest
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.Allure
import io.qameta.allure.kotlin.Description
import io.qameta.allure.kotlin.junit4.DisplayName
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.ui.testhelper.MainSectionHelper.clickNewsCard
import ru.iteco.fmhandroid.ui.testhelper.MainSectionHelper.clickOnAllClaimsButton
import ru.iteco.fmhandroid.ui.testhelper.MainSectionHelper.clickOnAllNewsButton
import ru.iteco.fmhandroid.ui.testhelper.MainSectionHelper.clickOnHidingNewsButton
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.checkIfLogin
import ru.iteco.fmhandroid.ui.testhelper.TestHelper.successfulAuthorization


@LargeTest
@RunWith(AllureAndroidJUnit4::class)

class MainSectionTest : BaseClass() {

    @Before

    fun loginIfNotLogged() {

        if (!checkIfLogin()) {
            successfulAuthorization()
        }
    }


    @Test
    @DisplayName("Сокрытие блока новостей на главном экране")
    @Description("Сокрытие блока новостей на главном экране с ипользованием соответствующей кнопки")
    fun hidingAllNewsBlock() {

        clickOnHidingNewsButton()
        Allure.step("Блок новостей на главном экране успешно скрыт")

    }

    @Test
    @DisplayName("Переход в блок со всеми новостями с главного экрана")
    @Description("Переход в блок со всеми новостями с главного экрана при нажатии на кнопку Все новости")
    fun allNewsButtonFunctionality() {

        clickOnAllNewsButton()
        Allure.step("Переход в блок новостей произведен успешно")

    }

    @Test
    @DisplayName("Просмотр описания новости")
    @Description("Просмотр описания новости внутри блока новостей на главном экране")
    fun viewingDescriptionOfANewsItemInsideNewsBlock() {

        clickNewsCard()
        Allure.step("Описание новости просматривается")

    }


    @Test
    @DisplayName("Переход в блок со всеми претензиями с главного экрана")
    @Description("Переход в блок со всеми претензиями с главного экрана при нажатии на кнопку Все претензии")
    fun allClaimsButtonFunctionality() {

        clickOnAllClaimsButton()
        Allure.step("Переход в блок с претензиями осуществлен успешно")

    }
}
