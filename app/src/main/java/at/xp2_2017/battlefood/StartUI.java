package at.xp2_2017.battlefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class StartUI extends AppCompatActivity implements View.OnClickListener {
    private StorageReference mStorageRef;

    public ImageButton foodImageButtonTop;
    public ImageButton foodImageButtonBot;
    public Button menuButton;


    public void init() {
        menuButton = (Button)findViewById(R.id.menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu_change = new Intent(StartUI.this, MenuUI.class);
                startActivity(menu_change);

            }
        });

        foodImageButtonTop = (ImageButton) findViewById(R.id.IBfoodtop);
        foodImageButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent foodImage_change = new Intent(StartUI.this, RecipeUI.class);
                startActivity(foodImage_change);

            }
        });

        foodImageButtonBot = (ImageButton) findViewById(R.id.IBfoodbottom);
        foodImageButtonBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent foodImage_change = new Intent(StartUI.this, RecipeUI.class);
                startActivity(foodImage_change);

            }
        });


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ui);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference pathReference = mStorageRef.child("images/stars.jpg");

        init();


    }

    @Override
    public void onClick(View v) {

    }


}
