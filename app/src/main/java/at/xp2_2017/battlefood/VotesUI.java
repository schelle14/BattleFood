package at.xp2_2017.battlefood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;


public class VotesUI extends AppCompatActivity{

    public Button menuButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votes_ui);

        menuButton = (Button) findViewById(R.id.menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu_change = new Intent(VotesUI.this, MenuUI.class);
                startActivity(menu_change);
            }
        });


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

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

    /*@Override

    public void onClick(View v) {

    }*/
}