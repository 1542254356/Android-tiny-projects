package com.mycompany.hwdyx;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
	int id=1;
	String h,b;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		timerash.post(update);
		
    }
	
	
	Handler timerash=new Handler();
	Runnable update=new Runnable()
	{
		@Override
		public void run()
		{/*
			final NotificationManager n=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
			Notification no=new Notification();
			no.setLatestEventInfo(MainActivity.this,"哈哈","红红火火恍恍惚惚",null);
			n.notify(1,no);*/
			
			final NotificationManager n=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
			Notification no=new Notification();
			no.icon=R.drawable.ic_launcher;
			no.tickerText="显示通知";
			no.when=System.currentTimeMillis();
			no.defaults=Notification.DEFAULT_ALL;
			no.setLatestEventInfo(MainActivity.this,"哈哈"+id,"红红火火恍恍惚惚+id",null);
			n.notify(id,no);
			id++;
			if(id>45)
			{
				n.cancel(id-44);
				
			}
			
			
				timerash.postDelayed(update,10);
		}
		};
}
