package com.hjw.alarm2;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity
{
	Button shzhnzh,qxnzh;
	TextView nzhshj;
	
	//static alarmclass alarm;
	Calendar mCalendar = Calendar.getInstance();  ;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		nzhshj=(TextView)findViewById(R.id.mainTextView1);
		//alarm=new alarmclass(this);
		Jt.alarm=new Alarmclass( this);
    }
	
	public void Shzhnzh(View k)
	{
		
		//alarm.openAlarm(32, "ddd","ffff", System.currentTimeMillis()+10000);
		mCalendar.setTimeInMillis(System.currentTimeMillis());
		int mHour = mCalendar.get(Calendar.HOUR_OF_DAY);
		int mMinute = mCalendar.get(Calendar.MINUTE);
		new TimePickerDialog(MainActivity.this,
			new TimePickerDialog.OnTimeSetListener() {
				public void onTimeSet(TimePicker view,
									  int hourOfDay, int minute) 
				{
					mCalendar.setTimeInMillis(System
											  .currentTimeMillis());
					mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
					mCalendar.set(Calendar.MINUTE, minute);
					mCalendar.set(Calendar.SECOND, 0);
					mCalendar.set(Calendar.MILLISECOND, 0);
					Jt.alarm.openAlarm(32, "ddd",
													  "ffff", mCalendar.getTimeInMillis());
				}
			}, mHour, mMinute, true).show();
	}
	
		
						
	
	public void Qxnzh(View v)
	{
		
	}
}
