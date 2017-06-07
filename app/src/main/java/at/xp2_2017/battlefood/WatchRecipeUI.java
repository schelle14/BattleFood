package at.xp2_2017.battlefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class WatchRecipeUI extends AppCompatActivity {

    public DatabaseReference mDatabase;
    public StorageReference mStorage;
    public String test;
    public Button menuButton;

    private TextView number_adult;
    private TextView number_child;
    private TextView working_time;
    private TextView ingredients;
    private TextView instructions;
    private TextView recipe_name;
    private ImageView img_recipe;


    public void init() {
        menuButton = (Button)findViewById(R.id.menuWRUI);
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
        String recipe_key;
        try {
            recipe_key = getIntent().getExtras().getString(Constants.KEY_RECIPE);
        }catch (NullPointerException e){
            recipe_key = "-Kku8X3FTLEa1gwUfwTy";

        }

        DatabaseReference recipeRef = mDatabase.child(Constants.FB_RECIPE).child(recipe_key.substring(0, recipe_key.length()-4));

        recipe_name = (TextView) findViewById(R.id.textName);
        working_time = (TextView) findViewById(R.id.textTimeContent);
        number_adult = (TextView) findViewById(R.id.textParentContent);
        number_child = (TextView) findViewById(R.id.textChildContent);
        instructions = (TextView) findViewById(R.id.textInstructions);
        ingredients = (TextView) findViewById(R.id.textIngredients);
        img_recipe = (ImageView) findViewById(R.id.ImageViewRecipe);

        //load image
        Glide.with(this).using(new FirebaseImageLoader()).load(mStorage.child(Constants.FB_IMAGES +"/"+ recipe_key)).into(img_recipe);

        recipeRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recipe_name.setText(dataSnapshot.child(Constants.FB_RECIPE_NAME).getValue().toString());
                working_time.setText(dataSnapshot.child(Constants.FB_RECIPE_TIME).getValue().toString());
                number_adult.setText(dataSnapshot.child(Constants.FB_RECIPE_ADULT).getValue().toString());
                number_child.setText(dataSnapshot.child(Constants.FB_RECIPE_CHILD).getValue().toString());
                ingredients.setText(dataSnapshot.child(Constants.FB_RECIPE_INGREDIENTS).getValue().toString());
                instructions.setText(dataSnapshot.child(Constants.FB_RECIPE_INSTRUCTIONS).getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
