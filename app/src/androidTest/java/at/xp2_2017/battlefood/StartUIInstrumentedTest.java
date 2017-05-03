package at.xp2_2017.battlefood;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class StartUIInstrumentedTest {
    @Rule
    public ActivityTestRule<StartUI> SUIActivityRule = new ActivityTestRule<>(StartUI.class);

    @Test
    public void testClickImage() throws Exception {
        //onView(withId(R.id.IBfoodtop)).perform(click());
        //onView(withId(R.id.IBfoodbottom)).perform(click());
    }
}
