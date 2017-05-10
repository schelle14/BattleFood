package at.xp2_2017.battlefood;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


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
        onView(withId(R.id.HomeBtn)).perform(click());
        intended(hasComponent(StartUI.class.getName()));
    }

    @Test
    public void testClickUploadRecipe() throws Exception {
        onView(withId(R.id.RecipeUpload)).perform(click());
        intended(hasComponent(UploadRecipeUi.class.getName()));
    }
}
