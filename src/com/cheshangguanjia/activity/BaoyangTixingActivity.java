package com.cheshangguanjia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class BaoyangTixingActivity extends Activity {
	
	private TextView dayNumView;
	private TextView timeView;
	private TextView lichengView;
	private View backView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baoyang_tixing);
		
		initView();
	}

	private void initView() {
		dayNumView=(TextView) findViewById(R.id.baoyangday);
		timeView=(TextView) findViewById(R.id.time);
		lichengView=(TextView) findViewById(R.id.licheng);
		backView=findViewById(R.id.goback);
		
		backView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
