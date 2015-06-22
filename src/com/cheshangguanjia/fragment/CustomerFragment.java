package com.cheshangguanjia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cheshangguanjia.activity.CustomerDetailActivity;
import com.cheshangguanjia.activity.WelcomeActivity;
import com.cheshangguanjia.adapter.CustomerAdapter;
import com.university.cheshangguanjia.R;

public class CustomerFragment extends Fragment{
	private EditText searchEditText;
	private RadioGroup radioGroup;
	private TextView titleView;
	private RadioButton radio1,radio2,radio3;
	private ExpandableListView listView;
	private CustomerAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_customer, null);
		initView(view);
		return view;
	}
	
	public void initView(View view){
		listView = (ExpandableListView)view.findViewById(R.id.salereport_item_listview);
		radioGroup = (RadioGroup)view.findViewById(R.id.main_tab_group);
		radio1 = (RadioButton)view.findViewById(R.id.main_tab_tel);
		radio2 = (RadioButton)view.findViewById(R.id.main_tab_time);
		radio3 = (RadioButton)view.findViewById(R.id.main_tab_rank);
		titleView = (TextView)view.findViewById(R.id.teamname);
		if(WelcomeActivity.role == 5){
			titleView.setText("客户列表");
		}
		if(WelcomeActivity.role == 4){
			radio1.setText("全部");
			radio2.setText("按车型");
			radio3.setText("按等级");
			}
		else if(WelcomeActivity.role == 5){
			radio1.setText("全部");
			radio2.setText("保养到期");
			radio3.setText("流失客户");
		}
		else if(WelcomeActivity.role == 8){
			radio1.setText("全部");
			radio2.setText("保养到期");
			radio3.setText("续保到期");
		}
		adapter = new CustomerAdapter(getActivity());
		listView.setAdapter(adapter);
		listView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView arg0, View arg1, int arg2,
					int arg3, long arg4) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),CustomerDetailActivity.class);
				startActivity(intent);
				return false;
			}
		});
	}

}
