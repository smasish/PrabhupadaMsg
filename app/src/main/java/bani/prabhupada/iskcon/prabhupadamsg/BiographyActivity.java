package bani.prabhupada.iskcon.prabhupadamsg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class BiographyActivity extends Activity {

	private TextView ab;
	WebView mWebView;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.biography);

		mWebView = (WebView)findViewById(R.id.instructions_id);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.loadUrl("file:///android_asset/sp_biography.html");
		mWebView.setWebViewClient(new HelloWebViewClient());

		Log.d("", "");

	}

	private class HelloWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
			view.loadUrl(url);
			return true;
		}
	}
}
