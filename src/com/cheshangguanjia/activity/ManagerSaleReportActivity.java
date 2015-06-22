package com.cheshangguanjia.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.cheshangguanjia.fragment.ManagerReportFragment;
import com.university.cheshangguanjia.R;

public class ManagerSaleReportActivity extends FragmentActivity implements OnClickListener,
		OnCheckedChangeListener {

	private RadioGroup topSelection;
	private ImageButton backView;
	private ImageView arrowView;
	private RadioButton dayReport, monthReport, seasonReport;
	private int screenWidth;
	private LayoutParams arrowParams;
	private int halfWidth, oneWidth;
	private int normalColor=Color.parseColor("#7f07003c");
	private FragmentManager manager;
	private ManagerReportFragment dayFragment;
	private TextView titleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manager_salereport_activity);

		initView();
	}

	private void initView() {
		topSelection = (RadioGroup) findViewById(R.id.salereport_radiogroup);
		backView = (ImageButton) findViewById(R.id.salereport_back);
		arrowView = (ImageView) findViewById(R.id.tab_top_select);
		dayReport=(RadioButton) findViewById(R.id.dayreport);
		monthReport=(RadioButton) findViewById(R.id.monthreport);
		seasonReport=(RadioButton) findViewById(R.id.seasonreport);
		titleView=(TextView) findViewById(R.id.salereport_title);

		backView.setOnClickListener(this);
		topSelection.setOnCheckedChangeListener(this);
		dayReport.setTextColor(Color.BLACK);
		manager=getSupportFragmentManager();
		dayFragment=new ManagerReportFragment();
		manager.beginTransaction().replace(android.R.id.tabcontent, dayFragment).commit();
		
		Intent intent=getIntent();
		if(!intent.getBooleanExtra("sale", true)){
			titleView.setText("售后汇报");
		}

		screenWidth = getResources().getDisplayMetrics().widthPixels;
		arrowParams = (LayoutParams) arrowView.getLayoutParams();
		halfWidth = screenWidth / 6;
		oneWidth = screenWidth / 3;
		arrowParams.leftMargin = halfWidth;
		arrowView.setLayoutParams(arrowParams);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.salereport_back:
			finish();
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int checkedId) {
		resetButton();
		switch (checkedId) {
		// 监听日报点击事件
		case R.id.dayreport:
			arrowParams.leftMargin = halfWidth;
			dayReport.setTextColor(Color.BLACK);
			dayFragment.setTitle(0);
			break;
		// 监听月报点击事件
		case R.id.monthreport:
			arrowParams.leftMargin = halfWidth + oneWidth;
			monthReport.setTextColor(Color.BLACK);
			dayFragment.setTitle(1);
			break;
		// 监听季报点击事件
		case R.id.seasonreport:
			arrowParams.leftMargin = halfWidth + oneWidth * 2;
			seasonReport.setTextColor(Color.BLACK);
			dayFragment.setTitle(2);
			break;
		default:
			break;
		}
		arrowView.setLayoutParams(arrowParams);
	}

	private void resetButton() {
		dayReport.setTextColor(normalColor);
		monthReport.setTextColor(normalColor);
		seasonReport.setTextColor(normalColor);
	}

}
