package com.cheshangguanjia.activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cheshangguanjia.adapter.ManagerCommentAdapter;
import com.cheshangguanjia.view.XListView;
import com.cheshangguanjia.view.XListView.IXListViewListener;
import com.university.cheshangguanjia.R;

public class ManagerCommentActivity extends Activity implements
		OnClickListener, IXListViewListener {

	private ImageButton backView;
	private TextView titleView;
	private View showPopView;
	private PopupWindow selectionPopupWindow;
	private ProgressBar waitView;
	private View noDataView;
	private XListView dataView;
	private ManagerCommentAdapter commentAdapter;
	private boolean isFromService=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manager_comment_activity);
		
		initView();
	}

	private void initView() {
		backView=(ImageButton) findViewById(R.id.goback);
		titleView=(TextView) findViewById(R.id.name_tv);
		showPopView=findViewById(R.id.xiaoshou_top_selection_type);
		waitView=(ProgressBar) findViewById(R.id.login_processbar);
		noDataView=findViewById(R.id.nodata_view);
		dataView=(XListView) findViewById(R.id.callListView);
		
		isFromService=getIntent().getBooleanExtra("isService", false);
		
		if(getIntent().getBooleanExtra("isAfter", false)){
			titleView.setText("售后点评");
		}
		
		dataView.setXListViewListener(this);
		//设置可以下拉刷新
		dataView.setPullRefreshEnable(true);
		//设置不能加载更多
		dataView.setPullLoadEnable(false);
		backView.setOnClickListener(this);
		showPopView.setOnClickListener(this);
		commentAdapter=new ManagerCommentAdapter(this,isFromService);
		dataView.setAdapter(commentAdapter);
		
		View contentView=getLayoutInflater().inflate(R.layout.comment_selection_pop, null);
		selectionPopupWindow=new PopupWindow(contentView,LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		selectionPopupWindow.setFocusable(true);
		selectionPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.xiaoshou_top_selection_type:
			selectionPopupWindow.showAsDropDown(showPopView);
			break;
		default:
			break;
		}
	}

	//下拉刷新回调接口
	@Override
	public void onRefresh() {
		
	}

	//加载更多回调接口
	@Override
	public void onLoadMore() {
	}

}
