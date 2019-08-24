package com.hjw.ball1;

import android.content.*;
import android.graphics.*;
import android.view.*;

public class Ball extends View
{
	public float 
	ballx=40,
	bally=50;
	

	public Ball (Context context)
	{
		super(context);
	}
	@Override
	protected void onDraw(Canvas canvas)
	{
		// TODO: Implement this method
		super.onDraw(canvas);
		Paint p=new Paint();
		p.setColor(Color.RED);
		canvas.drawCircle(ballx,bally,15,p);
		
	}
	
}
