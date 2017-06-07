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
public class WatchRecipeInstrumentedTest {

    @Rule
    public IntentsTestRule<WatchRecipeUI> WActivityRule = new IntentsTestRule<>(WatchRecipeUI.class);

    @Test
    public void testTextViews() throws Exception {
        onView(withId(R.id.textInstruction)).check(matches(withText("Instruction:")));
        onView(withId(R.id.textIngredients)).check(matches(withText("Ingredients:")));
        onView(withId(R.id.textWorktime)).check(matches(withText("Working time:")));
        onView(withId(R.id.textAdult)).check(matches(withText("Adult:")));
        onView(withId(R.id.textChild)).check(matches(withText("Child:")));
        if(onView(withId(R.id.textName)) == null) throw new AssertionError("Error: No name availabe");
        if(onView(withId(R.id.textInstructions)) == null) throw new AssertionError("Error: No Instructions availabe");
        if(onView(withId(R.id.textIngredients)) == null) throw new AssertionError("Error: No Ingred availabe");
    }
/*
    @Test
    public void testCheckImages() throws Exception {
        WatchRecipeUI WActivity = WActivityRule.getActivity();
        ImageView recipe_img = (ImageView) WActivity.findViewById(R.id.ImageViewRecipe);

        if(recipe_img.getDrawable() == null) throw new AssertionError("Error: Recipe image not loaded");
    }*/
}
