package com.cheshangguanjia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class XubaoTixingActivity extends Activity {
	
	private View backView;
	private TextView dayNumView;
	private TextView timeView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xubao_tixing);
		
		initView();
	}

	private void initView() {
		backView=findViewById(R.id.goback);
		dayNumView=(TextView) findViewById(R.id.xubaoday);
		timeView=(TextView) findViewById(R.id.time);
		
		dayNumView.setText("312天");
		timeView.setText("2010年07月06日");
		
		backView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
