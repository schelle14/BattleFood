package at.xp2_2017.battlefood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;


public class VotesUI extends AppCompatActivity{

    public Button watchBut;


   GridView bgrid;
    int [] images ={R.drawable.food_1,R.drawable.food_2,R.drawable.food_1,R.drawable.food_2,
            R.drawable.food_1,R.drawable.food_2,R.drawable.food_1,R.drawable.food_2,
            R.drawable.food_1,R.drawable.food_2,R.drawable.food_1,R.drawable.food_2};


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

            }
        });

    }

    /*@Override

    public void onClick(View v) {

    }*/
}