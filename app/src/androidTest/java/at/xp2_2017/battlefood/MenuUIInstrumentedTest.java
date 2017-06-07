package at.xp2_2017.battlefood;

import android.support.annotation.NonNull;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.R.attr.password;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static at.xp2_2017.battlefood.R.id.txtcheckLogin;
import static java.lang.Thread.sleep;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class MenuUIInstrumentedTest {
    @Rule
    public IntentsTestRule<MenuUI> SUIActivityRule = new IntentsTestRule<>(MenuUI.class);

    @Test
    public void testHomeButton() throws Exception {
        onView(withId(R.id.btnMenuHome)).perform((click()));
        sleep(5000);
        intended(hasComponent(StartUI.class.getName()));
    }
}
