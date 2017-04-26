package at.xp2_2017.battlefood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class StartUIInstrumentedTest {
    @Rule
    public IntentsTestRule<StartUI> SUIActivityRule = new IntentsTestRule<>(StartUI.class);

    @Test
    public void testClickImageTop() throws Exception {
        onView(withId(R.id.IBfoodtop)).perform(click());
        intended(hasComponent(Recipe.class.getName()));
    }

    @Test
    public void testClickImageBot() throws Exception {
        onView(withId(R.id.IBfoodbottom)).perform(click());
        intended(hasComponent(Recipe.class.getName()));
    }
}
