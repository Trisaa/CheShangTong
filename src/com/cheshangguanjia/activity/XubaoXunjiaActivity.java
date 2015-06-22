package com.cheshangguanjia.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.cheshangguanjia.adapter.BaoxianHomeAdapter;
import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

public class XubaoXunjiaActivity extends Activity implements OnClickListener {
	
	private View backView;
	private View showPopView;
	private View noDataView;
	private XListView dataView;
	private ProgressBar waitView;
	private View contentView;
	private PopupWindow popupWindow;
	private BaoxianHomeAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xubao_xunjia);
		
		initView();
	}
	
	private void initView(){
		backView=findViewById(R.id.reply_back);
		showPopView=findViewById(R.id.xiaoshou_top_selection_type);
		noDataView=findViewById(R.id.nodata_view);
		dataView=(XListView) findViewById(R.id.callListView);
		waitView=(ProgressBar) findViewById(R.id.login_processbar);
		
		contentView=getLayoutInflater().inflate(R.layout.xubao_xunjia_pop, null);
		popupWindow=new PopupWindow(contentView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		popupWindow.setFocusable(true);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		
		backView.setOnClickListener(this);
		showPopView.setOnClickListener(this);
		
		adapter=new BaoxianHomeAdapter(this);
		dataView.setAdapter(adapter);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.reply_back:
			finish();
			break;
		case R.id.xiaoshou_top_selection_type:
			popupWindow.showAsDropDown(showPopView);
			break;
		default:
			break;
		}
	}
}
