package at.xp2_2017.battlefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MenuUI extends AppCompatActivity implements View.OnClickListener {

    public Button buttonHome;
    public Button buttonWatchVotes;
    public Button buttonUploadRecipe;
    public Button buttonLogout;
    public Button buttonRej;

    public void init() {
        buttonHome = (Button)findViewById(R.id.btnMenuHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start_intent = new Intent(MenuUI.this, StartUI.class);
                startActivity(start_intent);
            }
        });

        buttonRej = (Button)findViewById(R.id.buttonRej);
        buttonRej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test_intent = new Intent(MenuUI.this, WatchRecipeUI.class);
                startActivity(test_intent);
            }
        });

        buttonWatchVotes = (Button)findViewById(R.id.WatchVotesBtn);
        buttonWatchVotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent votes_intent = new Intent(MenuUI.this, VotesUI.class);
                startActivity(votes_intent);
            }

        });

        buttonUploadRecipe = (Button)findViewById(R.id.RecipeUpload);
        buttonUploadRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent upload_receipe_intent = new Intent(MenuUI.this, UploadRecipeUi.class);
                startActivity(upload_receipe_intent);
            }

        });

        buttonLogout = (Button)findViewById(R.id.Logout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent logout_change = new Intent(MenuUI.this, Login.class);
                Toast.makeText(MenuUI.this, "¯\\_(ツ)_/¯", Toast.LENGTH_SHORT).show();
                startActivity(logout_change);
            }

        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        init();
    }

    @Override
    public void onClick(View v) {
    }
}



