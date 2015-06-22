package com.cheshangguanjia.activity;

import java.util.ArrayList;
import java.util.List;

import com.cheshangguanjia.view.wheelview.ArrayWheelAdapter;
import com.cheshangguanjia.view.wheelview.NumericWheelAdapter;
import com.cheshangguanjia.view.wheelview.WheelView;
import com.university.cheshangguanjia.R;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class BaoxianTouBaoActivity extends Activity implements OnClickListener {

	private TextView toubaoView;
	private WheelView yearView;
	private WheelView monthView;
	private WheelView dayView;
	private View cancleView;
	private View sureView;
	private View backView;
	private String[] yearDatas=new String[]{"2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015"};
	private String[] monthDatas=new String[]{"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baoxian_toubao);

		initView();
	}

	private void initView() {
		toubaoView = (TextView) findViewById(R.id.pricetimetv);
		yearView = (WheelView) findViewById(R.id.year);
		monthView = (WheelView) findViewById(R.id.month);
		dayView = (WheelView) findViewById(R.id.day);
		cancleView = findViewById(R.id.cancelbutton);
		sureView = findViewById(R.id.okbutton);
		backView = findViewById(R.id.goback);

		cancleView.setOnClickListener(this);
		sureView.setOnClickListener(this);
		backView.setOnClickListener(this);
		
		yearView.setViewAdapter(new ArrayWheelAdapter<String>(this, yearDatas));
		monthView.setViewAdapter(new ArrayWheelAdapter<String>(this, monthDatas));
		dayView.setViewAdapter(new NumericWheelAdapter(this, 1, 31));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.cancelbutton:
			finish();
			break;
		case R.id.okbutton:
			finish();
			break;
		default:
			break;
		}
	}
}
