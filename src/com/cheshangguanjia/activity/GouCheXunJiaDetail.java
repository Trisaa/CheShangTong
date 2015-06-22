package com.cheshangguanjia.activity;

import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class GouCheXunJiaDetail extends Activity implements OnClickListener{
	private ImageButton back;
	private Button person;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gouchexunjia_detail);
		initView();
	}
	public void initView(){
		back = (ImageButton)findViewById(R.id.goback);
		person = (Button)findViewById(R.id.userpic);
		
		back.setOnClickListener(this);
		person.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.userpic:
			Intent intent = new Intent(GouCheXunJiaDetail.this,CustomerDetailActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	

}
