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

                Intent menu_ui = new Intent(StartUI.this, MenuUI.class);
                startActivity(menu_ui);

            }
        });

        foodImageButtonTop = (ImageButton) findViewById(R.id.IBfoodtop);
        foodImageButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start_ui = new Intent(StartUI.this, StartUI.class);
                startActivity(start_ui);

            }
        });

        foodImageButtonBot = (ImageButton) findViewById(R.id.IBfoodbottom);
        foodImageButtonBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start_ui = new Intent(StartUI.this, StartUI.class);
                startActivity(start_ui);

            }
        });


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ui);

        //Random load pictures


        mStorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference pathReference = mStorageRef.child("images/testpicture1.jpg");

        init();
    }

    @Override
    public void onClick(View v) {

    }


}
