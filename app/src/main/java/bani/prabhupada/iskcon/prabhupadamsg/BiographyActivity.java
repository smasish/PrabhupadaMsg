package bani.prabhupada.iskcon.prabhupadamsg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BiographyActivity extends Activity {

	private TextView ab;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.biography);

		ab = (TextView)findViewById(R.id.about);

		ab.setText("ISKCON Youth Forum Sylhet \n" +
				"Email: debarishisribas@gmail.com\n" +
				"Phone: +8801714101688 \n"+
				"Facebook: https://www.facebook.com/devarshisrivasdasa");

		Log.d("", "");

	}
}
