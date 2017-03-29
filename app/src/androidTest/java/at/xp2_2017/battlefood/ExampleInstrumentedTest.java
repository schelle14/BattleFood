package at.xp2_2017.battlefood;

import android.app.Activity;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("at.xp2_2017.battlefood", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testRegisterButton() throws Exception {

        onView(withText("Register")).perform(click());
        onView(withText("Register")).perform(click());

    }

    @Test
    public void testRegistrationLabel() throws Exception {

        onView(withText("Register")).perform(click());
        onView(withId(R.id.textViewRegistration)).check(matches(withText("Registration")));
    }


    @Test
    public void testUsername() throws Exception {

        onView(withText("Register")).perform((click()));
        onView(withId(R.id.editTextUserName)).perform(typeText("Max"), closeSoftKeyboard());
        onView(withId(R.id.editTextUserName)).check(matches(withText("Max")));
    }

    @Test
    public void testEmail() throws Exception {

        onView(withText("Register")).perform((click()));
        onView(withId(R.id.editTextEmail)).perform(typeText("test.email@tugraz.at"), closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).check(matches(withText("test.email@tugraz.at")));

    }

    @Test
    public void testPassword() throws Exception {

        onView(withText("Register")).perform((click()));
        onView(withId(R.id.editTextPassword)).perform(typeText("abc123"), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).check(matches(withText("abc123")));
    }

    @Test
    public void testRetypePassword() throws Exception {

        onView(withText("Register")).perform((click()));
        onView(withId(R.id.editTextRetypePassword)).perform(typeText("abc123"), closeSoftKeyboard());
        onView(withId(R.id.editTextRetypePassword)).check(matches(withText("abc123")));
    }





}
