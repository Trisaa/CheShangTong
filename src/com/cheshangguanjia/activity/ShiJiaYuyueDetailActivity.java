package com.cheshangguanjia.activity;

import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShiJiaYuyueDetailActivity extends Activity implements OnClickListener{
	private ImageButton backButton;
	private Button personButton;
	private TextView dealer,needer,cartype,yuetime,description,shijiatime;
	private ImageView phoneView;
	private LinearLayout bottomLayout;
	private RelativeLayout linearLayout,statusLayout,baojiaLayout;
	private Button leftButton,rightButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yuyue_detail);
		initView();
	}
	
	public void initView(){
		backButton = (ImageButton)findViewById(R.id.goback);
		personButton = (Button)findViewById(R.id.userpic);
		phoneView = (ImageView)findViewById(R.id.callphoneicon);
		linearLayout = (RelativeLayout)findViewById(R.id.beizhu_ll);
		statusLayout = (RelativeLayout)findViewById(R.id.gueststatus_ll);
		baojiaLayout = (RelativeLayout)findViewById(R.id.baojia_ll);
		dealer = (TextView)findViewById(R.id.fixname_tv);
		needer = (TextView)findViewById(R.id.name_tv);
		cartype = (TextView)findViewById(R.id.carstyle);
		yuetime = (TextView)findViewById(R.id.timedate_tv);
		shijiatime = (TextView)findViewById(R.id.drivetime_tv);
		description = (TextView)findViewById(R.id.station);
		bottomLayout = (LinearLayout)findViewById(R.id.fix_ll);
		leftButton = (Button)findViewById(R.id.cancelbutton);
		rightButton = (Button)findViewById(R.id.okbutton);
		
		
		backButton.setOnClickListener(this);
		phoneView.setOnClickListener(this);
		personButton.setOnClickListener(this);
		linearLayout.setOnClickListener(this);
		leftButton.setOnClickListener(this);
		rightButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.beizhu_ll:
			break;
		case R.id.callphoneicon:
			break;
		case R.id.userpic:
			Intent intent = new Intent(this,CustomerDetailActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	

}
