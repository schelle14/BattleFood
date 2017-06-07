package at.xp2_2017.battlefood;

import android.app.Application;

import java.util.List;

public class BattleFoodApplication extends Application {
    //Use for global variables
    private String user_key;

    public String getUserKey() {
            return user_key;
    }
    public void setUserKey(String str) {
            user_key = str;
    }
}
