package at.xp2_2017.battlefood;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Daniel on 03.05.2017.
 */


public class BattleAdapter extends BaseAdapter {

    private Context contextx;
    private int [] images_list;

    public BattleAdapter(Context c, int[] images){

        this.contextx = c;
        this.images_list = images;
    }

    @Override
    public int getCount()
    {
        return images_list.length;
    }

    @Override
    public Object getItem(int position)
    {
        return images_list[position];
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageButton img = new ImageButton(contextx);

        //SET IMAGE
        img.setImageResource(images_list[position]);
        img.setScaleType(ImageButton.ScaleType.CENTER_CROP);

        img.setLayoutParams(new GridView.LayoutParams(350,350));

        return img;
    }
}

