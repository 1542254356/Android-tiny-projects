package com.mycompany.myapphjujgyhu8y;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		final NotificationManager n=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		Notification no=new Notification();
		no.icon=R.drawable.ic_launcher;
		no.tickerText="显示通知";
		no.when=System.currentTimeMillis();
		no.defaults=Notification.DEFAULT_ALL;
		no.setLatestEventInfo(MainActivity.this,"哈哈","红红火火恍恍惚惚+id",null);
		n.notify(7,no);
		
    }
}
