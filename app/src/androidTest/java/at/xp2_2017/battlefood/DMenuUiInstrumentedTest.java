package at.xp2_2017.battlefood;
import android.support.annotation.NonNull;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

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
import static java.lang.Thread.sleep;



@RunWith(AndroidJUnit4.class)
public class DMenuUiInstrumentedTest {

    @Rule
    public IntentsTestRule<MenuUI> SUIActivityRule = new IntentsTestRule<>(MenuUI.class);
/*
    @Test
    public void testVotesButton() throws Exception {
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
        onView(withId(R.id.btnWatchVotes)).perform(click());
        sleep(5000);
        intended(hasComponent(VotesUI.class.getName()));
    }}

    @Test
    public void testHomeButton() throws Exception {
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
        onView(withId(R.id.btnMenuHome)).perform(click());
        sleep(5000);
        intended(hasComponent(StartUI.class.getName()));
    }}
*/
    @Test
    public void testRecipeUpload() throws Exception {
        sleep(5000);
        onView(withId(R.id.btnRecipeUpload)).perform(click());
        sleep(5000);
        intended(hasComponent(UploadRecipeUi.class.getName()));
    }
/*
    @Test
    public void testLogout() throws Exception {
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
        onView(withId(R.id.btnLogout)).perform(click());
        sleep(5000);
        intended(hasComponent(Login.class.getName()));
    }*/
}


