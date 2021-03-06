package at.xp2_2017.battlefood;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ARegistrationInstrumentedTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("at.xp2_2017.battlefood", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<RegistrationUI> mActivityRule = new ActivityTestRule<>(RegistrationUI.class);

    @Test
    public void testFailureRegistration() throws Exception{

        onView(withId(R.id.editTextUserName)).perform(typeText("test"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).perform(typeText("test@student1.tugraz.at"),closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText("123"),closeSoftKeyboard());
        onView(withId(R.id.editTextRetypePassword)).perform(typeText("123"),closeSoftKeyboard());
        onView(withId(R.id.buttonRegister)).perform(click());
        sleep(5000);
        onView(withId(R.id.buttonRegister)).check(matches(withText("Register")));

    }

    @Test
    public void testValidRegistration() throws Exception {

        final FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();

        if(FirebaseAuth.getInstance() != null)
            FirebaseAuth.getInstance().signOut();

        onView(withId(R.id.editTextUserName)).perform(typeText("tester1234"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).perform(typeText("test@student1.tugraz.at"),closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText("1234567"),closeSoftKeyboard());
        onView(withId(R.id.editTextRetypePassword)).perform(typeText("1234567"),closeSoftKeyboard());
        onView(withId(R.id.buttonRegister)).perform(click());

        sleep(5000);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        boolean test = false;
        if(currentUser == null)
        {
            test = true;
        }
        else {
            test = false;
            currentUser.delete();
        }
        assertEquals(test,false);

        //onView(withId(R.id.txtMainA)).check(matches(withText("FoodBattle by Team Tim")));
    }

}
