package com.cheshangguanjia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class RescueHistoryActivity extends Activity {
	
	private View backView;
	private TextView nameView;
	private TextView reciveTimeView;
	private TextView dealTimeView;
	private TextView arriveTimeView;
	private TextView cancleView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rescue_history_activity);
		
		initView();
	}
	
	private void initView(){
		backView=findViewById(R.id.goback);
		nameView=(TextView) findViewById(R.id.name_tv);
		reciveTimeView=(TextView) findViewById(R.id.receiver_tv);
		dealTimeView=(TextView) findViewById(R.id.fixtime_tv);
		arriveTimeView=(TextView) findViewById(R.id.arrive_tv);
		cancleView=(TextView) findViewById(R.id.guzhang);
		
		backView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		nameView.setText("李旺");
		reciveTimeView.setText("04-11 10:18");
		dealTimeView.setText("10-19 12:29");
		arriveTimeView.setText("10-19 12:29");
		cancleView.setText("10-19 12:29");
	}
}
