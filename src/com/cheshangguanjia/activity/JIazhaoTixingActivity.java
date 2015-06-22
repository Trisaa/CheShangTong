package com.cheshangguanjia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class JIazhaoTixingActivity extends Activity {
	
	private View backView;
	private TextView dayView;
	private TextView styleView;
	private TextView timeView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jiazhao_tixing);
		
		initView();
	}

	private void initView() {
		backView=findViewById(R.id.goback);
		dayView=(TextView) findViewById(R.id.jianzhaoday);
		styleView=(TextView) findViewById(R.id.time);
		timeView=(TextView) findViewById(R.id.licheng);
		
		backView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
