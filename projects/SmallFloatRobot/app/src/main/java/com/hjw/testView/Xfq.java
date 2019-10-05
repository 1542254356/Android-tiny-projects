package com.hjw.testView;

import android.content.*;
import android.graphics.*;
import android.view.*;
import android.widget.*;

public class Xfq extends SurfaceView
implements SurfaceHolder.Callback
{
	SurfaceHolder sfh;
	Paint p;
	Canvas canvas;
	Toast t;
	Bitmap bmp;
	
	@Override
	public void surfaceCreated(SurfaceHolder p1)
	{
		// TODO: Implement this method
		int sw=getWidth();
		int sh=getHeight();
		
		canvas=sfh.lockCanvas();
		canvas.drawRGB(255,255,255);
		p.setTextSize(50);
		p.setColor(0xffff0000);
		bmp=BitmapFactory.decodeResource(
			getResources(),R.drawable.ic_launcher);
		canvas.drawText("不要碰我",(sw-bmp.getWidth())/2-20,
						sh-bmp.getHeight()-50,p);
		
		canvas.drawBitmap(bmp,(sw-bmp.getWidth())/2,
		sh-bmp.getHeight(),p);
		sfh.unlockCanvasAndPost(canvas);
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder p1, int p2, int p3, int p4)
	{
		// TODO: Implement this method
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder p1)
	{
		// TODO: Implement this method
	}
	
	public Xfq(Context context)
	{
		super(context);
		sfh=getHolder();
		sfh.addCallback(this);
		p=new Paint();
		t=Toast.makeText(context,"",Toast.LENGTH_SHORT);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		int xx=(int)event.getX();
		int yy=(int)event.getY();
		t.setText("x坐标"+xx+"y坐标"+yy);
		t.show();
		canvas=sfh.lockCanvas();
		canvas.drawRGB(255,255,255);
		p.setTextSize(50);
		p.setColor(0xffff0000);
		canvas.drawText("你能不碰我吗",xx-150,yy-150,p);
		bmp=BitmapFactory.decodeResource(
			getResources(),R.drawable.ic_launcher);
		canvas.drawBitmap(bmp,xx-100,
						  yy-100,p);
		sfh.unlockCanvasAndPost(canvas);
		// TODO: Implement this method
		return true;
	}
	
}
