package com.hjw.caidang;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.util.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }


	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(1,1,2,"关于").setIcon(android.R.drawable.ic_dialog_info);
		menu.add(2,2,1,"退出").setIcon(android.R.drawable.ic_lock_power_off);
		// TODO: Implement this method
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getItemId()==1)
			Toast.makeText(MainActivity.this,"环家伟制作",Toast.LENGTH_LONG).show();
			else{
				finish();
			android.os.Process.killProcess(android.os.Process.myPid());
		}
		// TODO: Implement this method
		return false;
	}
	
	
	
	
}
