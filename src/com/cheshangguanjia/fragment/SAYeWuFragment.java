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

public class SAYeWuFragment extends Fragment implements OnClickListener{
	private TextView mycustomers,newcustomer,jinridaodian,
					daichuliyuyue,fuwudianping1,fuwudianping2,
					kehufankui1,kehufankui2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_guwen_home, null);
		initView(view);
		return view;
	}
	
	public void initView(View view){
		mycustomers = (TextView)view.findViewById(R.id.guestcount);
		newcustomer = (TextView)view.findViewById(R.id.newcomeintv);
		jinridaodian = (TextView)view.findViewById(R.id.item_bcnum);
		daichuliyuyue = (TextView)view.findViewById(R.id.item_dynum);
		fuwudianping1 = (TextView)view.findViewById(R.id.sale_item_com);
		fuwudianping2 = (TextView)view.findViewById(R.id.sale_item_comtop);
		kehufankui1 = (TextView)view.findViewById(R.id.sale_item_pz);
		kehufankui2 = (TextView)view.findViewById(R.id.sale_item_pztop);
		
		mycustomers.setOnClickListener(this);
		newcustomer.setOnClickListener(this);
		jinridaodian.setOnClickListener(this);
		daichuliyuyue.setOnClickListener(this);
		fuwudianping1.setOnClickListener(this);
		kehufankui1.setOnClickListener(this);
		
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
