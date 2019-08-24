package com.hjw.ball1;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;

public class MainActivity extends Activity
{
	final Ball ball=new Ball(this);
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		ball.setMinimumHeight(300);
		ball.setMinimumWidth(500);
		ball.setOnTouchListener(new OnTouchListener()
			{

				@Override
				public boolean onTouch(View p1, MotionEvent p2)
				{
					ball.ballx=p2.getX();
					ball.bally=p2.getY();
					ball.invalidate();
					
					return true;
				}
				
			
		});
    }
	
	
	
}
