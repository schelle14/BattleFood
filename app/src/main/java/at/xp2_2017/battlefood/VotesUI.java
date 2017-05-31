package at.xp2_2017.battlefood;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class VotesUI extends AppCompatActivity{

    public Button menuButton;
    public DatabaseReference mDatabase;
    List<String> mRecipes = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votes_ui);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        menuButton = (Button) findViewById(R.id.menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu_change = new Intent(VotesUI.this, MenuUI.class);
                startActivity(menu_change);
            }
        });

        mDatabase.child(Constants.FB_USER+"/"+ FirebaseAuth.getInstance().getCurrentUser().getUid()+"/"+Constants.FB_USER_RECIPEKEY).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> recipes = Arrays.asList(dataSnapshot.getValue().toString().split(";"));
                GridView gridview = (GridView) findViewById(R.id.gridview);
                gridview.setAdapter(new ImageAdapter(getApplicationContext(), recipes));

                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        // Toast.makeText(VotesUI.this, "" + position, Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), RecipeUI.class);
                        // Pass image index
                        i.putExtra("id", position);
                        startActivity(i);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    /*@Override

    public void onClick(View v) {

    }*/
}