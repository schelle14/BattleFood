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
    private ImageButton IBfoodtop;
    private ImageButton IBfoodbottom;
    private StorageReference mStorageRef;

    ImageButton foodImageButton;
    ImageButton foodImageButton2;
    Button menuButton;

    State start_ui_state;
    Intent MainActivity;
   // Intent SecondUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ui);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        StorageReference pathReference = mStorageRef.child("images/stars.jpg");

        foodImageButton = (ImageButton) findViewById(R.id.IBfoodtop);
        foodImageButton.setOnClickListener(this);

        foodImageButton2 = (ImageButton) findViewById(R.id.IBfoodbottom);
        foodImageButton2.setOnClickListener(this);

        menuButton = (Button)findViewById(R.id.menu);
        menuButton.setOnClickListener(this);

    }
    public enum State{
        DISHONE, DISHTWO, MENU
    }
    @Override
    public void onClick(View v) {


       ImageButton clickedButton = (ImageButton) v;

        switch(clickedButton.getId())
        {
            case R.id.IBfoodtop:
                start_ui_state = State.DISHONE;
                MainActivity = new Intent(StartUI.this,Recipe.class);
                startActivity(MainActivity);
                break;
            case R.id.IBfoodbottom:
                start_ui_state = State.DISHTWO;
                MainActivity = new Intent(StartUI.this,Recipe.class);
                startActivity(MainActivity);
                break;
            case R.id.menu:
                start_ui_state = State.MENU;
                MainActivity = new Intent(StartUI.this, MenuUI.class);
                startActivity(MainActivity);
                break;
            default:
                break;

        }
    }


}
