package com.cheshangguanjia.fragment;

import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;

import com.cheshangguanjia.activity.GuestRankActivity;
import com.cheshangguanjia.adapter.RankCountAdapter;
import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.cheshangguanjia.service.SaleService;
import com.cheshangguanjia.service.OnQueryCompleteListener;
import com.cheshangguanjia.service.QueryId;
import com.cheshangguanjia.view.XListView;
import com.cheshangguanjia.view.XListView.IXListViewListener;
import com.university.cheshangguanjia.R;

public class RankCountFragment extends Fragment implements OnItemClickListener,
		OnQueryCompleteListener, IXListViewListener{

	private View mainView;
	private XListView dataView;
	private ProgressBar waitView;
	private RankCountAdapter adapter;
	private SaleService clientService;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.rank_count_activity, null);

		initView();

		initData();
		return mainView;
	}

	private void initData() {
		clientService = new SaleService();
		clientService.getClasz(this, getActivity());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onQueryComplete(QueryId queryId, Object result, EHttpError error) {
		waitView.setVisibility(View.GONE);
		dataView.stopRefresh();
		if(result!=null){
			Map<String, Object> data=(Map<String, Object>) result;
			List<Map<String, Object>> stats=(List<Map<String, Object>>) data.get("stats");
			adapter = new RankCountAdapter(getActivity(),stats);
			dataView.setAdapter(adapter);
		}
	}

	private void initView() {
		dataView = (XListView) mainView.findViewById(R.id.callListView);
		waitView = (ProgressBar) mainView.findViewById(R.id.login_processbar);

		dataView.setPullLoadEnable(false);
		dataView.setXListViewListener(this);
		dataView.setOnItemClickListener(this);
		waitView.setVisibility(View.VISIBLE);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(getActivity(), GuestRankActivity.class);
		intent.putExtra("rank", position);
		startActivity(intent);
	}

	@Override
	public void onRefresh() {
		clientService.getClasz(this, getActivity());
	}

	@Override
	public void onLoadMore() {
	}

}
