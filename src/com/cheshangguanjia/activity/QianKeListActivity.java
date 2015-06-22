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
import android.widget.TextView;

import com.cheshangguanjia.adapter.QiankeAdapter;
import com.university.cheshangguanjia.R;

public class QianKeListActivity extends Activity implements OnClickListener{
	private ImageButton backButton;
	private ListView listView;
	private TextView sumTextView,titleTextView;
	private QiankeAdapter adapter;
	private String from;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qiankelist);
		initView();
	}
	
	public void initView(){
		from = getIntent().getStringExtra("from");
		backButton = (ImageButton)findViewById(R.id.goback);
		listView = (ListView)findViewById(R.id.qianke_list);
		sumTextView = (TextView)findViewById(R.id.sum_txt);
		titleTextView = (TextView)findViewById(R.id.name_tv);
		
		if(from.equals("qianzaikehu")){
			sumTextView.setText("潜在客户12人");
			titleTextView.setText("潜在客户");
		}
		else if(from.equals("Hjikehu")){
			sumTextView.setText("H级客户12人");
			titleTextView.setText("H级客户");
		}
		
		adapter = new QiankeAdapter(this);
		listView.setAdapter(adapter);
		backButton.setOnClickListener(this);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(QianKeListActivity.this,CustomerDetailActivity.class);
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
