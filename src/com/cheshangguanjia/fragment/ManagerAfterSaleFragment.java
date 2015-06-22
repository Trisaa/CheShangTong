package com.cheshangguanjia.fragment;

import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.cheshangguanjia.service.AfterSaleService;
import com.cheshangguanjia.service.OnQueryCompleteListener;
import com.cheshangguanjia.service.QueryId;
import com.university.cheshangguanjia.R;
import com.university.cheshangguanjia.R.integer;

public class ManagerAfterSaleFragment extends Fragment implements
		OnClickListener, OnCheckedChangeListener, OnQueryCompleteListener {
	private TextView carownerView, pipeiView, registerView, unbindView;
	private Button reportView;
	private RadioGroup radioGroup;
	private FragmentManager manager;
	private AfterSaleService afterSaleService;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_aftersalemanager_home,
				null);
		initView(view);
		initData();
		return view;
	}

	private void initData() {
		afterSaleService = new AfterSaleService();
		afterSaleService.getCuster(this, getActivity());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onQueryComplete(QueryId queryId, Object result, EHttpError error) {
		if (result != null) {
			Map<String, Object> data = (Map<String, Object>) result;
			List<Double> typeNums = (List<Double>) data.get("typenums");
			carownerView.setText(typeNums.get(0).toString());
			pipeiView.setText(typeNums.get(1).toString());
			registerView.setText(typeNums.get(2).toString());
			unbindView.setText(typeNums.get(3).toString());
		}
	}

	public void initView(View view) {
		reportView = (Button) view.findViewById(R.id.nextto);
		carownerView = (TextView) view.findViewById(R.id.company_item_fans);
		pipeiView = (TextView) view.findViewById(R.id.company_item_customers);
		registerView = (TextView) view.findViewById(R.id.company_item_binds);
		unbindView = (TextView) view.findViewById(R.id.company_carstyle_binds);
		radioGroup = (RadioGroup) view.findViewById(R.id.salereport_radiogroup);

		radioGroup.setOnCheckedChangeListener(this);
		reportView.setOnClickListener(this);
		manager = getFragmentManager();
		manager.beginTransaction()
				.replace(R.id.aftersalemanagerhome_child_fragment,
						new SApaihangFragment(), "SASort").commit();
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg1) {
		case R.id.dayreport:
			if (manager.findFragmentByTag("SASort") == null) {
				Fragment fragment = new SApaihangFragment();
				manager.beginTransaction()
						.replace(R.id.aftersalemanagerhome_child_fragment,
								fragment, "SASort").commit();
			} else {
				if (!manager.findFragmentByTag("SASort").isAdded()) {
					manager.beginTransaction()
							.replace(R.id.aftersalemanagerhome_child_fragment,
									manager.findFragmentByTag("SASort"),
									"SASort").commit();
				}
			}
			break;
		case R.id.seasonreport:
			if (manager.findFragmentByTag("afterCarSort") == null) {
				Fragment fragment = new CarStylepaihangFragment();
				manager.beginTransaction()
						.replace(R.id.aftersalemanagerhome_child_fragment,
								fragment, "afterCarSort").commit();
			} else {
				if (!manager.findFragmentByTag("afterCarSort").isAdded()) {
					manager.beginTransaction()
							.replace(R.id.aftersalemanagerhome_child_fragment,
									manager.findFragmentByTag("afterCarSort"),
									"afterCarSort").commit();
				}
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.nextto:
			startActivity(new Intent(getActivity(), SaleDayReportActivity.class));
			break;

		default:
			break;
		}
	}

}
