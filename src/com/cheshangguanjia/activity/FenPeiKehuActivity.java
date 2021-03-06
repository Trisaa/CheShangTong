package com.cheshangguanjia.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

import com.cheshangguanjia.adapter.FenPeiAdapter;
import com.university.cheshangguanjia.R;

public class FenPeiKehuActivity extends Activity implements OnClickListener{
	private ImageButton backButton;
	private ListView listView;
	private FenPeiAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fenpeikehu);
		initView();
	}
	
	public void initView(){
		backButton = (ImageButton)findViewById(R.id.goback);
		listView = (ListView)findViewById(R.id.qianke_list);
		
		adapter = new FenPeiAdapter(this);
		listView.setAdapter(adapter);
		backButton.setOnClickListener(this);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FenPeiKehuActivity.this,CustomerDetailActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.goback:
			finish();
			break;

		default:
			break;
		}
	}
}
