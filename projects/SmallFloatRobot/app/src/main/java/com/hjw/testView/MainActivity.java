package com.hjw.testView;

import android.app.*;
import android.os.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		requestWindowFeature(1);
		getWindow().setFlags(1024,1024);
        setContentView(new Xfq(this));
    }
}
