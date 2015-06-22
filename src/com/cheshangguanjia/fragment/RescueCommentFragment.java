package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

public class RescueCommentFragment extends Fragment{
	
	private View mainView;
	private XListView dataView;
	private View noDataView;
	private ProgressBar waitView;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		mainView=inflater.inflate(R.layout.rescure_comment_fragment, null);
		initView();
		return mainView;
	}

	private void initView() {
		dataView=(XListView) mainView.findViewById(R.id.callListView);
		noDataView=mainView.findViewById(R.id.nodata_view);
		waitView=(ProgressBar) mainView.findViewById(R.id.login_processbar);
		
		dataView.setVisibility(View.GONE);
		noDataView.setVisibility(View.VISIBLE);
	}

}
