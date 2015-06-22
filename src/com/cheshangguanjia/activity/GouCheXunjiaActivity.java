package com.cheshangguanjia.activity;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cheshangguanjia.adapter.GouCheXunjiaAdapter;
import com.university.cheshangguanjia.R;

public class GouCheXunjiaActivity extends Activity implements OnClickListener{
	private ImageButton backButton;
	private ListView listView;
	private PopupWindow popupWindow;
	private View contentView,showpopView;
	private TextView sumView,titleView;
	private GouCheXunjiaAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gouchexunjia);
		initView();
	}
	
	public void initView(){
		backButton = (ImageButton)findViewById(R.id.goback);
		listView = (ListView)findViewById(R.id.qianke_list);
		sumView = (TextView)findViewById(R.id.sum_txt);
		titleView = (TextView)findViewById(R.id.name_tv);
		if(WelcomeActivity.role == 5||WelcomeActivity.role == 8){
			if(getIntent().getStringExtra("from").equals("daichuliyuyue"))
				titleView.setText("养修预约");
			else if(getIntent().getStringExtra("from").equals("fuwudianping")){
				titleView.setText("服务点评");
			}
			else if(getIntent().getStringExtra("from").equals("xubaoxunjia")){
				titleView.setText("续保询价");
			}
			else if(getIntent().getStringExtra("from").equals("jinjijiuyuan")){
				titleView.setText("紧急救援");
			}
		}
		showpopView =  findViewById(R.id.xiaoshou_top_selection_type);
		contentView = getLayoutInflater().inflate(R.layout.gouchexunjia_pop,
				null);
		popupWindow = new PopupWindow(contentView, LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		popupWindow.setFocusable(true);
		popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		
		adapter = new GouCheXunjiaAdapter(this,"购车询价");
		listView.setAdapter(adapter);
		backButton.setOnClickListener(this);
		showpopView.setOnClickListener(this);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(GouCheXunjiaActivity.this,GouCheXunJiaDetail.class);
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
		case R.id.xiaoshou_top_selection_type:
			popupWindow.showAsDropDown(showpopView);
			break;
		default:
			break;
		}
	}
}
