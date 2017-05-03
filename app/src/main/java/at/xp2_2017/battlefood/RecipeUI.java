package at.xp2_2017.battlefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecipeUI extends AppCompatActivity implements View.OnClickListener{

    public Button menuButton;

    public void init() {
        menuButton = (Button) findViewById(R.id.menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu_change = new Intent(RecipeUI.this, MenuUI.class);
                startActivity(menu_change);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        init();

    }
    @Override
    public void onClick(View v) {

    }
}
