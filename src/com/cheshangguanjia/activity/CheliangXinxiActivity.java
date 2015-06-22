package com.cheshangguanjia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class CheliangXinxiActivity extends Activity {

	private View backView;
	private TextView vinView, seqView, carNumView, carStyleView, timeView,
			lichengView, statusView, zhuceView;
	private ProgressBar waitViewBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cheliang_xinxi);
		
		initView();
	}
	
	private void initView(){
		backView=findViewById(R.id.goback);
		vinView=(TextView) findViewById(R.id.vinhao);
		seqView=(TextView) findViewById(R.id.uid);
		carNumView=(TextView) findViewById(R.id.chepai);
		carStyleView=(TextView) findViewById(R.id.chexing);
		timeView=(TextView) findViewById(R.id.buycartime);
		lichengView=(TextView) findViewById(R.id.licheng);
		statusView=(TextView) findViewById(R.id.status);
		zhuceView=(TextView) findViewById(R.id.registertime);
		waitViewBar=(ProgressBar) findViewById(R.id.login_processbar);
		
		backView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
