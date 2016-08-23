package bani.prabhupada.iskcon.prabhupadamsg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainListActivity extends Activity {
	/** Called when the activity is first created. */
	// @Override
	final String[] links = new String[] { "AutoBiography of Srila Prabhupada", "Chanting of Srila Prabhupada", "Daily Quotes of Prabhupada",
			"Ekadasi Chart", "Contact Us" };

	private TextView title;

	public static int b1 = 0;
	AssetManager am;
	//IconicAdapter adapter1;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newlist);

		final ListView lv = (ListView) findViewById(R.id.ListViewLinks);

		title = (TextView) findViewById(R.id.titlebar);
		title.setText("List of Prabhupada's Message");

		

		final StateAdapter adapter = new StateAdapter(this);
		lv.setAdapter(adapter);

		

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(final AdapterView<?> parent,
									final View view, final int position, final long id) {
//				Toast.makeText(getApplicationContext(),
//						String.valueOf(position), Toast.LENGTH_LONG).show();


//				final Intent imageshow = new Intent(MainListActivity.this,
//						GalleryActivity.class);

				if(position == 0){
					Intent bio = new Intent(MainListActivity.this,
							BiographyActivity.class);

					startActivity(bio);
				}

				if(position == 1){
					Intent about = new Intent(MainListActivity.this,
							AudioActivity.class);

					startActivity(about);
				}
				else if(position == 2){
					final Intent imageshow = new Intent(MainListActivity.this,
							MonthViewActivity.class);
					imageshow.putExtra("list", position);
					b1 = position;
					startActivity(imageshow);
				}
				else if(position == 3){
					 Intent imageshow = new Intent(MainListActivity.this,
							EkadosiActivity.class);

					startActivity(imageshow);
				}
				else if(position == 4){
					 Intent imageshow = new Intent(MainListActivity.this,
							AboutActivity.class);

					startActivity(imageshow);
				}




			}
		});
	}

	
	
	
	
	


	/* (non-Javadoc)
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
//		case R.id.about:
//			Intent i = new Intent(MainListActivity.this,AboutActivity.class);
//			startActivity(i);
//			 //setContentView(R.layout.about);
//		//Toast.makeText(this, "You pressed Icon", Toast.LENGTH_LONG).show();
//		break;
//
//		case R.id.exit:
//			this.finish();
//			break;
		}
		return super.onOptionsItemSelected(item);
	}

	
	
	/*
	 * first adapter for state
	 */

	private class StateAdapter extends ArrayAdapter<String> {
		// StateListActivty context;
		private final Context con;

		public StateAdapter(final Context c) {
			super(c, R.layout.listrow, links);
			con = c;
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(final int position, final View convertView,
				final ViewGroup parent) {
			View v = convertView;
			if (v == null) {
				final LayoutInflater vi = (LayoutInflater) con
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = vi.inflate(R.layout.listrow, null);
			}
			final TextView textView = (TextView) v
					.findViewById(R.id.feedrowitem);
			textView.setText(links[position]);

			return v;
		}
	}

}