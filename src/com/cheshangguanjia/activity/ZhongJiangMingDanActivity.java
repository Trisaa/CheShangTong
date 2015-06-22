package com.cheshangguanjia.activity;

import com.cheshangguanjia.adapter.ZhongJiangAdapter;
import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class ZhongJiangMingDanActivity extends Activity{
	private ImageButton backButton;
	private  EditText search;
	private ListView listView;
	private ZhongJiangAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zhongjiangmingdan);
		initView();
	}
	
	public void initView(){
		backButton = (ImageButton)findViewById(R.id.goback);
		search = (EditText)findViewById(R.id.editTextsearch);
		listView = (ListView)findViewById(R.id.zhongjiang_listview);
		
		adapter = new ZhongJiangAdapter(this);
		listView.setAdapter(adapter);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	

}
