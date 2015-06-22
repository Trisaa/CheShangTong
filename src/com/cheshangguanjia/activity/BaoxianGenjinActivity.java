package com.cheshangguanjia.activity;

import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class BaoxianGenjinActivity extends Activity implements OnClickListener {
	
	private View backView;
	private EditText editText;
	private View addView;
	private XListView dataView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baoxian_genjinjilu);
		
		initView();
	}

	private void initView() {
		backView=findViewById(R.id.goback);
		editText=(EditText) findViewById(R.id.beizhu_et);
		addView=findViewById(R.id.sendbeizhu_btn);
		dataView=(XListView) findViewById(R.id.jilulistView);
		
		backView.setOnClickListener(this);
		addView.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.sendbeizhu_btn:
			break;
		default:
			break;
		}
	}
}
