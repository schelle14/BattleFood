package at.xp2_2017.battlefood;

import android.content.Context;
import android.graphics.Picture;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageView;

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
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static at.xp2_2017.battlefood.R.id.imgRecipePic;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class RecipeUploadInstrumentedTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("at.xp2_2017.battlefood", appContext.getPackageName());
    }

    @Rule
    public IntentsTestRule<UploadRecipeUi> mActivityRule = new IntentsTestRule<UploadRecipeUi>(UploadRecipeUi.class);

    @Test
    public void testUploadFailure() throws Exception {
        onView(withId(R.id.editTextinstruction)).perform(typeText("Put some Alkohol into the Bowl"), closeSoftKeyboard());
        onView(withId(R.id.btnUpload)).perform(click());
        onView(withId(R.id.btnUpload)).check(matches(withText("Upload")));
    }

   /*@Test
    public void testUploadSuccess() throws Exception {
       final FirebaseAuth mAuth;
       mAuth = FirebaseAuth.getInstance();
       mAuth.getInstance();
       mAuth.signInWithEmailAndPassword("test2@test.com", "test123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {

           }
       });

        sleep(5000);
        onView(withId(R.id.txtNameRecipe)).perform(typeText("Test Recipe1"), closeSoftKeyboard());
        onView(withId(R.id.editTextadult)).perform(typeText("2"), closeSoftKeyboard());
        onView(withId(R.id.editTextchild)).perform(typeText("1"), closeSoftKeyboard());
        onView(withId(R.id.editTexttime)).perform(typeText("12"), closeSoftKeyboard());
        onView(withId(R.id.editTextIngredients)).perform(typeText("Alkohol"), closeSoftKeyboard());
        onView(withId(R.id.imgRecipePic)).
        onView(withId(R.id.editTextinstruction)).perform(typeText("Put some Alkohol into the Bowl"),closeSoftKeyboard());
        onView(withId(R.id.btnUpload)).perform(click());
        sleep(2000);
        intended(hasComponent(StartUI.class.getName()));
    }
*/

}
