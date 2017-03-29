package at.xp2_2017.battlefood;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class StartUI extends AppCompatActivity implements View.OnClickListener {
    private ImageButton IBfoodtop;
    private ImageButton IBfoodbottom;

    ImageButton androidImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ui);

        androidImageButton = (ImageButton) findViewById(R.id.IBfoodtop);
        androidImageButton.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void onClick(View v) {

        Intent MainActivity = new Intent(StartUI.this,MainActivity.class);
        startActivity(MainActivity);

            /*v.setBackgroundResource(R.drawable.food_1);
            androidImageButton.setBackgroundResource(R.drawable.food_1);*/

    }
        /*Bitmap bmp = BitmapFactory.decodeFile("food_1");
        ImageButton button1 = (ImageButton)findViewById(R.id.IBfoodtop);
        button1.setImageBitmap(bmp);*/

}
