package at.xp2_2017.battlefood;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Created by Ismael on 05.04.2017.
 */

public class UploadRecipeInstrumentedTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("at.xp2_2017.battlefood", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<UploadRecipeUi> mActivityRule = new ActivityTestRule<>(UploadRecipeUi.class);

    @Test
    public void testSelectPicButton() throws Exception {

        onView(withText("Select Pic")).perform(click());
    }
/*
    @Test
    public void testPerson() throws Exception {

        onView(withId(R.id.editTextadult)).perform(typeText("5"),closeSoftKeyboard());
        onView(withId(R.id.editTextadult)).check(matches(withText("5")));

        onView(withId(R.id.editTextchild)).perform(typeText("1"),closeSoftKeyboard());
        onView(withId(R.id.editTextchild)).check(matches(withText("1")));

        onView(withId(R.id.editTexttime)).perform(typeText("40"),closeSoftKeyboard());
        onView(withId(R.id.editTexttime)).check(matches(withText("40")));


    }*/

    @Test
    public void testInpputRecipe() throws Exception
    {
        onView(withId(R.id.editTextIngredients)).perform(typeText("ekrkre" + "\n" + "abc" + "\n" +
                "abc" + "\n" + "abc" + "\n" + "abc"),closeSoftKeyboard());
        onView(withId(R.id.editTextIngredients)).check(matches(withText("ekrkre" + "\n" + "abc" +
                "\n" + "abc" + "\n" + "abc" + "\n" + "abc")));

        onView(withId(R.id.editTextinstruction)).perform(typeText("ekrkre" + "\n" + "abc" + "\n" +
                "abc" + "\n" + "abc" + "\n" + "abc"),closeSoftKeyboard());
        onView(withId(R.id.editTextinstruction)).check(matches(withText("ekrkre" + "\n" + "abc" +
                "\n" + "abc" + "\n" + "abc" + "\n" + "abc")));

    }

    @Test
    public void testUploadButton() throws Exception {
        onView(withText("Upload")).perform(click());
    }

}
