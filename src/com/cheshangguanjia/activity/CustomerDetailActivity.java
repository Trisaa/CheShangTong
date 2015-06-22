package com.cheshangguanjia.activity;

import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomerDetailActivity extends Activity implements OnClickListener{
	private ImageView imageView;
	private ImageButton backButton;
	private TextView nameView,editView,timeView,genjinjilu,xiacihuifang,yixiangchekuan,kehudengji,
					gouchezhuangtai,gouchexunjia,shijiayuyue,fuwudianping,zhongjiangjilu;
	private LinearLayout wechat,call;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customer_detail);
		initView();
	}
	public void initView(){
		imageView = (ImageView)findViewById(R.id.peopleicon);
		backButton = (ImageButton)findViewById(R.id.goback);
		editView = (TextView)findViewById(R.id.guestphone);
		nameView = (TextView)findViewById(R.id.guestname);
		timeView = (TextView)findViewById(R.id.guestcity);
		genjinjilu = (TextView)findViewById(R.id.guestbeizhu);
		xiacihuifang = (TextView)findViewById(R.id.revisittime);
		yixiangchekuan = (TextView)findViewById(R.id.guestcarstyle);
		kehudengji = (TextView)findViewById(R.id.guestlevel);
		gouchezhuangtai = (TextView)findViewById(R.id.guestcarstatus);
		gouchexunjia = (TextView)findViewById(R.id.gcxjtime);
		shijiayuyue = (TextView)findViewById(R.id.sjyytime);
		fuwudianping = (TextView)findViewById(R.id.fwdptime);
		zhongjiangjilu = (TextView)findViewById(R.id.guestyouhui);
		wechat = (LinearLayout)findViewById(R.id.fanslayout);
		call = (LinearLayout)findViewById(R.id.guestlayout);
		
		backButton.setOnClickListener(this);
		genjinjilu.setOnClickListener(this);
		editView.setOnClickListener(this);
		wechat.setOnClickListener(this);
		call.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.guestbeizhu:
			
			break;
		case R.id.fanslayout:
					
			break;
		case R.id.guestlayout:
			
			break;

		default:
			break;
		}
	}
	

}
