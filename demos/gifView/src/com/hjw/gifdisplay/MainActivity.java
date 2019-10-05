package com.hjw.gifdisplay;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
	com.hjw.gifdisplay.GifView v;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		v=(com.hjw.gifdisplay.GifView)findViewById(R.id.mainGifView1);
		
    }
	
	public void HH(View v)
	{
		
	}
}
