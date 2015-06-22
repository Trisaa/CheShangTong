package com.cheshangguanjia.activity;

import com.cheshangguanjia.adapter.PriceDetailAdapter;
import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class PriceDetailActivity extends Activity implements OnClickListener{
	
	private ImageButton backView;
	private TextView titleView;
	private XListView dataView;
	private PriceDetailAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_title_list_view);
		
		initView();
	}

	private void initView() {
		backView=(ImageButton) findViewById(R.id.goback);
		titleView=(TextView) findViewById(R.id.titlename);
		dataView=(XListView) findViewById(R.id.common_list);
		titleView.setText("孔先生的奖品");
		
		adapter=new PriceDetailAdapter(this);
		dataView.setAdapter(adapter);
		dataView.setPullRefreshEnable(false);
		dataView.setPullLoadEnable(false);
		backView.setOnClickListener(this);
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
