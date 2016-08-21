package bani.prabhupada.iskcon.prabhupadamsg;

/**
 * Created by Dinesh on 4/19/2015.
 */

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class SplashActivity extends ActionBarActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        // getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        context = this;
        //getActionBar().setBackgroundDrawable((getResources().getDrawable(R.drawable.actionbar)));


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /* start the activity */
                startActivity(new Intent(context, MainListActivity.class));
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                overridePendingTransition(0,0);
                finish();
            }
        }, 3000);

    }

}
