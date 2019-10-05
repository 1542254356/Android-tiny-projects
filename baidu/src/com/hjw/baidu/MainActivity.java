package com.hjw.baidu;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.webkit.*;
import android.widget.*;
import com.hjw.baidu.*;

public class MainActivity extends Activity
{
	WebView v;
	ProgressDialog progressDialog;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		  
		v=(WebView)findViewById(R.id.mainWebView1);
		v.setDownloadListener(new MyWebViewDownLoadListener()); 
		v.loadUrl("http://www.baidu.com/index.html");
		v.setWebViewClient(new WebViewClient(){
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					view.loadUrl(url);
					return true;
				}
				
				@Override
				public void onPageStarted(WebView view, String url,Bitmap favicon) {//网页页面开始加载的时候
					if (progressDialog == null) {
						progressDialog=new ProgressDialog(MainActivity.this);
						progressDialog.setMessage("玩命加载中。。。");
						progressDialog.show();
						v.setEnabled(false);// 当加载网页的时候将网页进行隐藏
					}
					super.onPageStarted(view, url,favicon);
				}
				
				
				@Override
				public void onPageFinished(WebView view, String url) {//网页加载结束的时候
//super.onPageFinished(view, url);
					if (progressDialog != null && progressDialog.isShowing()) {
						progressDialog.dismiss();
						progressDialog = null;
						v.setEnabled(true);
					}
				}
				
			});
		
    }
	
	long waitTime = 2000;
	long touchTime = 0;
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if((keyCode==KeyEvent.KEYCODE_BACK)&&v.canGoBack())
			v.goBack();  
			else{
				
				if (event.getAction() == KeyEvent.ACTION_DOWN&& KeyEvent.KEYCODE_BACK == keyCode) {
			long currentTime = System.currentTimeMillis();
			if ((currentTime - touchTime) >= waitTime) {
				Toast.makeText(MainActivity.this, "再按一次退出️", Toast.LENGTH_SHORT).show();
				touchTime = currentTime;
			} else {
				finish();

			}
			}
			
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	private class MyWebViewDownLoadListener implements DownloadListener{  
		@Override  
		public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype,  
									long contentLength) {             
            Log.i("tag", "url="+url);             
            Log.i("tag", "userAgent="+userAgent);  
            Log.i("tag", "contentDisposition="+contentDisposition);           
            Log.i("tag", "mimetype="+mimetype);  
            Log.i("tag", "contentLength="+contentLength);  
            Uri uri = Uri.parse(url);  
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);  
            startActivity(intent);             
        }  
    }  
	
	
	
	public void goBack(View p)
	{
		v.goBack();
		
	}
	
	public void goForward(View n)
	{
		v.goForward();
	}
	
	public void reload(View n)
	{
		v.reload();
	}
	
	public void stopLoading(View p)
	{
		v=(WebView)findViewById(R.id.mainWebView1);
		v.loadUrl("http://www.baidu.com/index.html");
	}
	
	
	
}
