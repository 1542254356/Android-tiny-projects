package com.hjw.hjwapp;
import android.view.View;
import android.text.AutoText;
import android.view.View.OnClickListener;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.view.View.*;

public class MainActivity extends Activity
{
	private TextView shch=null;
	private EditText shr1=null,
	shr2=null;
	private Button qd=null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		this.shch=(TextView)super.findViewById(R.id.shch);
		this.shr1=(EditText)super.findViewById(R.id.shr1);
		this.shr2=(EditText)super.findViewById(R.id.shr2);
		this.qd=(Button)super.findViewById(R.id.qd);
		qd.setOnClickListener(new ShowListener());
    }
	private class ShowListener implements OnClickListener
	{

		@Override
		public void onClick(View p1)
		{
			// TODO: Implement this method
			String aStr=shr1.getText().toString();
			String bStr=shr2.getText().toString();
			int a=Integer.parseInt(aStr);
			int b=Integer.parseInt(bStr);
			
			int sum=a+b;
			//String s = Double.toString(sum);
			
			shch.setText(sum+"");
		}

		
		
	}
}
