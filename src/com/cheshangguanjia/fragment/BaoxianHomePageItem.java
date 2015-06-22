package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cheshangguanjia.adapter.BaoxianHomeAdapter;
import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

public class BaoxianHomePageItem extends Fragment{
	
	private View mainView;
	private XListView dataView;
	private BaoxianHomeAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mainView=inflater.inflate(R.layout.common_list_view, null);
		
		initView();
		
		return mainView;
	}
	
	private void initView(){
		dataView=(XListView) mainView.findViewById(R.id.common_list_view);
		
		adapter=new BaoxianHomeAdapter(getActivity());
		dataView.setAdapter(adapter);
	}
}
