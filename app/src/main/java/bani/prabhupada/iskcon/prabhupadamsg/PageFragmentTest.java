package bani.prabhupada.iskcon.prabhupadamsg;


import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragmentTest extends Fragment {

TextView textView;
    ImageView imageView;
    Bitmap bitmap=null;
    TypedArray imgs;
    public PageFragmentTest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page_layout,container,false);
        textView = (TextView)view.findViewById(R.id.textView);

        imageView = (ImageView)view.findViewById(R.id.img);


        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        int i = bundle.getInt("count");
       // int select = bundle.getInt("selectedno");
        int mon =  bundle.getInt("month", 1);
        // textView.setText("this is the "+message+" swipe view page");
        Log.d("===month name>>=" + mon, "--i--"+i);
      //  Log.d("====" + select, "---select>>-");
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
        if(i>0)
            i=i-1;
        bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));

        Log.d("=i===" + i, "---set image index>>-");
        imageView.setImageBitmap(bitmap);

       ShareImage im =  new ShareImage(bitmap, "Image#" + i);
      im.setImage(bitmap);
        bitmap = null;

       // imageView.setImageBitmap(bitmap);
        return view;
    }

}
