package com.cheshangguanjia.fragment;

import com.cheshangguanjia.activity.GouCheXunjiaActivity;
import com.cheshangguanjia.activity.KeFuHomeActivity;
import com.cheshangguanjia.activity.XiaoShouDianpingActivity;
import com.university.cheshangguanjia.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class KeFuHomeFragment extends Fragment implements OnClickListener{
	private TextView mycustomer,xubaoxunjia1,xubaoxunjia2,yangxiuyuyue1,yangxiuyuyue2,fuwudianping1,fuwudianping2,jinjijiuyuan1,jinjijiuyuan2,kehufankui;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.kefu_home_fragment, null);
		initView(view);
		return view;
	}
	
	public void initView(View view){
		mycustomer = (TextView)view.findViewById(R.id.guestcount);
		xubaoxunjia1 = (TextView)view.findViewById(R.id.item_bcnum);
		xubaoxunjia2 = (TextView)view.findViewById(R.id.sale_addbcnum_text);
		yangxiuyuyue1 = (TextView)view.findViewById(R.id.item_dynum);
		yangxiuyuyue2 = (TextView)view.findViewById(R.id.sale_adddynum_text);
		fuwudianping1 = (TextView)view.findViewById(R.id.sale_item_comtop);
		fuwudianping2 = (TextView)view.findViewById(R.id.sale_item_com);
		jinjijiuyuan1 = (TextView)view.findViewById(R.id.sale_item_pztop);
		jinjijiuyuan2 = (TextView)view.findViewById(R.id.sale_item_pz);
		kehufankui = (TextView)view.findViewById(R.id.performance_after_third_text);
		
		mycustomer.setOnClickListener(this);
		xubaoxunjia1.setOnClickListener(this);
		yangxiuyuyue1.setOnClickListener(this);
		fuwudianping2.setOnClickListener(this);
		jinjijiuyuan2.setOnClickListener(this);
		kehufankui.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.guestcount:
			((KeFuHomeActivity) getActivity()).toCustomer();
			break;
		case R.id.item_bcnum:
			Intent intent = new Intent(getActivity(),GouCheXunjiaActivity.class);
			intent.putExtra("from", "xubaoxunjia");
			startActivity(intent);
			break;
		case R.id.item_dynum:
			intent = new Intent(getActivity(),GouCheXunjiaActivity.class);
			intent.putExtra("from", "daichuliyuyue");
			startActivity(intent);
			break;
		case R.id.sale_item_com:
			intent = new Intent(getActivity(),GouCheXunjiaActivity.class);
			intent.putExtra("from", "fuwudianping");
			startActivity(intent);
			break;
		case R.id.sale_item_pz:
			intent = new Intent(getActivity(),GouCheXunjiaActivity.class);
			intent.putExtra("from", "jinjijiuyuan");
			startActivity(intent);
			break;
		case R.id.performance_after_third_text:
			intent = new Intent(getActivity(),XiaoShouDianpingActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	
	

}
