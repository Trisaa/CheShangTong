package com.cheshangguanjia.activity;

import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class ManagerGuestBasicActivity extends Activity implements
		OnClickListener {

	private ImageButton backView;
	private TextView beizhuView;
	private TextView adviserView;
	private View editContentView, adviserContentView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guest_basic_data);
		initView();
	}

	private void initView() {
		backView = (ImageButton) findViewById(R.id.goback);
		beizhuView = (TextView) findViewById(R.id.guestbeizhu);
		adviserView = (TextView) findViewById(R.id.revisittime);
		editContentView=findViewById(R.id.guestbeizhu_ll);
		adviserContentView=findViewById(R.id.revisittimelayout);

		backView.setOnClickListener(this);
		editContentView.setOnClickListener(this);
		adviserContentView.setOnClickListener(this);
		
		beizhuView.setText("--");
		adviserView.setText("张莲莲");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.guestbeizhu_ll:
			startActivity(new Intent(this, EditGuestDataActivity.class));
			break;
		case R.id.revisittimelayout:
			startActivity(new Intent(this, SelectDccActivity.class));
			break;
		default:
			break;
		}
	}

}
