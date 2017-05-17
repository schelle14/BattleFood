package at.xp2_2017.battlefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.app.Activity;
import android.widget.ImageView;

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
        // Get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.meal_image);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);

    }
    @Override
    public void onClick(View v) {

    }
}
