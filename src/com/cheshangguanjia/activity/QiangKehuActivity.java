package com.cheshangguanjia.activity;

import com.cheshangguanjia.adapter.QiangKehuAdapter;
import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class QiangKehuActivity extends Activity{
	private ImageButton backButton;
	private ListView listView;
	private QiangKehuAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qiangkehu);
		initView();
	}
	
	public void initView(){
		backButton = (ImageButton)findViewById(R.id.goback);
		listView = (ListView)findViewById(R.id.customer_listview);
		adapter = new QiangKehuAdapter(this);
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
