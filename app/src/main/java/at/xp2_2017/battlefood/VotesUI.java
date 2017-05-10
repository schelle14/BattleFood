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


   GridView bgrid;
    int [] images ={R.drawable.food_1,R.drawable.food_2,R.drawable.food_3,R.drawable.food_4,
            R.drawable.food_5,R.drawable.food_6,R.drawable.food_7};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votes_ui);

        bgrid =(GridView) findViewById(R.id.gridView2);

        //Adapter
        BattleAdapter ada = new BattleAdapter(this,images);
        bgrid.setAdapter(ada);

        //events
        bgrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Image: "+ position,Toast.LENGTH_SHORT).show();

//                Intent watch_recipe = new Intent(VotesUI.this, RecipeUI.class);
//                startActivity(watch_recipe);


            }
        });
        menuButton = (Button)findViewById(R.id.menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {

                Intent menu_change = new Intent(VotesUI.this, MenuUI.class);
                startActivity(menu_change);

            }
        });

    }

    /*@Override

    public void onClick(View v) {

    }*/
}