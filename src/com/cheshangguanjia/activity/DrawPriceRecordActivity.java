package com.cheshangguanjia.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cheshangguanjia.adapter.DrawPriceAdapter;
import com.cheshangguanjia.view.XListView;
import com.university.cheshangguanjia.R;

public class DrawPriceRecordActivity extends Activity implements OnClickListener, OnItemClickListener {
	
	private ImageButton backView;
	private EditText searchTextView;
	private Button clearTextView;
	private View searchLogoView;
	private View noDataView;
	private XListView dataView;
	private ProgressBar waitView;
	private TextView nameView;
	private ImageView iconView;
	private DrawPriceAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draw_price_record_activity);
		initView();
	}

	private void initView() {
		backView=(ImageButton) findViewById(R.id.goback);
		searchTextView=(EditText) findViewById(R.id.editTextsearch);
		searchLogoView=findViewById(R.id.search_view);
		clearTextView=(Button) findViewById(R.id.btn_clear);
		noDataView=findViewById(R.id.reply_item_empty);
		dataView=(XListView) findViewById(R.id.winnerlistview);
		waitView=(ProgressBar) findViewById(R.id.login_processbar);
		nameView=(TextView) findViewById(R.id.winnername);
		iconView=(ImageView) findViewById(R.id.winnerprice);
		
		backView.setOnClickListener(this);
		clearTextView.setOnClickListener(this);
		noDataView.setVisibility(View.GONE);
		dataView.setVisibility(View.VISIBLE);
		nameView.setText("孔先生");
		
		adapter=new DrawPriceAdapter(this);
		dataView.setAdapter(adapter);
		dataView.setOnItemClickListener(this);
		dataView.setPullLoadEnable(false);
		dataView.setPullRefreshEnable(false);
		
		searchTextView.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				System.out.println(start + " "+before+" "+count);
				if(start>0||count>0){
					clearTextView.setVisibility(View.VISIBLE);
					searchLogoView.setVisibility(View.GONE);
				}else{
					searchLogoView.setVisibility(View.VISIBLE);
					clearTextView.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.btn_clear:
			searchTextView.setText("");
			break;
		default:
			break;
		}
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent=new Intent(this,PriceDetailActivity.class);
		startActivity(intent);
	}
}
