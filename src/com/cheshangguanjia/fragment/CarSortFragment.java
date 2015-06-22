package com.cheshangguanjia.fragment;

import java.util.List;
import java.util.Map;

import android.R.id;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cheshangguanjia.adapter.CarSortAdapter;
import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.cheshangguanjia.service.SaleService;
import com.cheshangguanjia.service.OnQueryCompleteListener;
import com.cheshangguanjia.service.QueryId;
import com.cheshangguanjia.view.XListView;
import com.cheshangguanjia.view.XListView.IXListViewListener;
import com.university.cheshangguanjia.R;

public class CarSortFragment extends Fragment implements
		OnQueryCompleteListener, IXListViewListener {

	private View mainView;
	private XListView dataView;
	private ProgressBar waitView;
	private View noDataView;
	private CarSortAdapter adapter;
	private SaleService clientManageService;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.car_sort_fragment, null);

		initView();

		initData();

		return mainView;
	}

	private void initData() {
		clientManageService = new SaleService();
		clientManageService.getSeriesRank(this, getActivity());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onQueryComplete(QueryId queryId, Object result, EHttpError error) {
		waitView.setVisibility(View.GONE);
		dataView.stopRefresh();
		if (result != null) {
			Map<String, Object> data = (Map<String, Object>) result;
			List<Map<String, Object>> series = (List<Map<String, Object>>) data
					.get("series");
			if (series.size() != 0) {
				noDataView.setVisibility(View.GONE);
				adapter = new CarSortAdapter(getActivity(), series);
				dataView.setAdapter(adapter);
			} else {
				noDataView.setVisibility(View.VISIBLE);
			}
		}
	}

	private void initView() {
		dataView = (XListView) mainView.findViewById(R.id.callListView);
		waitView = (ProgressBar) mainView.findViewById(R.id.login_processbar);
		noDataView = mainView.findViewById(R.id.nodata_view);

		dataView.setPullLoadEnable(false);
		waitView.setVisibility(View.VISIBLE);
		dataView.setXListViewListener(this);
	}

	@Override
	public void onRefresh() {
		clientManageService.getSeriesRank(this, getActivity());
	}

	@Override
	public void onLoadMore() {
	}
}
