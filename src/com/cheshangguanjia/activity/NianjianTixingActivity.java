package com.cheshangguanjia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class NianjianTixingActivity extends Activity {
	
	private View backView;
	private TextView dayView;
	private TextView timeView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nianjian_tixing);
		
		initView();
	}
	
	private void initView(){
		backView=findViewById(R.id.goback);
		dayView=(TextView) findViewById(R.id.nianjianday);
		timeView=(TextView) findViewById(R.id.time);
		
		dayView.setText("419天");
		timeView.setText("2016年07月06日");
		backView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
