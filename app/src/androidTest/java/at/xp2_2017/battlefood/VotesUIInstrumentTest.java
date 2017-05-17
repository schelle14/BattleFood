package at.xp2_2017.battlefood;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class VotesUIInstrumentTest {

    @Rule
    public IntentsTestRule<VotesUI> SUIActivityRule = new IntentsTestRule<>(VotesUI.class);

    @Test
    public void testClickMenu() throws Exception {
        onView(withId(R.id.menu)).perform(click());
        intended(hasComponent(MenuUI.class.getName()));
    }

    @Test
    public void testClickFood() throws Exception {
        onView(withId(R.id.gridview)).perform(click());
        intended(hasComponent(RecipeUI.class.getName()));
    }

    @Test
    public void testText() throws Exception {
        onView(withId(R.id.textView)).check(matches(withText("Your Votes")));

    }


}