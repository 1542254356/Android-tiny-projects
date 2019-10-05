package com.hjw.alarm2;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.os.PowerManager;
import android.widget.*;


public class Call extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Window win = getWindow();
		win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
					 | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
		win.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
					 | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
		
		
		new AlertDialog.Builder(Call.this)
			.setIcon(R.drawable.ic_launcher)
			.setTitle("时间到")
			.setMessage("关闭闹钟需要做一些题。")
			.setPositiveButton("确定",
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,
									int whichButton) {
										finish();
//					System.exit(0);
//					android.os.Process
//						.killProcess(android.os.Process
//									 .myPid());
				}
			}).show();
	}

	@Override
	protected void onResume()
	{
		//PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
		//WakeLock mWakelock = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP |PowerManager.SCREEN_DIM_WAKE_LOCK, "SimpleTimer");
		//mWakelock.acquire();
		
		
		// TODO: Implement this method
		super.onResume();
	}

	@Override
	protected void onPause()
	{
		//mWakelock.release();
		// TODO: Implement this method
		super.onPause();
	}
	
	
	
	}

