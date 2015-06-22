package com.cheshangguanjia.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class BaoxianZiliaoActivity extends Activity implements OnClickListener {

	private ImageView iconView;
	private TextView nameView, phoneView, timeView;
	private TextView genjinNumView;
	private View genjinBackView;
	private TextView oneNameView, oneTimeView, oneMessageView;
	private TextView twoNameView, twoTimeView, twoMessageView;
	private TextView threeNameView, threeTimeView, threeMessageView;
	private TextView ziliaoView, nextBaoYangView, nextXubaoView,
			nextNianjianView, nextJiazhaoView, xunjiaView;
	private View ziliaoBackView, baoyangBackView, xubaoBackView,
			nianjianBackView, jiazhaoBackView, xunjiaBackView;
	private View oneView, twoView,threeView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baoxian_kehu_ziliao);
		
		initView();
	}

	private void initView() {
		iconView=(ImageView) findViewById(R.id.peopleicon);
		nameView=(TextView) findViewById(R.id.guestname);
		phoneView=(TextView) findViewById(R.id.guestphone);
		timeView=(TextView) findViewById(R.id.guestcity);
		genjinNumView=(TextView) findViewById(R.id.guestbeizhu);
		oneNameView=(TextView) findViewById(R.id.nameone);
		oneTimeView=(TextView) findViewById(R.id.timeone);
		oneMessageView=(TextView) findViewById(R.id.contentone);
		twoNameView=(TextView) findViewById(R.id.nametwo);
		twoTimeView=(TextView) findViewById(R.id.timetwo);
		twoMessageView=(TextView) findViewById(R.id.contenttwo);
		threeNameView=(TextView) findViewById(R.id.namethree);
		threeTimeView=(TextView) findViewById(R.id.timethree);
		threeMessageView=(TextView) findViewById(R.id.contentthree);
		ziliaoView=(TextView) findViewById(R.id.vinhao);
		ziliaoBackView=findViewById(R.id.onelevel_ll);
		nextBaoYangView=(TextView) findViewById(R.id.baoyangtixing);
		baoyangBackView=findViewById(R.id.baoyangtixing_ll);
		nextXubaoView=(TextView) findViewById(R.id.xubaotixing);
		xubaoBackView=findViewById(R.id.xubaotixing_ll);
		nextNianjianView=(TextView) findViewById(R.id.nianjiantixing);
		nianjianBackView=findViewById(R.id.cheliangnianjiantixing_ll);
		nextJiazhaoView=(TextView) findViewById(R.id.jiazhaonianjian);
		jiazhaoBackView=findViewById(R.id.jiazhaonianjian_ll);
		xunjiaView=(TextView) findViewById(R.id.xubaoxunjia);
		xunjiaBackView=findViewById(R.id.xubaoxunjialayout);
		oneView=findViewById(R.id.guestbeizhu_one);
		twoView=findViewById(R.id.guestbeizhu_two);
		threeView=findViewById(R.id.guestbeizhu_three);
		genjinBackView=findViewById(R.id.beizhu_ll);
		
		nameView.setText("倪东兴(倪东兴)");
		phoneView.setText("13190180149");
		timeView.setText("2015年04月04日 匹配绑定");
		genjinNumView.setText("2条");
		
		oneView.setVisibility(View.VISIBLE);
		oneNameView.setText("金浩");
		oneTimeView.setText("2015-05-12");
		oneMessageView.setText("您好，您于2015年05月12日 12：38向我们");
		twoView.setVisibility(View.VISIBLE);
		twoNameView.setText("李梦楠");
		twoTimeView.setText("2015-04-05");
		twoMessageView.setText("您好，您于2015年04月05日 16：53向我们提出");
		ziliaoView.setText("辽BMY660");
		nextBaoYangView.setText("93天");
		nextXubaoView.setText("312天");
		nextNianjianView.setText("439天");
		xunjiaView.setText("2次");
		
		genjinBackView.setOnClickListener(this);
		ziliaoBackView.setOnClickListener(this);
		xubaoBackView.setOnClickListener(this);
		baoyangBackView.setOnClickListener(this);
		nianjianBackView.setOnClickListener(this);
		jiazhaoBackView.setOnClickListener(this);
		xunjiaBackView.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		//监听为界面依次向下
		switch (v.getId()) {
		case R.id.beizhu_ll:
			startActivity(new Intent(this,BaoxianGenjinActivity.class));
			break;
		case R.id.onelevel_ll:
			startActivity(new Intent(this,CheliangXinxiActivity.class));
			break;
		case R.id.baoyangtixing_ll:
			startActivity(new Intent(this,BaoyangTixingActivity.class));
			break;
		case R.id.xubaotixing_ll:
			startActivity(new Intent(this,XubaoTixingActivity.class));
			break;
		case R.id.cheliangnianjiantixing_ll:
			startActivity(new Intent(this,NianjianTixingActivity.class));
			break;
		case R.id.jiazhaonianjian_ll:
			startActivity(new Intent(this,JIazhaoTixingActivity.class));
			break;
		case R.id.xubaoxunjialayout:
			startActivity(new Intent(this,XubaoXunjiaActivity.class));
			break;
		default:
			break;
		}
	}
}
