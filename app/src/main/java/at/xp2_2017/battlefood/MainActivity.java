package at.xp2_2017.battlefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button buttonReg;
    public Button buttonLogin;

    public void init() {
        buttonLogin = (Button) findViewById(R.id.btnLoginStart);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent login = new Intent(MainActivity.this, Login.class);
                startActivity(login);
            }
        });
        buttonReg = (Button)findViewById(R.id.buttonReg);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent toy = new Intent(MainActivity.this, RegistrationUI.class);
                startActivity(toy);
            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public void onClick(View v) {

    }
}
