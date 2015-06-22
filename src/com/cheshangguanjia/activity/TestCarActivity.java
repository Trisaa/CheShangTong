package com.cheshangguanjia.activity;

import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

import android.R.integer;
import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

public class TestCarActivity extends Activity implements OnClickListener{
	
	private ImageButton backView;
	private View showPopView;
	private XListView dataView;
	private View noDataView;
	private View popContentView;
	private PopupWindow popupWindow;
	private ProgressBar waitView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_car_activity);
		
		initView();
	}

	@SuppressWarnings("deprecation")
	private void initView() {
		backView=(ImageButton) findViewById(R.id.reply_back);
		showPopView=findViewById(R.id.xiaoshou_top_selection_type);
		dataView=(XListView) findViewById(R.id.callListView);
		noDataView=findViewById(R.id.nodata_view);
		waitView=(ProgressBar) findViewById(R.id.login_processbar);
		
		backView.setOnClickListener(this);
		showPopView.setOnClickListener(this);
		dataView.setVisibility(View.GONE);
		noDataView.setVisibility(View.VISIBLE);
		
		popContentView=getLayoutInflater().inflate(R.layout.test_car_pop, null);
		popupWindow=new PopupWindow(popContentView,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		popupWindow.setFocusable(true);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
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
