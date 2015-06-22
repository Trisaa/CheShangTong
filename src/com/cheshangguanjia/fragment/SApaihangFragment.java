package com.cheshangguanjia.fragment;

import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.cheshangguanjia.adapter.SAPaiHangAdapter;
import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.cheshangguanjia.service.AfterSaleService;
import com.cheshangguanjia.service.OnQueryCompleteListener;
import com.cheshangguanjia.service.QueryId;
import com.cheshangguanjia.view.XListView;
import com.cheshangguanjia.view.XListView.IXListViewListener;
import com.university.cheshangguanjia.R;

public class SApaihangFragment extends Fragment implements
		OnQueryCompleteListener, IXListViewListener {
	private XListView xListView;
	private ProgressBar waitView;
	private View noDataView;
	private SAPaiHangAdapter adapter;
	private AfterSaleService afterSaleService;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.manager_aftersale_sa, null);
		initView(view);
		initData();
		return view;
	}

	private void initData() {
		afterSaleService = new AfterSaleService();
		afterSaleService.getSaRank(this, getActivity());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onQueryComplete(QueryId queryId, Object result, EHttpError error) {
		waitView.setVisibility(View.GONE);
		xListView.stopRefresh();
		if (result != null) {
			Map<String, Object> data = (Map<String, Object>) result;
			List<Map<String, Object>> sas = (List<Map<String, Object>>) data
					.get("sas");
			if (sas.size() == 0) {
				noDataView.setVisibility(View.VISIBLE);
				return;
			}
			adapter = new SAPaiHangAdapter(getActivity(), sas);
			xListView.setAdapter(adapter);
		}
	}

	public void initView(View view) {
		xListView = (XListView) view.findViewById(R.id.callListView);
		waitView = (ProgressBar) view.findViewById(R.id.login_processbar);
		noDataView = view.findViewById(R.id.nodata_view);

		waitView.setVisibility(View.VISIBLE);
		xListView.setXListViewListener(this);
		xListView.setPullLoadEnable(false);
	}

	@Override
	public void onRefresh() {
		afterSaleService.getSaRank(this, getActivity());
	}

	@Override
	public void onLoadMore() {
	}

}
