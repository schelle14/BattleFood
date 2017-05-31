package at.xp2_2017.battlefood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
import java.util.List;
import java.util.jar.Attributes;

public class WatchRecipeUI extends AppCompatActivity {

    public DatabaseReference mDatabase;
    public StorageReference mStorage;
    public ImageView RecipeImg;
    public FirebaseAuth mAuth;
    public TextView ingred;
    public String test;
    public Button menuButton;

    private TextView number_adult;
    private TextView number_child;
    private TextView working_time;
    private TextView ingredients;
    private TextView instructions;
    private Button btnUpload;
    private Button btnSelectPic;
    private TextView recipe_name;
    private ImageView img_recipe;
    private TextView txtPictureSelected;
    private String picturename;
    private Uri uri;


    public void init() {
        menuButton = (Button)findViewById(R.id.menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menue_intent = new Intent(WatchRecipeUI.this, MenuUI.class);
                startActivity(menue_intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_recipe_ui);

        init();

        //Load FB References
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mStorage = FirebaseStorage.getInstance().getReference();
        Log.d("onCreate: ", getIntent().getExtras().getString(Constants.KEY_RECIPE));
        String recipe_key = getIntent().getExtras().getString(Constants.KEY_RECIPE);
        DatabaseReference recipeRef = mDatabase.child(Constants.FB_RECIPE).child(recipe_key.substring(0, recipe_key.length()-4));

        recipe_name = (TextView) findViewById(R.id.textName);


        recipeRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recipe_name.setText(dataSnapshot.child(Constants.FB_RECIPE_NAME).getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
