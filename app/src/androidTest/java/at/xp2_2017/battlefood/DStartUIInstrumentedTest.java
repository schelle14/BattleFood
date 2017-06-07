package at.xp2_2017.battlefood;

import android.support.annotation.NonNull;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

/*

@RunWith(AndroidJUnit4.class)
public class DStartUIInstrumentedTest {
    @Rule
    public IntentsTestRule<StartUI> SUIActivityRule = new IntentsTestRule<>(StartUI.class);


    @Test
    public void testClickImageBot() throws Exception {
        final FirebaseAuth mauth;
        mauth = FirebaseAuth.getInstance();
        if(mauth.getCurrentUser() == null) {
            mauth.signInWithEmailAndPassword("test3@test.com", "test123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                    }
                }
            });
        sleep(5000);
        onView(withId(R.id.IBfoodbottom)).perform(click());
        intended(hasComponent(StartUI.class.getName()));
            sleep(5000);
    }}

    @Test
    public void testClickImageTop() throws Exception {

        final FirebaseAuth mauth;
        mauth = FirebaseAuth.getInstance();
        if(mauth.getCurrentUser() == null) {
            mauth.signInWithEmailAndPassword("test3@test.com", "test123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                    }
                }
            });
            sleep(5000);
            onView(withId(R.id.IBfoodtop)).perform(click());
            intended(hasComponent(StartUI.class.getName()));
            sleep(5000);
        }}

    @Test
    public void testClickMenu() throws Exception {
        final FirebaseAuth mauth;
        mauth = FirebaseAuth.getInstance();
        if(mauth.getCurrentUser() == null) {
            mauth.signInWithEmailAndPassword("test3@test.com", "test123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                    }
                }
            });
            sleep(5000);
        onView(withId(R.id.menuSUI)).perform(click());
        intended(hasComponent(MenuUI.class.getName()));
            sleep(5000);
    }}


    @Test
    public void testCheckImages() throws Exception {

        StartUI mActivity = SUIActivityRule.getActivity();
        ImageButton img_top = (ImageButton) mActivity.findViewById(R.id.IBfoodtop);
        ImageButton img_bot = (ImageButton) mActivity.findViewById(R.id.IBfoodbottom);

        if (img_top.getDrawable() == null) throw new AssertionError("IBfoodtop: no image loaded");
        if (img_bot.getDrawable() == null) throw new AssertionError("IBfoodbot: no image loaded");

    }
}*/
