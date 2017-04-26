package at.xp2_2017.battlefood;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText etEmail;
    private EditText etPassword;
    public Button btnLogin;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private TextView txtcheckLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText) findViewById(R.id.etEmailLogin);
        txtcheckLogin = (TextView) findViewById(R.id.txtcheckLogin);
        etPassword = (EditText) findViewById(R.id.etPasswordLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {
                    //Switch to Mainactivity page
                    txtcheckLogin.setText("Sucess");
                    //CHANGE TO REGISTRATION TO START
                   startActivity(new Intent(Login.this, MainActivity.class));

                }
            }
        };
    }

    private void startSignIn(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        //checks if login is sucessfull
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            txtcheckLogin.setText("Fields are empty");
        }
        else
        {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        txtcheckLogin.setText("Sign in failed");
                    }
                }
            });
        }
    }

    @Override
        protected void onStart() {
            super.onStart();
            //Adding auth to mAuthlistener
            FirebaseAuth.getInstance().signOut();
            mAuth.addAuthStateListener(mAuthListener);
        }

    @Override
    public void onClick(View v) {
        startSignIn();
    }
}
