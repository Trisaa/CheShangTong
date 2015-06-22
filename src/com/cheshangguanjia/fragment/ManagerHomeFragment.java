package com.cheshangguanjia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cheshangguanjia.activity.ManagerCommentActivity;
import com.cheshangguanjia.activity.ManagerFeedBackActivity;
import com.cheshangguanjia.activity.ManagerSaleReportActivity;
import com.university.cheshangguanjia.R;

public class ManagerHomeFragment extends Fragment implements OnClickListener{
	
	private View mainView;
	//顶部四个标签
	private TextView fansView, guestView, carView, unknowView;
	private TextView detailDateView;
	private TextView saleNoReportView, afterSaleNoReportView;
	private View saleSafityView, afterSafityView;
	private TextView saleNumView, afterNumView;
	private TextView feedBackView;
	private ProgressBar waitView;
	private View reportLeft, reportRight;
	private TextView titleView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView=inflater.inflate(R.layout.manager_home_fragment, null);
		
		initView();
		
		return mainView;
	}

	private void initView() {
		fansView=(TextView) mainView.findViewById(R.id.company_item_fans);
		guestView=(TextView) mainView.findViewById(R.id.company_item_customers);
		carView=(TextView) mainView.findViewById(R.id.company_item_binds);
		unknowView=(TextView) mainView.findViewById(R.id.company_carstyle_binds);
		detailDateView=(TextView) mainView.findViewById(R.id.company_detail_date);
		saleNoReportView=(TextView) mainView.findViewById(R.id.performance_sale_first_noreport);
		afterSaleNoReportView=(TextView) mainView.findViewById(R.id.company_detail_aftersale_noreport);
		saleSafityView=mainView.findViewById(R.id.sale_safity_ll);
		afterSafityView=mainView.findViewById(R.id.aftersale_safity_ll);
		saleNumView=(TextView) mainView.findViewById(R.id.company_detail_msgpush_text);
		afterNumView=(TextView) mainView.findViewById(R.id.performance_appointment_text);
		feedBackView=(TextView) mainView.findViewById(R.id.performance_after_third_text);
		waitView=(ProgressBar) mainView.findViewById(R.id.company_detail_empty_processbar);
		reportLeft=mainView.findViewById(R.id.company_detail_sale_layout);
		reportRight=mainView.findViewById(R.id.company_detail_aftersale_layout);
		titleView=(TextView) mainView.findViewById(R.id.name_tv);
		
		fansView.setText("3692");
		guestView.setText("437");
		carView.setText("2406");
		unknowView.setText("532");
		saleNumView.setText("100%");
		afterNumView.setText("100%");
		feedBackView.setText("客户反馈(54)");
		titleView.setText("大连中省丰田汽车销售有限公司");
		
		saleSafityView.setOnClickListener(this);
		afterSafityView.setOnClickListener(this);
		reportLeft.setOnClickListener(this);
		reportRight.setOnClickListener(this);
		feedBackView.setOnClickListener(this);
		
		waitView.setVisibility(View.GONE);
		saleNoReportView.setVisibility(View.VISIBLE);
		afterSaleNoReportView.setVisibility(View.VISIBLE);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		//右边的暂无汇报点击事件
		case R.id.company_detail_aftersale_layout:
			Intent intent1=new Intent(getActivity(),ManagerSaleReportActivity.class);
			intent1.putExtra("sale", false);
			getActivity().startActivity(intent1);
			break;
		//左边的暂无汇报点击事件
		case R.id.company_detail_sale_layout:
			getActivity().startActivity(new Intent(getActivity(), ManagerSaleReportActivity.class));
			break;
		//销售满意度点击事件
		case R.id.sale_safity_ll:
			getActivity().startActivity(new Intent(getActivity(),ManagerCommentActivity.class));
			break;
		//售后满意度点击事件
		case R.id.aftersale_safity_ll:
			Intent intent2=new Intent(getActivity(),ManagerCommentActivity.class);
			intent2.putExtra("isAfter", true);
			getActivity().startActivity(intent2);
			break;
		//客户反馈点击事件
		case R.id.performance_after_third_text:
			startActivity(new Intent(getActivity(),ManagerFeedBackActivity.class));
			break;
		default:
			break;
		}
	}
	
}
