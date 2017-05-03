package at.xp2_2017.battlefood;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("at.xp2_2017.battlefood", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<Login> mActivityRule = new ActivityTestRule<>(Login.class);

    @Test
    public void testLoginButton() throws Exception {

        onView(withId(R.id.btnLogin)).perform(click());
    }

    @Test
    public void testLoginEmpty() throws Exception {

        onView(withId(R.id.etEmailLogin)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.etPasswordLogin)).perform(typeText("123456"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform((click()));
        onView(withId(R.id.txtcheckLogin)).check(matches(withText("Fields are empty")));

    }

    @Test
    public void testEmail() throws Exception {

        onView(withId(R.id.etEmailLogin)).perform(typeText("test.email@tugraz.at"), closeSoftKeyboard());
        onView(withId(R.id.etEmailLogin)).check(matches(withText("test.email@tugraz.at")));
    }

    @Test
    public void testPassword() throws Exception {

        onView(withId(R.id.etPasswordLogin)).perform(typeText("abc123"), closeSoftKeyboard());
        onView(withId(R.id.etPasswordLogin)).check(matches(withText("abc123")));
    }

    @Test
    public void testLoginFailed() throws Exception {

        onView(withId(R.id.etEmailLogin)).perform(typeText("m@m.at"), closeSoftKeyboard());
        onView(withId(R.id.etPasswordLogin)).perform(typeText("12345678"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform((click()));
        sleep(2000);
        onView(withId(R.id.txtcheckLogin)).check(matches(withText("Sign in failed")));
    }

}