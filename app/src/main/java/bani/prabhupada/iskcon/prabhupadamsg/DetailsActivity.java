package bani.prabhupada.iskcon.prabhupadamsg;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;


public class DetailsActivity extends FragmentActivity {


    Bitmap bitmap=null;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_activity);

        String title = getIntent().getStringExtra("title");
      //  Bitmap bitmap = getIntent().getParcelableExtra("image");

        int i = getIntent().getIntExtra("month",1);
        int total = getIntent().getIntExtra("total",28);
        int select = getIntent().getIntExtra("selected",1);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        Log.d("=i===" + i, "---month name>>-");
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager(),total,i,select);
        viewPager.setCurrentItem(select);
        viewPager.setAdapter(swipeAdapter);





//        TextView titleTextView = (TextView) findViewById(R.id.title);
//        titleTextView.setText(title);

//        ImageView imageView = (ImageView) findViewById(R.id.image);
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_jan);
        bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
//        imageView.setImageBitmap(bitmap);
    }

    public void share(View v){
        //Bitmap b =BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);

        Intent share = new Intent(Intent.ACTION_SEND);

        share.setType("image/jpeg");

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "title", null);
        Uri imageUri = Uri.parse(path);
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        startActivity(Intent.createChooser(share, "Select"));
    }
}
