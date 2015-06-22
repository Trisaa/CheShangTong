package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.cheshangguanjia.adapter.BaoxianHomeAdapter;
import com.cheshangguanjia.adapter.RescueHomeAdapter;
import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

public class RescueHomeFragment extends Fragment{
	
	private View mainView;
	private EditText editText;
	private View searchView;
	private XListView dataView;
	private View noDataView;
	private ProgressBar waitView;
	private RescueHomeAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.rescue_home_fragment, null);
		initView();
		return mainView;
	}

	private void initView() {
		editText=(EditText) mainView.findViewById(R.id.editTextName);
		searchView=mainView.findViewById(R.id.search_view);
		dataView =(XListView) mainView.findViewById(R.id.callListView);
		noDataView=mainView.findViewById(R.id.nodata_view);
		waitView=(ProgressBar) mainView.findViewById(R.id.login_processbar);
		
		adapter=new RescueHomeAdapter(getActivity());
		dataView.setAdapter(adapter);
	}

}
