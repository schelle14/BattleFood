package at.xp2_2017.battlefood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class VotesUI extends AppCompatActivity{


    public Button buttonReg;
    public Button buttonLog;
    public Button buttonUpload;
    public TextView txtMainActivity;
    public Button watchBut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votes__ui);

        BattleAdapter mampe;

    }

    /*@Override
    public void onClick(View v) {

    }*/
}