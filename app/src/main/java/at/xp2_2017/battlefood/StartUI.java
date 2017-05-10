package at.xp2_2017.battlefood;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StartUI extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mDatabase;
    public ImageButton foodImageButtonTop;
    public ImageButton foodImageButtonBot;
    public Button menuButton;
    private  DatabaseReference mVotes;
    DatabaseReference mAddVotes;
    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;
    String addToKey;

    public void init() {
        menuButton = (Button) findViewById(R.id.menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_ui = new Intent(StartUI.this, MenuUI.class);
                startActivity(menu_ui);

                //TODO: neue Methode welche user-key und recipe-key in uservotes added
            }
        });

        foodImageButtonTop = (ImageButton) findViewById(R.id.IBfoodtop);
        foodImageButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BattleFoodApplication test = ((BattleFoodApplication)getApplicationContext());

                String user_id = mAuth.getCurrentUser().getUid();
                DatabaseReference current_user_db = mDatabase.child("Users").child(user_id);

                DatabaseReference stringOverwrite = current_user_db.child("RecipeKey");

                stringOverwrite.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        addToKey = dataSnapshot.getValue().toString();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                addToKey += ";" + "RecipeKey2";
                current_user_db.child("RecipeKey").setValue(addToKey);

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

        //Load random recipes
        //mStorageRef = FirebaseStorage.getInstance().getReference();
        //StorageReference pathReference = mStorageRef.child("images/testpicture1.jpg");

        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference recipes = mDatabase.child("Recipes");

        mVotes = FirebaseDatabase.getInstance().getReference().child("Uservotes");

        mAuth = FirebaseAuth.getInstance();

        init();
    }

    @Override
    public void onClick(View v) {

    }


}
