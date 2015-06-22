package com.cheshangguanjia.activity;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.ProgressBar;

import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

public class AskPriceActivity extends Activity implements OnClickListener {

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
		setContentView(R.layout.ask_price_activity);

		initview();
	}

	@SuppressWarnings("deprecation")
	private void initview() {
		backView = (ImageButton) findViewById(R.id.reply_back);
		showPopView = findViewById(R.id.xiaoshou_top_selection_type);
		dataView = (XListView) findViewById(R.id.callListView);
		noDataView = findViewById(R.id.nodata_view);
		waitView=(ProgressBar) findViewById(R.id.login_processbar);

		backView.setOnClickListener(this);
		showPopView.setOnClickListener(this);
		dataView.setVisibility(View.GONE);
		noDataView.setVisibility(View.VISIBLE);

		popContentView = getLayoutInflater().inflate(R.layout.ask_price_pop,
				null);
		popupWindow = new PopupWindow(popContentView,
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
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
