package com.cheshangguanjia.activity;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.cheshangguanjia.fragment.SaleGuestReportFragment;
import com.cheshangguanjia.fragment.SaleServiceReportFragment;
import com.university.cheshangguanjia.R;

public class SaleDayReportActivity extends FragmentActivity implements OnClickListener,
		OnCheckedChangeListener {

	private ImageButton backView;
	private View showPopView;
	private RadioGroup toggleView;
	private View contentView;
	private PopupWindow popupWindow;
	private FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sale_day_report_activity);

		initView();
	}

	private void initView() {
		backView = (ImageButton) findViewById(R.id.salereport_back);
		showPopView = findViewById(R.id.xiaoshou_top_selection_type);
		toggleView = (RadioGroup) findViewById(R.id.salereport_radiogroup);

		backView.setOnClickListener(this);
		toggleView.setOnCheckedChangeListener(this);
		showPopView.setOnClickListener(this);

		contentView = getLayoutInflater().inflate(R.layout.sale_report_pop,
				null);
		popupWindow = new PopupWindow(contentView, LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		popupWindow.setFocusable(true);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		manager = getSupportFragmentManager();
		Fragment fragment = new SaleGuestReportFragment();
		manager.beginTransaction()
				.replace(android.R.id.tabcontent, fragment, "guestReport")
				.commit();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.salereport_back:
			finish();
			break;
		case R.id.xiaoshou_top_selection_type:
			popupWindow.showAsDropDown(showPopView);
			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.dayreport:
			if (manager.findFragmentByTag("guestReport") == null) {
				Fragment fragment = new SaleGuestReportFragment();
				manager.beginTransaction()
						.replace(android.R.id.tabcontent, fragment,
								"guestReport").commit();
			} else {
				if (!manager.findFragmentByTag("guestReport").isAdded()) {
					manager.beginTransaction()
							.replace(android.R.id.tabcontent,
									manager.findFragmentByTag("guestReport"),
									"guestReport").commit();
				}
			}
			break;
		case R.id.seasonreport:
			if (manager.findFragmentByTag("serviceReport") == null) {
				Fragment fragment = new SaleServiceReportFragment();
				manager.beginTransaction()
						.replace(android.R.id.tabcontent, fragment,
								"serviceReport").commit();
			} else {
				if (!manager.findFragmentByTag("serviceReport").isAdded()) {
					manager.beginTransaction()
							.replace(android.R.id.tabcontent,
									manager.findFragmentByTag("serviceReport"),
									"serviceReport").commit();
				}
			}
			break;
		default:
			break;
		}
	}
}
