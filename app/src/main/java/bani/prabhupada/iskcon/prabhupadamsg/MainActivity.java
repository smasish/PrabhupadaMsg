package bani.prabhupada.iskcon.prabhupadamsg;



import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private GridView gridView;
    private GridViewAdapter gridAdapter;
    TypedArray imgs;
    int mon=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mon = getIntent().getIntExtra("pos",1);

        gridView = (GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                intent.putExtra("title", item.getTitle());
//                intent.putExtra("image", item.getImage());
//
              //  int m = position+1;
                intent.putExtra("month",mon);
                intent.putExtra("total",imgs.length());
                intent.putExtra("selected", position);
               // Log.d("========", ".....>>" + mon);

                //Start details activity
                startActivity(intent);
            }
        });
    }

    /**
     * Prepare some dummy data for gridview
     */
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        Log.d("====mainactivity====", "...month position..>>" + mon);
        if(mon == 1)
          imgs = getResources().obtainTypedArray(R.array.image_jan);
        else if(mon == 2)
            imgs = getResources().obtainTypedArray(R.array.image_feb);
        else if(mon == 3)
            imgs = getResources().obtainTypedArray(R.array.image_mar);
        else if(mon == 4)
            imgs = getResources().obtainTypedArray(R.array.image_apr);
        else if(mon == 5)
            imgs = getResources().obtainTypedArray(R.array.image_may);
        else if(mon == 6)
            imgs = getResources().obtainTypedArray(R.array.image_jun);
        else if(mon == 7)
            imgs = getResources().obtainTypedArray(R.array.image_jul);
        else if(mon == 8)
            imgs = getResources().obtainTypedArray(R.array.image_aug);
        else if(mon == 9)
            imgs = getResources().obtainTypedArray(R.array.image_sep);
        else if(mon == 10)
            imgs = getResources().obtainTypedArray(R.array.image_oct);
        else if(mon == 11)
            imgs = getResources().obtainTypedArray(R.array.image_nov);
        else if(mon == 12)
            imgs = getResources().obtainTypedArray(R.array.image_dec);



        Bitmap bitmap = null;
        for (int i = 1; i < imgs.length(); i++) {
            Log.d("===="+i, "---image no---");
            bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
            bitmap = null;
        }
        return imageItems;
    }
}