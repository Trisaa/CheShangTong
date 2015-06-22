package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cheshangguanjia.adapter.SaleGuestReportAdapter;
import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

public class SaleGuestReportFragment extends Fragment{
	
	private View mainView;
	private XListView dataView;
	private SaleGuestReportAdapter guestAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView=inflater.inflate(R.layout.common_list_view, null);
		
		dataView=(XListView) mainView.findViewById(R.id.common_list_view);
		guestAdapter =new SaleGuestReportAdapter(getActivity());
		dataView.setAdapter(guestAdapter);
		
		return mainView;
	}
}
