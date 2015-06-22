package com.cheshangguanjia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cheshangguanjia.activity.FenPeiKehuActivity;
import com.cheshangguanjia.activity.GouCheXunjiaActivity;
import com.cheshangguanjia.activity.ManagerFeedBackActivity;
import com.cheshangguanjia.activity.QianKeListActivity;
import com.cheshangguanjia.activity.ReportNowActivity;
import com.cheshangguanjia.activity.ShiJiaYuyueActivity;
import com.cheshangguanjia.activity.WelcomeActivity;
import com.cheshangguanjia.activity.XiaoShouDianpingActivity;
import com.university.cheshangguanjia.R;

public class SaleManagerHomeFragment extends Fragment implements
		OnClickListener {
	private TextView qiankeshuView, hjiView, weifenpeiView, qiankeshuView1,
			hjiView1, weifenpeiView1, dingdanView, kaipiaoView, kucunView,
			buycarView, shijiayuyueView, manyiduView;
	private RelativeLayout middleLayout;
	private LinearLayout middleLayout2;
	private Button reportnowButton;
	//客户反馈按钮，不需要可以隐藏
	private TextView reportView;
	private TextView titleView;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_salemanager, null);
		initView(view);
		return view;
	}

	public void initView(View view) {
		qiankeshuView = (TextView) view.findViewById(R.id.sale_customer_text);
		hjiView = (TextView) view.findViewById(R.id.sale_h_text);
		weifenpeiView = (TextView) view.findViewById(R.id.sale_youguwen_text);
		qiankeshuView1 = (TextView) view
				.findViewById(R.id.sale_addcustomer_text);
		hjiView1 = (TextView) view.findViewById(R.id.sale_addh_text);
		weifenpeiView1 = (TextView) view
				.findViewById(R.id.sale_addyouguwen_text);
		dingdanView = (TextView) view.findViewById(R.id.report_item_sale);
		kaipiaoView = (TextView) view.findViewById(R.id.report_item_buycar);
		kucunView = (TextView) view.findViewById(R.id.report_item_keliu);
		buycarView = (TextView) view.findViewById(R.id.sale_item_bc);
		shijiayuyueView = (TextView) view.findViewById(R.id.sale_item_dy);
		manyiduView = (TextView) view.findViewById(R.id.sale_manyidu);
		reportnowButton = (Button) view.findViewById(R.id.btn_commit);
		middleLayout = (RelativeLayout) view
				.findViewById(R.id.intimereport_middle);
		middleLayout2 = (LinearLayout) view.findViewById(R.id.main_sale_layout);
		reportView=(TextView) view.findViewById(R.id.performance_after_third_text);
		titleView=(TextView) view.findViewById(R.id.main_top_companyname);

		qiankeshuView.setOnClickListener(this);
		hjiView.setOnClickListener(this);
		weifenpeiView.setOnClickListener(this);
		dingdanView.setOnClickListener(this);
		kaipiaoView.setOnClickListener(this);
		kucunView.setOnClickListener(this);
		buycarView.setOnClickListener(this);
		shijiayuyueView.setOnClickListener(this);
		manyiduView.setOnClickListener(this);
		reportnowButton.setOnClickListener(this);
		reportView.setOnClickListener(this);
		
		if(WelcomeActivity.role==1){
			titleView.setText("服务经理工作台");
			reportView.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.sale_customer_text:
			Intent intent = new Intent(getActivity(), QianKeListActivity.class);
			intent.putExtra("from", "qianzaikehu");
			startActivity(intent);
			break;
		case R.id.sale_h_text:
			intent = new Intent(getActivity(), QianKeListActivity.class);
			intent.putExtra("from", "Hjikehu");
			startActivity(intent);
			break;
		case R.id.sale_youguwen_text:
			intent = new Intent(getActivity(), FenPeiKehuActivity.class);
			startActivity(intent);
			break;
		case R.id.report_item_sale:
			break;
		case R.id.report_item_buycar:

			break;
		case R.id.report_item_keliu:

			break;
		case R.id.sale_item_bc:
			intent = new Intent(getActivity(), GouCheXunjiaActivity.class);
			startActivity(intent);
			break;
		case R.id.sale_item_dy:
			intent = new Intent(getActivity(), ShiJiaYuyueActivity.class);
			startActivity(intent);
			break;
		case R.id.sale_manyidu:
			intent = new Intent(getActivity(), XiaoShouDianpingActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_commit:
			intent = new Intent(getActivity(), ReportNowActivity.class);
			startActivity(intent);
			break;
		case R.id.performance_after_third_text:
			startActivity(new Intent(getActivity(),ManagerFeedBackActivity.class));
			break;
		default:
			break;
		}
	}

}
