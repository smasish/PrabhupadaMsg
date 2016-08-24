package bani.prabhupada.iskcon.prabhupadamsg;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AudioActivity extends Activity {
	Button start,pause,stop;

	MediaPlayer mp_e ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.audio);

		start=(Button)findViewById(R.id.button1);
		//pause=(Button)findViewById(R.id.button2);
		stop=(Button)findViewById(R.id.button3);


		mp_e = MediaPlayer.create(getApplicationContext(), R.raw.japa);
	//	final MediaPlayer mp=new MediaPlayer();
//		try{
//			//mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/Music/maine.mp3");
//			mp_e = MediaPlayer.create(getApplicationContext(), R.raw.music);
//			mp_e.prepare();
//		}catch(Exception e){e.printStackTrace();}

		start.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try{
					//mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/Music/maine.mp3");
					mp_e = MediaPlayer.create(getApplicationContext(), R.raw.japa);

					//mp_e.prepare();
					mp_e.start();
				}catch(Exception e){e.printStackTrace();
				}
				Log.d("--", "---start mp3----");

			}
		});
//		pause.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				mp_e.pause();
//			}
//		});
		stop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("", "------stop mp3----");
				mp_e.stop();
				//mp_e.release();


			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		if(mp_e.isPlaying())
			mp_e.stop();
	}
}