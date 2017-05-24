package at.xp2_2017.battlefood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class WatchRecipeUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_recipe_ui);

        TextView textScrollview = (TextView)findViewById(R.id.textScrollIngred);
        TextView textScrollview2 = (TextView)findViewById(R.id.textScrollIncstruct);
        textScrollview.setMovementMethod(new ScrollingMovementMethod());
        textScrollview2.setMovementMethod(new ScrollingMovementMethod());
    }
}
