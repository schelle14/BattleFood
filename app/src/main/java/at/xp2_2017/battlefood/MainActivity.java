package at.xp2_2017.battlefood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button buttonReg;
    public Button buttonLog;
    public TextView txtMainActivity;
    public Button watchBut;

    public void init() {
        buttonReg = (Button)findViewById(R.id.buttonReg);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent register_change = new Intent(MainActivity.this, RegistrationUI.class);
                startActivity(register_change);

            }
        });
        buttonLog = (Button)findViewById(R.id.buttonLog);
        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent log_change = new Intent(MainActivity.this, Login.class);
                startActivity(log_change);
            }

        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMainActivity = (TextView) findViewById(R.id.txtMainA);

        init();
    }

    @Override
    public void onClick(View v) {

    }
}
