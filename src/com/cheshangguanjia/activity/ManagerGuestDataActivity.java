package com.cheshangguanjia.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class ManagerGuestDataActivity extends Activity implements OnClickListener {

	private ImageButton backView;
	private TextView titleView;
	private Button editDataView;
	private ImageView iconView;
	private TextView nameView, dataView, rankView;
	private TextView recordNumView;
	private TextView nameOneView, recordOneView, timeOneView;
	private TextView nameTwoView, recordTwoView, timeTwoView;
	private TextView nameThreeView, recordThreeView, timeThreeView;
	private View contentOneView, contentTwoView,contentThree;
	private TextView preferCarView, askPriceView, testCarView, serviceCommentView, drawPriceView;
	private View allRecordView, askPriceContentView, testCarContentView, serviceCommentContentView, drawPriceContentView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manager_guestdata_activity);
		
		initView();
	}


	private void initView() {
		backView=(ImageButton) findViewById(R.id.goback);
		editDataView=(Button) findViewById(R.id.addbutton);
		titleView=(TextView) findViewById(R.id.teamname);
		iconView=(ImageView) findViewById(R.id.peopleicon);
		nameView=(TextView) findViewById(R.id.guestname);
		dataView=(TextView) findViewById(R.id.guestcity);
		rankView=(TextView) findViewById(R.id.editphone);
		recordNumView=(TextView) findViewById(R.id.guestbeizhu);
		nameOneView=(TextView) findViewById(R.id.nameone);
		recordOneView=(TextView) findViewById(R.id.contentone);
		timeOneView=(TextView) findViewById(R.id.timeone);
		nameTwoView=(TextView) findViewById(R.id.nametwo);
		recordTwoView=(TextView) findViewById(R.id.contenttwo);
		timeTwoView=(TextView) findViewById(R.id.timetwo);
		nameThreeView=(TextView) findViewById(R.id.namethree);
		recordThreeView=(TextView) findViewById(R.id.contentthree);
		timeThreeView=(TextView) findViewById(R.id.timethree);
		contentOneView=findViewById(R.id.guestbeizhu_one);
		contentTwoView=findViewById(R.id.guestbeizhu_two);
		contentThree=findViewById(R.id.guestbeizhu_three);
		preferCarView=(TextView) findViewById(R.id.guestcarstyle);
		askPriceView=(TextView) findViewById(R.id.gcxjtime);
		serviceCommentView=(TextView) findViewById(R.id.fwdptime);
		testCarView=(TextView) findViewById(R.id.sjyytime);
		drawPriceView=(TextView) findViewById(R.id.guestyouhui);
		allRecordView=findViewById(R.id.beizhu_ll);
		askPriceContentView=findViewById(R.id.gcxjlayout);
		testCarContentView=findViewById(R.id.sjyy_ll);
		serviceCommentContentView=findViewById(R.id.fwdp_ll);
		drawPriceContentView=findViewById(R.id.guestyouhui_ll);
		
		iconView.setImageResource(R.drawable.default_headericon);
		nameView.setText("吕振臣");
		dataView.setText("04-18 17:42 微信");
		rankView.setText("C级");
		recordNumView.setText("1条");
		contentOneView.setVisibility(View.VISIBLE);
		nameOneView.setText("");
		recordOneView.setText("客户从微信自行注册为潜客");
		timeOneView.setText("2015-04-18");
		preferCarView.setText("兰德酷泽 2012款 4.6L 自动VX-R");
		askPriceView.setText("0次");
		testCarView.setText("0次");
		serviceCommentView.setText("1次");
		drawPriceView.setText("无");
		
		backView.setOnClickListener(this);
		editDataView.setOnClickListener(this);
		allRecordView.setOnClickListener(this);
		askPriceContentView.setOnClickListener(this);
		serviceCommentContentView.setOnClickListener(this);
		testCarContentView.setOnClickListener(this);
		drawPriceContentView.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.addbutton:
			startActivity(new Intent(this, ManagerGuestBasicActivity.class));
			break;
		case R.id.beizhu_ll:
			startActivity(new Intent(this, FollowUPRecordActivity.class));
			break;
			//购车询价点击事件
		case R.id.gcxjlayout:
			startActivity(new Intent(this, AskPriceActivity.class));
			break;
			//试驾预约点击事件
		case R.id.sjyy_ll:
			startActivity(new Intent(this, TestCarActivity.class));
			break;
			//服务点评点击事件
		case R.id.fwdp_ll:
			Intent intent1=new Intent(this,ManagerCommentActivity.class);
			intent1.putExtra("isService", true);
			startActivity(intent1);
			break;
			//中将记录点击事件
		case R.id.guestyouhui_ll:
			startActivity(new Intent(this,DrawPriceRecordActivity.class));
			break;
		default:
			break;
		}
	}
}
