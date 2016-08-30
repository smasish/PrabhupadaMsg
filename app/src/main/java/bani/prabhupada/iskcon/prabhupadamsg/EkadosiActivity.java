package bani.prabhupada.iskcon.prabhupadamsg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class EkadosiActivity extends Activity {

	private ImageView ab;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ekadosi);

		ab = (ImageView)findViewById(R.id.about);

	ab.setBackgroundResource(R.drawable.ekadasi);
		//ab.setText("Phone\n +8801911612673\n\nEmail: asish.sust@gmail.com\n\nWebsite: www.sylhetiskcon.org");

		Log.d("", "");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/jan"+i+"</item>");


	}
}
