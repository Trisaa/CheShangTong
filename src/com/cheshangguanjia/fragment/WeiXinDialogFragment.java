package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.cheshangguanjia.adapter.QiankeAdapter;
import com.university.cheshangguanjia.R;

public class WeiXinDialogFragment extends Fragment{
	private EditText search;
	private ListView listView;
	private QiankeAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_wechatdialog, null);
		initView(view);
		return view;
	}
	
	public void initView(View view){
		search = (EditText)view.findViewById(R.id.editTextsearch);
		listView = (ListView)view.findViewById(R.id.wechat_listview);
		adapter = new QiankeAdapter(getActivity());
		listView.setAdapter(adapter);
	}

}
