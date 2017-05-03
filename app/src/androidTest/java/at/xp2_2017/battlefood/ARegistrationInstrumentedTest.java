package at.xp2_2017.battlefood;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class RegistrationInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("at.xp2_2017.battlefood", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<RegistrationUI> mActivityRule = new ActivityTestRule<>(RegistrationUI.class);


    @Test
    public void testValidRegistration() throws Exception {
/*
        onView(withId(R.id.editTextUserName)).perform(typeText("lalalalalala"),closeSoftKeyboard());
        onView(withId(R.id.editTextUserName)).check(matches(withText("lalalalalala")));


        onView(withId(R.id.editTextEmail)).perform(typeText("test@student.tugraz.at"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).check(matches(withText("test@student.tugraz.at")));

        onView(withId(R.id.editTextPassword)).perform(typeText("1234567"),closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).check(matches(withText("1234567")));

        onView(withId(R.id.editTextRetypePassword)).perform(typeText("1234567"),closeSoftKeyboard());
        onView(withId(R.id.editTextRetypePassword)).check(matches(withText("1234567")));

        onView(withId(R.id.buttonRegister)).perform(click());

        sleep(10000);

        //onView(withId(R.id.buttonReg)).check(matches(withText("Register")));


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        currentUser.delete();
        */
    }

}
