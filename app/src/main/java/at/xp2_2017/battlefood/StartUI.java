package at.xp2_2017.battlefood;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
    public ImageView foodImageButtonTop;
    public ImageView foodImageButtonBot;
    public Button menuButton;
    public FirebaseAuth mAuth;
    String addToKey;
    List<String> unvoted_recipes = new ArrayList<>();
    StorageReference image_reference_1;
    StorageReference image_reference_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ui);

        //Load random recipes
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mStorage = FirebaseStorage.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null)
        {
            mDatabase.child(Constants.FB_USER+"/"+user.getUid()+"/"+Constants.FB_USER_RECIPEKEY).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    final List<String> recipes = Arrays.asList(dataSnapshot.getValue().toString().split(";"));

                    mDatabase.child(Constants.FB_RECIPE).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                if (!recipes.contains(snapshot.getKey()+ Constants.jpg)) {
                                    unvoted_recipes.add(snapshot.getKey());
                                }
                            }

                            if (unvoted_recipes.size() < 2) {
                                Toast.makeText(StartUI.this, Constants.NOT_ENOUGH_RECIPES, Toast.LENGTH_SHORT).show();

                                Intent menu_intent = new Intent(StartUI.this, MenuUI.class);
                                startActivity(menu_intent);
                            }
                            else {
                                //Shuffle list to random values
                                long seed = System.nanoTime();
                                Collections.shuffle(unvoted_recipes, new Random(seed));

                                image_reference_1 = mStorage.child(Constants.FB_IMAGES+"/" + unvoted_recipes.get(0)+Constants.jpg);
                                image_reference_2 = mStorage.child(Constants.FB_IMAGES+"/" + unvoted_recipes.get(1)+Constants.jpg);

                                image_reference_1.getBytes(Constants.MEGABYTE*10).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                    @Override
                                    public void onSuccess(byte[] bytes) {

                                        final Bitmap bmp_1 = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                        image_reference_2.getBytes(Constants.MEGABYTE*10).addOnSuccessListener(new OnSuccessListener<byte[]>() {
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
        }
        else
        {
            Intent login = new Intent(StartUI.this, Login.class);
            startActivity(login);
        }


        menuButton = (Button)findViewById(R.id.menuSUI);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu_ui = new Intent(StartUI.this, MenuUI.class);
                startActivity(menu_ui);
            }
        });

        foodImageButtonTop = (ImageView) findViewById(R.id.IBfoodtop);
        foodImageButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImage(image_reference_1.getName());
            }
        });

        foodImageButtonBot = (ImageView) findViewById(R.id.IBfoodbottom);
        foodImageButtonBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImage(image_reference_2.getName());
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    private void saveImage(final String imageName) {
        final DatabaseReference current_user_db = mDatabase.child(Constants.FB_USER).child(mAuth.getCurrentUser().getUid());
        DatabaseReference stringOverwrite = current_user_db.child(Constants.FB_USER_RECIPEKEY);

        stringOverwrite.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                addToKey = dataSnapshot.getValue().toString();
                addToKey = addToKey.concat(imageName);
                current_user_db.child(Constants.FB_USER_RECIPEKEY).setValue(addToKey + ";");

                Intent start_ui = new Intent(StartUI.this, StartUI.class);
                startActivity(start_ui);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
