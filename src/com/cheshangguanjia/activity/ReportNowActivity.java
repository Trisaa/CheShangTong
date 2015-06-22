package com.cheshangguanjia.activity;

import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ReportNowActivity extends Activity implements OnClickListener{
	private ImageButton backButton;
	private Button commitButton;
	private EditText dingdan,kaipiao,keliu,kucun;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reportnow);
		initView();
	}
	
	public void initView(){
		backButton = (ImageButton)findViewById(R.id.goback);
		commitButton = (Button)findViewById(R.id.commitbutton);
		dingdan = (EditText)findViewById(R.id.dingdan_edt);
		kaipiao = (EditText)findViewById(R.id.kaipiao_edt);
		keliu = (EditText)findViewById(R.id.keliu_edt);
		kucun = (EditText)findViewById(R.id.kucun_edt);
		
		backButton.setOnClickListener(this);
		commitButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.commitbutton:
			finish();		
			break;

		default:
			break;
		}
	}

}
