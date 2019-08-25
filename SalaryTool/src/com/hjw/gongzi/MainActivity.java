package com.hjw.gongzi;

import android.app.*;
import android.content.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;
import java.text.*;

public class MainActivity extends Activity
{
	
	SharedPreferences sp;
	EditText zhsh,rsh,dj;
	TextView jg;
	DecimalFormat bl;
	int k=3;
	Button rshshzh;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
		
        setContentView(R.layout.main);
		zhsh=(EditText)findViewById(R.id.zhuan);
		zhsh.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
		rsh=(EditText)findViewById(R.id.rshu);
		dj=(EditText)findViewById(R.id.dj);
		rshshzh=(Button)findViewById(R.id.rshshzh);
		dj.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
		jg=(TextView)findViewById(R.id.jg);
		 bl= new DecimalFormat("######0.00");   
		sp=getSharedPreferences("dj",MODE_PRIVATE);
		Double dj1=Double.parseDouble(sp.getString("e","172"));
		dj.setText(bl.format(dj1));
		rsh.setText("3");
    }
	
	public void Rshshzh(View b)
	{
		if(k==4)
		{
			k=3;
			rshshzh.setText(4+"");
			rsh.setText(3+"");
		}
		else
		{
			k=4;
			rshshzh.setText(3+"");
			rsh.setText(4+"");
		}
	}
	
	public void Qk(View v)
	{
		zhsh.setText("");
		jg.setText("");
	}
	
	public void Js(View n)
	{
		sp.edit().
		putString("e",dj.getText().toString())
		.commit();
		if(zhsh.length()==0||rsh.length()==0||dj.length()==0)
			Toast.makeText(MainActivity.this,"请填写完整",Toast.LENGTH_SHORT).show();
			else
			{
		Double zhsh2,dj2,jg2;
		Integer rsh2;
		zhsh2=Double.parseDouble(zhsh.getText().toString());
		dj2=Double.parseDouble(dj.getText().toString());
		rsh2=Integer.parseInt(rsh.getText().toString());
		jg2=zhsh2*dj2/rsh2;
		jg.setText("结果:"+bl.format(jg2)+"元 ("+rsh2+"人)");
				Toast.makeText(MainActivity.this,"结果:"+bl.format(jg2)+"元 ("+rsh2+"人)",Toast.LENGTH_LONG).show();
		}
	}
}
