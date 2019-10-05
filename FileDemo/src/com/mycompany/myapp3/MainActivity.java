package com.mycompany.myapp3;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;

public class MainActivity extends Activity {
	private EditText writeET;
	private Button writeBtn,dq;
	private TextView contentView,dir;
	public static final String FILENAME = "setting.set";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		writeET = (EditText) findViewById(R.id.et);
		writeBtn = (Button) findViewById(R.id.btn);
		dir=(TextView)findViewById(R.id.dir);
		contentView = (TextView) findViewById(R.id.c);
		writeBtn.setOnClickListener(new OperateOnClickListener());
	}
	
	public void dq(View vb)
	{
		contentView.setText(readFiles());
	}

	class OperateOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			writeFiles(writeET.getText().toString());
			contentView.setText(readFiles());
			//System.out.println(getFilesDir());
			//dir.setText(getFilesDir().toString());
		}
	}

	// 保存文件内容
	private void writeFiles(String content) {
		try {
			// 打开文件获取输出流，文件不存在则自动创建
			FileOutputStream fos = openFileOutput(FILENAME,
												  Context.MODE_PRIVATE);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 读取文件内容
	private String readFiles() {
		String content = null;
		try {
			FileInputStream fis = openFileInput(FILENAME);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			content = baos.toString();
			fis.close();
			baos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
}
