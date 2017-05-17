package at.xp2_2017.battlefood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Console;

public class RegistrationUI extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegister;
    //Intent StartUI_Activ;
    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPasswordAgain;
    private Button btnReg;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;
    private DatabaseReference mDatabase;
    private TextView txtViewRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_ui);

        etUsername = (EditText) findViewById(R.id.editTextUserName);
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etPassword = (EditText) findViewById(R.id.editTextPassword);
        etPasswordAgain = (EditText) findViewById(R.id.editTextRetypePassword);
        mAuth = FirebaseAuth.getInstance();
        btnRegister = (Button) findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(this);
        mProgress = new ProgressDialog(this);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
    }

    @Override
    public void onClick(View v) {
        startRegister();
    }

    private void startRegister() {
        final String username = etUsername.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        final String passwordagain = etPasswordAgain.getText().toString().trim();

        if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password))
        {
            mProgress.setMessage("Signing up..");
            mProgress.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        //gets de unique Id of current user
                        String user_id = mAuth.getCurrentUser().getUid();
                        DatabaseReference current_user_db = mDatabase.child(user_id);
                        current_user_db.child("username").setValue(username);
                        current_user_db.child("email").setValue(email);
                        current_user_db.child("RecipeKey").setValue(";");
                        mProgress.dismiss();

                        Intent main = new Intent(RegistrationUI.this, MainActivity.class);
                        startActivity(main);
                    }
                    else
                    {
                        mProgress.dismiss();
                        Toast.makeText(RegistrationUI.this, "Something went wrong", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
