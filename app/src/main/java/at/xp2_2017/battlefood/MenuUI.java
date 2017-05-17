package at.xp2_2017.battlefood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuUI extends AppCompatActivity implements View.OnClickListener {

    public Button buttonHome;
    public Button buttonWatchVotes;
    public Button buttonUploadRecipe;
    public Button buttonLogout;

    public void init() {
        buttonHome = (Button)findViewById(R.id.HomeBtn);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start_change = new Intent(MenuUI.this, StartUI.class);
                startActivity(start_change);

            }
        });

        buttonWatchVotes = (Button)findViewById(R.id.WatchVotesBtn);
        buttonWatchVotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent watch_votes_change = new Intent(MenuUI.this, VotesUI.class);
                startActivity(watch_votes_change);
            }

        });

        buttonUploadRecipe = (Button)findViewById(R.id.RecipeUpload);
        buttonUploadRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent upload_change = new Intent(MenuUI.this, UploadRecipeUi.class);
                startActivity(upload_change);
            }

        });
        /* TODO
        buttonLogout = (Button)findViewById(R.id.Logout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent logout_change = new Intent(MenuUI.this, Login.class);
                startActivity(logout_change);
            }

        });
        */
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



