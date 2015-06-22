package com.cheshangguanjia.activity;

import com.cheshangguanjia.adapter.FollowUpRecordAdapter;
import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;

public class FollowUPRecordActivity extends Activity implements OnClickListener {
	
	private ImageButton backView;
	private ListView dataView;
	private FollowUpRecordAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.follow_up_record_activity);
		
		initView();
	}

	private void initView() {
		backView=(ImageButton) findViewById(R.id.goback);
		dataView=(ListView) findViewById(R.id.jilulistView);
		
		backView.setOnClickListener(this);
		
		adapter=new FollowUpRecordAdapter(this);
		dataView.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;

		default:
			break;
		}
	}
}
