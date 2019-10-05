package com.hjw.shjxsh;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.text.*;
import java.util.*;

public class MainActivity extends Activity
{
	public TextView shj,rq,xq;
	public  String mWay;
	public int js=0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		shj=(TextView)findViewById(R.id.shj);
		rq=(TextView)findViewById(R.id.rq);
		xq=(TextView)findViewById(R.id.xq);
		TextView loveText=(TextView)findViewById(R.id.loveText);
		loveText.setText("月月我爱你🌙");
		Toast.makeText(MainActivity.this, "又见到你了，好高兴😀", Toast.LENGTH_SHORT).show();
		timerash.post(update);

    }
	

	long waitTime = 2000;
	long touchTime = 0;
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	if (event.getAction() == KeyEvent.ACTION_DOWN&& KeyEvent.KEYCODE_BACK == keyCode) {
	long currentTime = System.currentTimeMillis();
	if ((currentTime - touchTime) >= waitTime) {
	Toast.makeText(MainActivity.this, "好舍不得你😟️", Toast.LENGTH_SHORT).show();
	touchTime = currentTime;
	} else {
	finish();
	
	}
	return true;
	}
	return super.onKeyDown(keyCode, event);
	}
	
	
	
	
	int hhh=0;
	Handler timerash=new Handler();
	Runnable update=new Runnable()
	{
		@Override
   public void run()
		{
			SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日 ");
			SimpleDateFormat sh=new SimpleDateFormat("HH:mm:ss");
			Date shjh=new Date(System.currentTimeMillis());
			Date curDate = new Date(System.currentTimeMillis());//获取当前时间
			shj.setText(sh.format(shjh));
			rq.setText( formatter.format(curDate));
			xq.setText(StringDate());
			timerash.postDelayed(update,100);
		}

		private String StringDate()
		{
			Calendar c = Calendar.getInstance();

			c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

			mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));

			if("1".equals(mWay)){

				mWay ="天";

			}else if("2".equals(mWay))
			{
				mWay ="一";

			}else if("3".equals(mWay)){

				mWay ="二";

			}else if("4".equals(mWay)){

				mWay ="三";

			}else if("5".equals(mWay)){

				mWay ="四";

			}else if("6".equals(mWay)){

				mWay ="五";

			}else if("7".equals(mWay)){

				mWay ="六";
			}

			return "星期"+mWay;

		
			
			// TODO: Implement this method
			
		}
		

		


	

			
	};

	
}


