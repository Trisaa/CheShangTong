package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cheshangguanjia.activity.WelcomeActivity;
import com.university.cheshangguanjia.R;

public class AfterSaleReportFragment extends Fragment implements
		OnClickListener {

	private View mainView;
	private View reportView;
	private View fixReportView;
	private TextView dataView;
	private TextView aimView;
	private TextView dataTwo, aimTwo;
	private TextView dataOne, aimOne;
	private TextView dataThree, aimThree;
	private TextView dataFour, aimFour;
	private TextView dataFive,aimFive;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(WelcomeActivity.role==2){
		mainView = inflater.inflate(R.layout.after_sale_report_item, null);
		}else if(WelcomeActivity.role==1){
		mainView=inflater.inflate(R.layout.service_after_sale_report, null);
		}

		initView();

		return mainView;
	}

	private void initView() {
		reportView = mainView.findViewById(R.id.commitreport);
		fixReportView = mainView.findViewById(R.id.fixreport);
		dataView = (TextView) mainView.findViewById(R.id.secondindex);
		aimView = (TextView) mainView.findViewById(R.id.thirdindex);
		dataOne = (TextView) mainView.findViewById(R.id.lYear_one);
		aimOne = (TextView) mainView.findViewById(R.id.taici_one);
		dataTwo = (TextView) mainView.findViewById(R.id.lYear_two);
		aimTwo = (TextView) mainView.findViewById(R.id.taici_two);
		dataThree = (TextView) mainView.findViewById(R.id.lYear_three);
		aimThree = (TextView) mainView.findViewById(R.id.taici_three);
		dataFour = (TextView) mainView.findViewById(R.id.lYear_four);
		aimFour = (TextView) mainView.findViewById(R.id.taici_four);
		
		if(WelcomeActivity.role==1){
			dataFive=(TextView) mainView.findViewById(R.id.lYear_five);
			aimFive=(TextView) mainView.findViewById(R.id.taici_five);
		}

		reportView.setOnClickListener(this);
		fixReportView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.commitreport:

			break;
		case R.id.fixreport:
			break;
		default:
			break;
		}
	}

}
