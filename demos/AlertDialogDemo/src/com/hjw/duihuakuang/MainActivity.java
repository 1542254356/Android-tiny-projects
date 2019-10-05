package com.hjw.duihuakuang;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.view.View.*;

public class MainActivity extends Activity
{
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Button button=(Button)findViewById(R.id.mainButton1);
		
    }
	
	public void button(View v)
	{
		AlertDialog dialog=new AlertDialog.Builder(MainActivity.this).create();
		dialog.setTitle("hjwt");
		dialog.setMessage("hjwb");
		
		dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",new DialogInterface. OnClickListener()
			{

				@Override
				public void onClick(DialogInterface dialog,int which)
				{
					// TODO: Implement this method
				}
				
			
		});
		dialog.show();
	}
}
