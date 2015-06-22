package com.cheshangguanjia.activity;

import com.cheshangguanjia.adapter.DccSelectAdapter;
import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;

public class SelectDccActivity extends Activity implements OnClickListener {
	
	private ImageButton backView;
	private ListView dataView;
	private ProgressBar waitView;
	private View noDataView;
	private DccSelectAdapter adapter;
	private AlertDialog dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dcc_select);
		
		initView();
	}

	private void initView() {
		backView=(ImageButton) findViewById(R.id.goback);
		dataView=(ListView) findViewById(R.id.salereport_item_listview);
		waitView=(ProgressBar) findViewById(R.id.login_processbar);
		noDataView=findViewById(R.id.nodata_view);
		
		backView.setOnClickListener(this);
		
		adapter=new DccSelectAdapter(this);
		dataView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			//finish();
			break;

		default:
			break;
		}
	}
}
