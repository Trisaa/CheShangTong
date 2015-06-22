package com.cheshangguanjia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cheshangguanjia.adapter.GuestRankAdapter;
import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.cheshangguanjia.service.CustomerService;
import com.cheshangguanjia.service.OnQueryCompleteListener;
import com.cheshangguanjia.service.QueryId;
import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

public class GuestRankActivity extends Activity implements OnClickListener, OnQueryCompleteListener {
	
	private ImageButton backView;
	private TextView titleView;
	private XListView dataView;
	private GuestRankAdapter adapter;
	private String rank;
	private CustomerService customerService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_title_list_view);
		
		initView();
		initData();
	}

	private void initData() {
		customerService=new CustomerService();
		customerService.getClaszBuyer(rank, this);
	}
	
	@Override
	public void onQueryComplete(QueryId queryId, Object result, EHttpError error) {
		System.out.println(result);
	}

	private void initView() {
		backView=(ImageButton) findViewById(R.id.goback);
		titleView=(TextView) findViewById(R.id.titlename);
		dataView=(XListView) findViewById(R.id.common_list);
		
		initTitle();
		
		backView.setOnClickListener(this);
		dataView.setPullRefreshEnable(false);
		dataView.setPullLoadEnable(false);
		adapter=new GuestRankAdapter(this, rank);
		dataView.setAdapter(adapter);
	}
	
	private void initTitle() {
		switch (getIntent().getIntExtra("rank", 0)) {
		case 1:
			rank="H";
			break;
		case 2:
			rank="A";
			break;
		case 3:
			rank="B";
			break;
		case 4:
			rank="C";
			break;
		case 5:
			rank="O";
			break;
		case 6:
			rank="F";
			break;
		default:
			break;
		}
		titleView.setText(rank+"级客户");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;

		default:
			break;
		}
	}
}
