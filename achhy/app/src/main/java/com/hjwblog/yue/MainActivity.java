package com.hjwblog.yue;

import android.app.*;
import android.os.*;
import android.webkit.*;
import android.view.*;

public class MainActivity extends Activity 
{
	private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
		// 去除标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		
        super.onCreate(savedInstanceState);
        //实例化WebView对象
        webview = new WebView(this);
        //设置WebView属性，能够执行Javascript脚本
        webview.getSettings().setJavaScriptEnabled(true);
        //加载需要显示的网页
		//webview.loadUrl("file:///android_asset/www/index.html");//显示本地网页
       webview.loadUrl("http://hjwblog.com/love/index.html");//显示远程网页
        //设置Web视图
        setContentView(webview);
		
		// 自动缩放
		webview.getSettings().setUseWideViewPort(true);
		webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
		webview.getSettings().setLoadWithOverviewMode(true);
//		

		
		webview.getSettings().setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webview.getSettings().setDisplayZoomControls(false); //隐藏原生的缩放控件，默认是true。如果不想显示放大和缩小按钮，将该属性设置为false即可
		
		
		// 自动播放声音
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			webview.getSettings().setMediaPlaybackRequiresUserGesture(false);
		}
		
    }

    @Override//设置回退
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
		finish();
        return false;
    }
}
	
	
 



	
