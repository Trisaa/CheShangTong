package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class ManagerReportItemFragment extends Fragment implements
		OnClickListener {

	private View mainView;
	private ProgressBar waitView;
	private Button commitReport;
	private View dataView;
	private TextView currentIndexView, aimIndexView;
	private int index = -1;
	private TextView dataOne, aimOne;
	private TextView dataTwo, aimTwo;
	private TextView dataThree, aimThree;
	private TextView dataFour, aimFour;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedIncstanceState) {
		mainView = inflater.inflate(R.layout.manager_salereport_item, null);

		initView();

		return mainView;
	}

	private void initView() {
		waitView = (ProgressBar) mainView
				.findViewById(R.id.salereport_processbar);
		commitReport = (Button) mainView.findViewById(R.id.commitreport);
		dataView = mainView.findViewById(R.id.dataView);
		currentIndexView = (TextView) mainView.findViewById(R.id.secondindex);
		aimIndexView = (TextView) mainView.findViewById(R.id.thirdindex);
		dataOne=(TextView) mainView.findViewById(R.id.lYear_one);
		aimOne=(TextView) mainView.findViewById(R.id.datetaici_one);
		dataTwo=(TextView) mainView.findViewById(R.id.lYear_two);
		aimTwo=(TextView) mainView.findViewById(R.id.datetaici_two);
		dataThree=(TextView) mainView.findViewById(R.id.lYear_three);
		aimThree=(TextView) mainView.findViewById(R.id.datetaici_three);
		dataFour=(TextView) mainView.findViewById(R.id.lYear_four);
		aimFour=(TextView) mainView.findViewById(R.id.datetaici_four);

		waitView.setVisibility(View.GONE);
		dataView.setVisibility(View.VISIBLE);
		commitReport.setOnClickListener(this);
		changeTitle();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 监听崔报表点击事件
		case R.id.commitreport:

			break;

		default:
			break;
		}
	}

	public void setTitle(int index) {
		this.index = index;

	}

	public void changeTitle() {
		switch (index) {
		case 0:
			currentIndexView.setText("当天");
			aimIndexView.setText("月总指数/指标");
			break;
		case 1:
			currentIndexView.setText("月汇总");
			aimIndexView.setText("指标");
			break;
		case 2:
			currentIndexView.setText("季汇总");
			aimIndexView.setText("指标");
			break;
		default:
			break;
		}
	}
}
