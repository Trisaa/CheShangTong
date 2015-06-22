package com.cheshangguanjia.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.university.cheshangguanjia.R;

public class AfterSaleDayReportFragment extends Fragment implements
		OnCheckedChangeListener, OnClickListener {

	private View mainView;
	private View contentView;
	private PopupWindow popupWindow;
	private View showPopView;
	private View reportView;
	private RadioGroup group;
	private View dayView, monthView, seasonView;
	private FragmentManager manager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.after_sale_report_fragment, null);
		contentView = inflater.inflate(R.layout.after_sale_report_pop, null);
		initView();

		return mainView;
	}

	private void initView() {
		showPopView = mainView.findViewById(R.id.shouhou_top_selection_type);
		group = (RadioGroup) mainView.findViewById(R.id.salereport_radiogroup);
		reportView = mainView.findViewById(R.id.nextto);
		dayView = contentView.findViewById(R.id.selection_one);
		monthView = contentView.findViewById(R.id.selection_two);
		seasonView = contentView.findViewById(R.id.selection_three);

		popupWindow = new PopupWindow(contentView, LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		popupWindow.setFocusable(true);

		showPopView.setOnClickListener(this);
		group.setOnCheckedChangeListener(this);
		reportView.setVisibility(View.GONE);
		dayView.setOnClickListener(this);
		monthView.setOnClickListener(this);
		seasonView.setOnClickListener(this);

		AfterSaleReportPage fragment = new AfterSaleReportPage();
		manager = ((FragmentActivity)getActivity()).getSupportFragmentManager();
		manager.beginTransaction()
				.replace(R.id.shouhou_child_fragment, fragment, "indexOne")
				.commit();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.shouhou_top_selection_type:
			popupWindow.showAsDropDown(showPopView);
			break;
		case R.id.selection_one:
			break;
		case R.id.selection_two:
			break;
		case R.id.selection_three:
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.dayreport:
			if (manager.findFragmentByTag("indexOne") == null) {
				AfterSaleReportPage fragment = new AfterSaleReportPage();
				manager.beginTransaction()
						.replace(R.id.shouhou_child_fragment, fragment,
								"indexOne").commit();
			} else {
				if (!manager.findFragmentByTag("indexOne").isAdded()) {
					manager.beginTransaction()
							.replace(R.id.shouhou_child_fragment,
									manager.findFragmentByTag("indexOne"),
									"indexOne").commit();
				}
			}
			break;
		case R.id.monthreport:
			if (manager.findFragmentByTag("indexTwo") == null) {
				SaleGuestReportFragment fragment = new SaleGuestReportFragment();
				manager.beginTransaction()
						.replace(R.id.shouhou_child_fragment, fragment,
								"indexTwo").commit();
			} else {
				if (!manager.findFragmentByTag("indexTwo").isAdded()) {
					manager.beginTransaction()
							.replace(R.id.shouhou_child_fragment,
									manager.findFragmentByTag("indexTwo"),
									"indexTwo").commit();
				}
			}
			break;
		case R.id.seasonreport:
			if (manager.findFragmentByTag("indexThree") == null) {
				SaleServiceReportFragment fragment = new SaleServiceReportFragment();
				manager.beginTransaction()
						.replace(R.id.shouhou_child_fragment, fragment,
								"indexThree").commit();
			} else {
				if (!manager.findFragmentByTag("indexThree").isAdded()) {
					manager.beginTransaction()
							.replace(R.id.shouhou_child_fragment,
									manager.findFragmentByTag("indexThree"),
									"indexThree").commit();
				}
			}
			break;
		default:
			break;
		}
	}
}
