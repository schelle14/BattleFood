package at.xp2_2017.battlefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
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

public class WatchRecipeUI extends AppCompatActivity {

    public DatabaseReference mDatabase;
    public StorageReference mStorage;
    public ImageView RecipeImg;
    public FirebaseAuth mAuth;
    public TextView ingred;
    public String test;
    public Button menuButton;

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
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        final TextView textScrollview = (TextView) findViewById(R.id.textScrollIngred);
        final TextView textScrollview2 = (TextView) findViewById(R.id.textScrollIncstruct);
        textScrollview.setMovementMethod(new ScrollingMovementMethod());
        textScrollview2.setMovementMethod(new ScrollingMovementMethod());

        ingred = (TextView) findViewById(R.id.textParentContent);




        mDatabase.child(Constants.FB_USER+"/"+user.getUid()+"/"+Constants.FB_USER_RECIPEKEY).addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
/*
             //  final List<String> recipes = Arrays.asList(dataSnapshot.getValue().toString().split(";"));
              // test = recipes.get(0);
             //  test = dataSnapshot.getValue().toString().concat(".jpg");
             //  ingred.setText(test);
                final List<String> recipes = new ArrayList<String>(Arrays.asList(";test1.jpg;test2.jpg;test3.jpg".split(";")));
               for(int x = 0;x < recipes.size(); x++ )
               {
                   String my_string = recipes.get(x);
                   my_string = my_string.substring(0,my_string.indexOf("."));
                   recipes.set(x,my_string);
               }
                //test = dataSnapshot.getValue().toString();
                test = recipes.get(1);
                ingred.setText(test);

                if(recipes.size() != 0)
                {
                   mDatabase.child(Constants.FB_RECIPE).child("-Kku8vcFB8aY2i6dPP8r").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            test = dataSnapshot.getValue().toString();
                            textScrollview.setText(test);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
                else
                    Toast.makeText(WatchRecipeUI.this, Constants.SOMETHING_WENT_WRONG, Toast.LENGTH_LONG).show();
                    */
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

}
