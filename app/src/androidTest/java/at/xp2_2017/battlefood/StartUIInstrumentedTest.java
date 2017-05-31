package at.xp2_2017.battlefood;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageButton;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static java.lang.Thread.sleep;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
/*
@RunWith(AndroidJUnit4.class)
public class StartUIInstrumentedTest {
    @Rule
    public IntentsTestRule<StartUI> SUIActivityRule = new IntentsTestRule<>(StartUI.class);

/*
    @Test
    public void testClickImageTop() throws Exception {
      //  Login m = new Login();

       onView(withId(R.id.etEmailLogin)).perform(typeText("su@si.at"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.etPasswordLogin)).perform(typeText("qwert123"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());


       // intended(hasComponent(StartUI.class.getName()));
        //m.findViewById(R.id.etPasswordLogin);

       // m.findViewById(R.id.IBfoodtop).performClick();
        //onView(withId(R.id.IBfoodtop)).perform(click());
       // intended(hasComponent(StartUI.class.getName()));
    }

    @Test
    public void testClickImageBot() throws Exception {
        onView(withId(R.id.IBfoodbottom)).perform(click());
        intended(hasComponent(StartUI.class.getName()));
    }

    @Test
    public void testClickMenu() throws Exception {
        onView(withId(R.id.menu)).perform(click());
        intended(hasComponent(MenuUI.class.getName()));
    }


    @Test
    public void testCheckImages() throws Exception {

        StartUI mActivity = SUIActivityRule.getActivity();
        ImageButton img_top = (ImageButton) mActivity.findViewById(R.id.IBfoodtop);
        ImageButton img_bot = (ImageButton) mActivity.findViewById(R.id.IBfoodbottom);

        if (img_top.getDrawable() == null) throw new AssertionError("IBfoodtop: no image loaded");
        if (img_bot.getDrawable() == null) throw new AssertionError("IBfoodbot: no image loaded");

    }
}*/
