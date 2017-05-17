package at.xp2_2017.battlefood;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StartUI extends AppCompatActivity implements View.OnClickListener {
    public DatabaseReference mDatabase;
    public StorageReference mStorage;
    public ImageButton foodImageButtonTop;
    public ImageButton foodImageButtonBot;
    public Button menuButton;
    public FirebaseAuth mAuth;
    String addToKey;
    List<String> unvoted_recipes = new ArrayList<>();
    StorageReference image_reference_1;
    StorageReference image_reference_2;


    public void init() {
        menuButton = (Button)findViewById(R.id.menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu_ui = new Intent(StartUI.this, MenuUI.class);
                startActivity(menu_ui);

            }
        });

        foodImageButtonTop = (ImageButton) findViewById(R.id.IBfoodtop);
        foodImageButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BattleFoodApplication test = ((BattleFoodApplication)getApplicationContext());

                String user_id = mAuth.getCurrentUser().getUid();
                final DatabaseReference current_user_db = mDatabase.child("Users").child(user_id);

                DatabaseReference stringOverwrite = current_user_db.child("RecipeKey");

                stringOverwrite.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        addToKey = dataSnapshot.getValue().toString();
                        addToKey = addToKey.concat(image_reference_1.getName());
                        current_user_db.child("RecipeKey").setValue(addToKey + ";");

                        Intent start_ui = new Intent(StartUI.this, StartUI.class);
                        startActivity(start_ui);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

        foodImageButtonBot = (ImageButton) findViewById(R.id.IBfoodbottom);
        foodImageButtonBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start_ui = new Intent(StartUI.this, StartUI.class);
                startActivity(start_ui);

                String user_id = mAuth.getCurrentUser().getUid();
                final DatabaseReference current_user_db = mDatabase.child("Users").child(user_id);

                DatabaseReference stringOverwrite = current_user_db.child("RecipeKey");

                stringOverwrite.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        addToKey = dataSnapshot.getValue().toString();
                        addToKey = addToKey.concat(image_reference_2.getName());
                        current_user_db.child("RecipeKey").setValue(addToKey + ";");

                        Intent start_ui = new Intent(StartUI.this, StartUI.class);
                        startActivity(start_ui);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ui);

        //Load random recipes
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mStorage = FirebaseStorage.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        mDatabase.child("Users/"+user.getUid()+"/RecipeKey").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final List<String> recipes = Arrays.asList(dataSnapshot.getValue().toString().split(";"));

                mDatabase.child("Recipe").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            if (!recipes.contains(snapshot.getKey())) {
                                unvoted_recipes.add(snapshot.getKey());
                            }
                        }

                        Log.d("öalsdjf", unvoted_recipes.toString());
                        //Shuffle list to random values
                        long seed = System.nanoTime();
                        Collections.shuffle(unvoted_recipes, new Random(seed));

                        Log.d("öalsdjfasdfasdfasdf", unvoted_recipes.toString());

                        image_reference_1 = mStorage.child("images/" + unvoted_recipes.get(0)+".jpg");
                        image_reference_2 = mStorage.child("images/" + unvoted_recipes.get(1)+".jpg");

                        final long TEN_MEGABYTE = 1024 * 1024 * 10;
                        image_reference_1.getBytes(TEN_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                            @Override
                            public void onSuccess(byte[] bytes) {

                                final Bitmap bmp_1 = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

                                image_reference_2.getBytes(TEN_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                    @Override
                                    public void onSuccess(byte[] bytes) {
                                        Bitmap bmp_2 = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

                                        foodImageButtonTop.setImageBitmap(Bitmap.createScaledBitmap(bmp_1, foodImageButtonTop.getWidth(),
                                                foodImageButtonTop.getHeight(), false));

                                        foodImageButtonBot.setImageBitmap(Bitmap.createScaledBitmap(bmp_2, foodImageButtonBot.getWidth(),
                                                foodImageButtonBot.getHeight(), false));

                                    }
                                });


                            }
                        });

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        init();
    }

    @Override
    public void onClick(View v) {

    }


}
