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

	//ab.setBackgroundResource(R.drawable.ekadosi);
		//ab.setText("Phone\n +8801911612673\n\nEmail: asish.sust@gmail.com\n\nWebsite: www.sylhetiskcon.org");

		Log.d("", "");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/jan"+i+"</item>");

//		for(int i = 1;i<29;i++)
//			System.out.println("<item>@drawable/feb"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/mar"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/apr"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/may"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/jun"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/jul"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/aug"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/sep"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/oct"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/nov"+i+"</item>");
//		for(int i = 1;i<31;i++)
//			System.out.println("<item>@drawable/dec"+i+"</item>");
	}
}
