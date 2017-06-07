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
    public void testClickHome() throws Exception {
        final FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        mAuth.getInstance();
        mAuth.signInWithEmailAndPassword("test1@test.com", "test123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

            }
        });

        sleep(5000);
        onView(withId(R.id.HomeBtn)).perform(click());
        intended(hasComponent(StartUI.class.getName()));
    }

    @Test
    public void testClickUploadRecipe() throws Exception {
        onView(withId(R.id.RecipeUpload)).perform(click());
        intended(hasComponent(UploadRecipeUi.class.getName()));
    }

    @Test
    public void testClickLogout() throws Exception {
        onView(withId(R.id.Logout)).perform(click());
        sleep(5000);
        intended(hasComponent(Login.class.getName()));
    }

    @Test
    public void testClickVoteRecipe() throws Exception {
        onView(withId(R.id.WatchVotesBtn)).perform(click());
        intended(hasComponent(VotesUI.class.getName()));
    }

}
