package bani.prabhupada.iskcon.prabhupadamsg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by ASISH on 8/20/2016.
 */
public class SwipeAdapter extends FragmentStatePagerAdapter {

    int total=28;
    int month_no;
    int select;
    int c=0;

    public SwipeAdapter(FragmentManager fm,int count,int mon,int selected) {
        super(fm);
        this.total = count;
        this.month_no = mon;
        this.select = selected;


    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new PageFragment();
        Bundle bundle = new Bundle();
//        if(i != select)
//            i = select;

//        if(c<i)
//            c = i+select-1;
//        else
//        c =i;
//
        Log.d("=adapter===" + i, "---count>>-");
//        if(i==0 && select>0) {
//            c--;
//        }
        c = i+select;
        if(c>30 && month_no !=2)
            bundle.putInt("count",30);
        else if(c>28 && month_no ==2)
            bundle.putInt("count",28);
        else
           bundle.putInt("count",c);

        bundle.putInt("month",month_no);
       // bundle.putInt("selectedno",select);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return total;
    }
}
