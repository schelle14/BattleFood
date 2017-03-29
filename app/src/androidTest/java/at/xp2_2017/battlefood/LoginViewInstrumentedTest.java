package at.xp2_2017.battlefood;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static at.xp2_2017.battlefood.R.id.btnLogin;
import static at.xp2_2017.battlefood.R.id.etPassword;
import static at.xp2_2017.battlefood.R.id.etUsername;
import static org.junit.Assert.*;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginViewInstrumentedTest {
    @Rule
    public ActivityTestRule<LoginController> myActivityRule = new ActivityTestRule<>(LoginController.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("at.xp2_2017.battlefood", appContext.getPackageName());
    }

    @Test
    public void testLoginSucess()
    {
        onView(withId(etUsername)).perform(typeText("mwhity"));
        onView(withId(etPassword)).perform(typeText("12345"));
        onView(withId(btnLogin)).perform(click());
        onView(withId(R.id.txtStatus)).check(matches(withText("Login successful!")));
    }

    @Test
    public void testLoginFailure()
    {
        onView(withId(etUsername)).perform(typeText("mwhity"));
        onView(withId(etPassword)).perform(typeText("1234"));
        onView(withId(btnLogin)).perform(click());
        onView(withId(R.id.txtStatus)).check(matches(withText("Login failed!")));

    }
}
