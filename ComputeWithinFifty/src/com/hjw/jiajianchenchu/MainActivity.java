package com.hjw.jiajianchenchu;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.text.*;
import java.util.*;

public class MainActivity extends Activity
{
	int shyutime;
	static int worked,trued=0,js=0;
	public static int a,b;
	EditText edit;
	TextView text,time,feng,leftti;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		shyutime=21;
		js=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		edit=(EditText)findViewById(R.id.mainEditText1);
		text=(TextView)findViewById(R.id.mainTextView1);
		feng=(TextView)findViewById(R.id.mainTextView3);
		time=(TextView)findViewById(R.id.mainTextView2);
		leftti=(TextView)findViewById(R.id.mainTextView4);
		timerash.post(update);
		ti.post(up);
		rush();
		
		
		
		
    }
	
	public void Rush(View v)
	{
		rush();
	}
	
	public void Ok(View v)
	{
		if(edit.length()==0)
			Toast.makeText(MainActivity.this,"请重新输入答案",Toast.LENGTH_SHORT).show();
			else{
				int temp1;
				if(edit.length()>8)
					temp1=6666666;
					else
				temp1=Integer.parseInt(edit.getText().toString());
				
		if(temp1==(a+b))
			daan(1);
		else
			daan(0);
		
		shyutime=21;
		rush();
		}
	}
	
	public void daan(int k)
	{
		if(k==1)
		{
			worked++;
			trued++;
			Toast.makeText(MainActivity.this,"正确!",Toast.LENGTH_SHORT).show();
		}
		else
		{
			worked++;
			Toast.makeText(MainActivity.this,"错误",Toast.LENGTH_SHORT).show();
		}
	}
	
	public void rush()//刷新界面
	{
		a=1+(int)(Math.random()*50);
		b=1+(int)(Math.random()*50);
		text.setText(a+"+"+b+"=");
		edit.setText("");
	}
	
	Handler timerash=new Handler();
	Runnable update=new Runnable()
	{
		@Override
		public void run()
		{
			shyutime--;
			time.setText("剩余时间"+shyutime+"秒");
			if(js==0)
			timerash.postDelayed(update,1000);
		}
	};


	Handler ti=new Handler();
	Runnable up=new Runnable()
	{
		@Override
		public void run()
		{
			if(shyutime==0)
				{
					daan(0);
					rush();
					shyutime=21;
					
					//Toast.makeText(MainActivity.this,"超时",Toast.LENGTH_LONG).show();
				}
			if(worked==10)
			{
				if(trued>=6)
				{
					text.setText("不错👍");
				}
				else
				{
					text.setText("鄙视！！💩");
				}
				//worked=0;
				//trued=0;
				js=1;
				
			}
			
			
			
			feng.setText("你的得分是"+trued*10+"分");
			leftti.setText(worked+"/10");
			
			
			ti.postDelayed(up,10);
		}
	};
	
}
