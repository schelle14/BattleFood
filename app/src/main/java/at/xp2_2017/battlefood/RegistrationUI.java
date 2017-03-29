package at.xp2_2017.battlefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class RegistrationUI extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    //Intent StartUI_Activ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_ui);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("ABC", "ABC - test test test");
       // Button clickedButton = (Button) v;
        Intent StartUI_Active = new Intent(RegistrationUI.this,StartUI.class);
        startActivity(StartUI_Active);
    }
}
