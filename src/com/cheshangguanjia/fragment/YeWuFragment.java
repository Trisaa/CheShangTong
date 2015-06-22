package com.cheshangguanjia.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cheshangguanjia.activity.GouCheXunjiaActivity;
import com.cheshangguanjia.activity.QiangKehuActivity;
import com.cheshangguanjia.activity.SalerHomeActivity;
import com.cheshangguanjia.activity.ShiJiaYuyueActivity;
import com.cheshangguanjia.activity.XiaoShouDianpingActivity;
import com.cheshangguanjia.activity.ZhongJiangMingDanActivity;
import com.university.cheshangguanjia.R;

public class YeWuFragment extends Fragment implements OnClickListener{
	private TextView mycustomers,newcustomer,gouchexunjia1,gouchexunjia2,
					shijiayuyue1,shijiayuyue2,xiaoshoudianping1,xiaoshoudianping2,
					zhongjiangmingdan1,zhongjiangmingdan2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_saler_home, null);
		initView(view);
		return view;
	}
	
	public void initView(View view){
		mycustomers = (TextView)view.findViewById(R.id.guestcount);
		newcustomer = (TextView)view.findViewById(R.id.newcomeintv);
		gouchexunjia1 = (TextView)view.findViewById(R.id.item_bcnum);
		gouchexunjia2 = (TextView)view.findViewById(R.id.sale_addbcnum_text);
		shijiayuyue1 = (TextView)view.findViewById(R.id.item_dynum);
		shijiayuyue2 = (TextView)view.findViewById(R.id.sale_adddynum_text);
		xiaoshoudianping1 = (TextView)view.findViewById(R.id.sale_item_com);
		xiaoshoudianping2 = (TextView)view.findViewById(R.id.sale_item_comtop);
		zhongjiangmingdan1 = (TextView)view.findViewById(R.id.sale_item_pz);
		zhongjiangmingdan2 = (TextView)view.findViewById(R.id.sale_item_pztop);
		
		mycustomers.setOnClickListener(this);
		newcustomer.setOnClickListener(this);
		gouchexunjia1.setOnClickListener(this);
		shijiayuyue1.setOnClickListener(this);
		xiaoshoudianping1.setOnClickListener(this);
		zhongjiangmingdan1.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.guestcount:
			((SalerHomeActivity) getActivity()).toCustomer();
			break;
		case R.id.newcomeintv:
			Intent intent = new Intent(getActivity(),QiangKehuActivity.class);
			startActivity(intent);		
			break;
		case R.id.item_bcnum:
			intent = new Intent(getActivity(),GouCheXunjiaActivity.class);
			startActivity(intent);
			break;
		case R.id.item_dynum:
			intent = new Intent(getActivity(),ShiJiaYuyueActivity.class);
			startActivity(intent);
			break;
		case R.id.sale_item_com:
			intent = new Intent(getActivity(),XiaoShouDianpingActivity.class);
			startActivity(intent);
			break;
		case R.id.sale_item_pz:
			intent = new Intent(getActivity(),ZhongJiangMingDanActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	

}
