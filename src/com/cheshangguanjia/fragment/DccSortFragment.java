package com.cheshangguanjia.fragment;

import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cheshangguanjia.adapter.DccSortAdapter;
import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.cheshangguanjia.service.OnQueryCompleteListener;
import com.cheshangguanjia.service.QueryId;
import com.cheshangguanjia.service.SaleService;
import com.cheshangguanjia.view.XListView;
import com.cheshangguanjia.view.XListView.IXListViewListener;
import com.university.cheshangguanjia.R;

public class DccSortFragment extends Fragment implements
		OnQueryCompleteListener, IXListViewListener {

	private View mainView;
	private XListView dataView;
	private ProgressBar waitView;
	private View noDataView;
	private DccSortAdapter adapter;
	private SaleService clientManageService;
	private List<Map<String, Object>> sales;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.dcc_sort_fragment, null);

		initView();

		initData();

		return mainView;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onQueryComplete(QueryId queryId, Object result, EHttpError error) {
		waitView.setVisibility(View.GONE);
		
		dataView.stopRefresh();
		if (result != null) {
			Map<String, Object> data = (Map<String, Object>) result;
			sales = (List<Map<String, Object>>) data.get("sales");
			adapter = new DccSortAdapter(getActivity(), sales);
			dataView.setAdapter(adapter);
		}else{
			noDataView.setVisibility(View.VISIBLE);
		}
		
	}

	private void initData() {
		clientManageService = new SaleService();
		clientManageService.getSaleRank(this, getActivity());
	}

	private void initView() {
		dataView = (XListView) mainView.findViewById(R.id.callListView);
		waitView = (ProgressBar) mainView.findViewById(R.id.login_processbar);
		noDataView = mainView.findViewById(R.id.nodata_view);
		dataView.setPullLoadEnable(false);
		dataView.setXListViewListener(this);
		waitView.setVisibility(View.VISIBLE);
	}

	@Override
	public void onRefresh() {
		clientManageService.getSaleRank(this, getActivity());
	}

	@Override
	public void onLoadMore() {
	}
}
