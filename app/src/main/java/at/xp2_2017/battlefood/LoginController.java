package at.xp2_2017.battlefood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class LoginController extends AppCompatActivity {


    EditText UsernameEt,PasswordEt;
    TextView StatusTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginview);
        UsernameEt = (EditText)findViewById(R.id.etUsername);
        PasswordEt = (EditText)findViewById(R.id.etPassword);
        StatusTxt = (TextView) findViewById(R.id.txtStatus);

        //TODO: instance backgroundworker here singelton
    }

    public void OnLogin(View view)
    {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";

        LoginModel loginModel = new LoginModel(this);
        loginModel.execute(username, password);

        String status = "";
        try {
            status = loginModel.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        StatusTxt.setText(status);
    }
    public static int shit(int x)
    {
        int z = x + 5;
        return z;
    }
}
