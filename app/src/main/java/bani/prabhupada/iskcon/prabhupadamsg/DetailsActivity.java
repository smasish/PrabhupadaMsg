package bani.prabhupada.iskcon.prabhupadamsg;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
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
    private int mLastVisitedPageIndex = 0;
   int mon,total,select;
    TypedArray imgs;
    int recent;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_activity);

        String title = getIntent().getStringExtra("title");
      //  Bitmap bitmap = getIntent().getParcelableExtra("image");

        mon = getIntent().getIntExtra("month",1);
         total = getIntent().getIntExtra("total",28);
         select = getIntent().getIntExtra("selected",1);
        recent = select+1;


        Log.d("=last update===" , "-->>>>-"+recent);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        Log.d("=i===" + mon, "---month name>>-");
        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager(),total,mon,recent);
        viewPager.setCurrentItem(recent);
        viewPager.setAdapter(swipeAdapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private static final float thresholdOffset = 0.5f;
            private static final int thresholdOffsetPixels = 1;
            private boolean scrollStarted, checkDirection;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("=scrolled===" + position, "--->>>-");
                if (checkDirection) {
                    if (thresholdOffset > positionOffset && positionOffsetPixels > thresholdOffsetPixels) {
                        Log.i("---===>>", "going left");
                        Fragment fragment = new PageFragmentTest();
                        Bundle bundle = new Bundle();

                        flag = true;
//
                        Log.d("=adapter===" + select, "---mon>>-"+mon);
//
//
                        bundle.putInt("month",mon);
                         bundle.putInt("selectedno",select);

                        if(recent<28 && mon ==2)
                            recent++;
                        else if(recent<30 && (mon ==4 ||mon ==6||mon ==9||mon ==11))
                            recent++;
                        else if(recent<31 )
                                recent++;
                        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager(),total,mon,recent);
                        viewPager.setAdapter(swipeAdapter);
                        Log.d("=recent===" + recent, "---mon>>-"+mon);
                        bundle.putInt("count",recent);
//
                        fragment.setArguments(bundle);


                    } else {
                        Log.i("----===>>>", "going right");
                        Fragment fragment = new PageFragmentTest();
                        Bundle bundle = new Bundle();

                          flag = false;
                        Log.d("=adapter===" + select, "---mon>>-"+mon);
//
//
                        bundle.putInt("month",mon);
                        bundle.putInt("selectedno",select);
                        if(recent>1)
                            recent--;
                        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager(),total,mon,recent);
                        viewPager.setAdapter(swipeAdapter);
                        Log.d("=recent===" + recent, "---mon>>-"+mon);
                        bundle.putInt("count",recent);
//
                        fragment.setArguments(bundle);
                    }
                }
                checkDirection = false;
            }

            @Override
            public void onPageSelected(int position) {

                boolean isMovingForward = mLastVisitedPageIndex < position?true:false;
                //Use isMovingForward variable anywhere now
                mLastVisitedPageIndex = position;
                Log.d("=selected===" + position, "-->>>>-");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

                if (!scrollStarted && state == ViewPager.SCROLL_STATE_DRAGGING) {
                    scrollStarted = true;
                    checkDirection = true;
                } else {
                    scrollStarted = false;
                }
                Log.d("=state===" + state, "-->>>>-"+checkDirection);
            }
        });


//        TextView titleTextView = (TextView) findViewById(R.id.title);
//        titleTextView.setText(title);

//        ImageView imageView = (ImageView) findViewById(R.id.image);
      //  TypedArray imgs = getResources().obtainTypedArray(R.array.image_jan);
     //   bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(select, -1));
//        imageView.setImageBitmap(bitmap);
    }

    public void share(View v){
        //Bitmap b =BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);

        Intent share = new Intent(Intent.ACTION_SEND);

        share.setType("image/jpeg");

//        if(ShareImage.getImage() !=null)
//         bitmap = ShareImage.getImage();
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
        // imgs = getResources().obtainTypedArray(R.array.image_jan);
        Log.d("=recent share==="+flag , "-->>>>-"+recent);
        int get = 0;
        if(recent>0 &&!flag)
            get = recent-1;
        else
        get = recent-1;
        bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(get, -1));

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "title", null);
        Uri imageUri = Uri.parse(path);
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        startActivity(Intent.createChooser(share, "Select"));
    }
}
