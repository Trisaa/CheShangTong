package com.cheshangguanjia.fragment;

import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.cheshangguanjia.activity.SaleDayReportActivity;
import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.cheshangguanjia.service.SaleService;
import com.cheshangguanjia.service.OnQueryCompleteListener;
import com.cheshangguanjia.service.QueryId;
import com.university.cheshangguanjia.R;

@SuppressLint("ValidFragment")
public class ManagerSaleFragment extends Fragment implements OnClickListener,
		OnCheckedChangeListener, OnQueryCompleteListener {
	private String from;
	private View mainView;
	private Button reportView;
	private TextView guestView, phoneView, advisorView, carView;
	private RadioGroup sortView;
	private FragmentManager manager;
	private SaleService clientService;

	public ManagerSaleFragment(String from) {
		this.from = from;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.manager_custom_fragment, null);

		initView();

		initData();
		return mainView;
	}

	private void initData() {
		clientService = new SaleService();
		clientService.getClassNum(this, getActivity());
	}

	private void initView() {
		reportView = (Button) mainView.findViewById(R.id.nextto);
		if (from.equals("salemanager")) {
			reportView.setVisibility(View.GONE);
		}
		guestView = (TextView) mainView.findViewById(R.id.company_item_fans);
		phoneView = (TextView) mainView
				.findViewById(R.id.company_item_customers);
		advisorView = (TextView) mainView.findViewById(R.id.company_item_binds);
		carView = (TextView) mainView.findViewById(R.id.company_carstyle_binds);
		sortView = (RadioGroup) mainView
				.findViewById(R.id.salereport_radiogroup);

		reportView.setOnClickListener(this);
		sortView.setOnCheckedChangeListener(this);

		RankCountFragment rankFragment = new RankCountFragment();
		manager = ((FragmentActivity) getActivity())
				.getSupportFragmentManager();
		manager.beginTransaction()
				.replace(R.id.salemanagerhome_child_fragment, rankFragment,
						"rankSort").commit();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 监听报告控件点击事件
		case R.id.nextto:
			startActivity(new Intent(getActivity(), SaleDayReportActivity.class));
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onQueryComplete(QueryId queryId, Object result, EHttpError error) {
		if (result != null) {
			Map<String, Object> nums = (Map<String, Object>) result;
			List<Float> data = (List<Float>) nums.get("typenums");
			guestView.setText(String.valueOf(data.get(0)));
			phoneView.setText(String.valueOf(data.get(1)));
			advisorView.setText(String.valueOf(data.get(2)));
			carView.setText(String.valueOf(data.get(3)));
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		// 监听等级统计点击事件
		case R.id.dayreport:
			if (manager.findFragmentByTag("rankSort") == null) {
				Fragment fragment = new RankCountFragment();
				manager.beginTransaction()
						.replace(R.id.salemanagerhome_child_fragment, fragment,
								"rankSort").commit();
			} else {
				if (!manager.findFragmentByTag("rankSort").isAdded()) {
					manager.beginTransaction()
							.replace(R.id.salemanagerhome_child_fragment,
									manager.findFragmentByTag("rankSort"),
									"rankSort").commit();
				}
			}
			break;
		// 监听顾问排行点击事件
		case R.id.monthreport:
			if (manager.findFragmentByTag("dccSort") == null) {
				Fragment fragment = new DccSortFragment();
				manager.beginTransaction()
						.replace(R.id.salemanagerhome_child_fragment, fragment,
								"dccSort").commit();
			} else {
				if (!manager.findFragmentByTag("dccSort").isAdded()) {
					manager.beginTransaction()
							.replace(R.id.salemanagerhome_child_fragment,
									manager.findFragmentByTag("dccSort"),
									"dccSort").commit();
				}
			}
			break;
		// 监听车型排行点击事件
		case R.id.seasonreport:
			if (manager.findFragmentByTag("carSort") == null) {
				Fragment fragment = new CarSortFragment();
				manager.beginTransaction()
						.replace(R.id.salemanagerhome_child_fragment, fragment,
								"carSort").commit();
			} else {
				if (!manager.findFragmentByTag("carSort").isAdded()) {
					manager.beginTransaction()
							.replace(R.id.salemanagerhome_child_fragment,
									manager.findFragmentByTag("carSort"),
									"carSort").commit();
				}
			}
			break;
		default:
			break;
		}
	}

}
