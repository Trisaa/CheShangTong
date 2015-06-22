package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.cheshangguanjia.adapter.BaoxianKehuAdapter;
import com.university.cheshangguanjia.R;

public class BaoxianKehuFragment extends Fragment implements OnCheckedChangeListener {
	
	private View mainView;
	private EditText editText;
	private View clearView;
	private RadioGroup group;
	private View searchView;
	private ExpandableListView dataView;
	private ProgressBar waiteView;
	private BaoxianKehuAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView=inflater.inflate(R.layout.baoxian_kehu_fragment, null);
		
		initView();
		
		return mainView;
	}

	private void initView() {
		editText=(EditText) mainView.findViewById(R.id.editTextName);
		clearView =mainView.findViewById(R.id.btn_clear);
		group=(RadioGroup) mainView.findViewById(R.id.main_tab_group);
		searchView=mainView.findViewById(R.id.search_view);
		dataView=(ExpandableListView) mainView.findViewById(R.id.salereport_item_listview);
		waiteView=(ProgressBar) mainView.findViewById(R.id.login_processbar);
		
		adapter=new BaoxianKehuAdapter(getActivity());
		dataView.setAdapter(adapter);
		
		group.setOnCheckedChangeListener(this);
		
	}
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.main_tab_all:
			break;
		case R.id.main_tab_xubao:
			break;
		default:
			break;
		}
	}
}
