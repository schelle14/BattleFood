package at.xp2_2017.battlefood;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StartUI extends AppCompatActivity implements View.OnClickListener {
    private ImageButton IBfoodtop;
    private ImageButton IBfoodbottom;

    ImageButton foodImageButton;
    ImageButton foodImageButton2;

    State start_ui_state;
    Intent MainActivity;
    Intent SecondUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ui);

        foodImageButton = (ImageButton) findViewById(R.id.IBfoodtop);
        foodImageButton.setOnClickListener(this);

        foodImageButton2 = (ImageButton) findViewById(R.id.IBfoodbottom);
        foodImageButton2.setOnClickListener(this);


    }
    public enum State{
        DISHONE, DISHTWO, MENUE
    }
    @Override
    public void onClick(View v) {


       ImageButton clickedButton = (ImageButton) v;

        switch(clickedButton.getId())
        {
            case R.id.IBfoodtop:
                start_ui_state = State.DISHONE;
                MainActivity = new Intent(StartUI.this,MainActivity.class);
                startActivity(MainActivity);
                break;
            case R.id.IBfoodbottom:
                start_ui_state = State.DISHTWO;
                SecondUI = new Intent(StartUI.this,SecondUI.class);
                startActivity(SecondUI);
                break;
            default:
                break;

        }
    }


}
