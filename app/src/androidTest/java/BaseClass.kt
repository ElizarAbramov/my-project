import androidx.test.ext.junit.rules.ActivityScenarioRule
import io.qameta.allure.android.rules.ScreenshotRule
import org.junit.Rule
import org.junit.rules.RuleChain
import ru.iteco.fmhandroid.ui.AppActivity

open class BaseClass {

    @Rule
    @JvmField
    var chain: RuleChain = RuleChain.outerRule(ActivityScenarioRule(AppActivity::class.java))
        .around(ScreenshotRule(ScreenshotRule.Mode.FAILURE, "screenshot"))

}