package com.cheshangguanjia.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class BaoxianXubaoxunjiaActivity extends Activity implements OnClickListener {
	
	private View backView;
	private View personView;
	private TextView genjinView;
	private TextView nameView;
	private TextView timeView;
	private TextView carView;
	private TextView carNumView;
	private TextView buyTimeView;
	private TextView jiaoqiangxianView;
	private TextView disanfangView;
	private TextView cheshangView;
	private TextView shunshiView;
	private TextView daoqiangView;
	private TextView poshunView;
	private TextView teyueView;
	private TextView ziranView;
	private TextView newShunshiView;
	private TextView jingshenView;
	private TextView huahenView;
	private TextView fadongjiView;
	private TextView baojiaView;
	private TextView buyStatusView;
	private View genjinBackView, buyStatusBackView;
	private ProgressBar waitView;
	private View baojiaBackView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.baoxian_xubaoxunjia);
		
		initView();
	}

	private void initView() {
		genjinView=(TextView) findViewById(R.id.beizhu_tv);
		nameView=(TextView) findViewById(R.id.name_tv);
		timeView=(TextView) findViewById(R.id.pricetime);
		carView=(TextView) findViewById(R.id.carstyle_tv);
		carNumView=(TextView) findViewById(R.id.chepai_tv);
		buyTimeView=(TextView) findViewById(R.id.buytime_tv);
		jiaoqiangxianView=(TextView) findViewById(R.id.jiaoqiangxiao_tv);
		disanfangView=(TextView) findViewById(R.id.third_tv);
		cheshangView=(TextView) findViewById(R.id.chenyuanxian_tv);
		shunshiView=(TextView) findViewById(R.id.chesun_tv);
		daoqiangView=(TextView) findViewById(R.id.qiangdao_tv);
		poshunView=(TextView) findViewById(R.id.boli_tv);
		teyueView=(TextView) findViewById(R.id.buji_tv);
		ziranView=(TextView) findViewById(R.id.ziran_tv);
		newShunshiView=(TextView) findViewById(R.id.xinzen_tv);
		jingshenView=(TextView) findViewById(R.id.jinshen_tv);
		huahenView=(TextView) findViewById(R.id.huahen_tv);
		fadongjiView=(TextView) findViewById(R.id.fadongji_tv);
		baojiaView=(TextView) findViewById(R.id.weibaojia_tv);
		buyStatusView=(TextView) findViewById(R.id.buy_tv);
		genjinBackView=findViewById(R.id.beizhu_ll);
		buyStatusBackView=findViewById(R.id.buystatus_ll);
		waitView=(ProgressBar) findViewById(R.id.login_processbar);
		backView=findViewById(R.id.goback);
		personView=findViewById(R.id.userpic);
		baojiaBackView=findViewById(R.id.baojia_ll);
		
		baojiaBackView.setVisibility(View.VISIBLE);
		buyStatusBackView.setVisibility(View.VISIBLE);
		
		genjinView.setText("您好，您于2015年05月14日里王杰");
		nameView.setText("郭大莲");
		timeView.setText("05月14日 17:01");
		carView.setText("一汽丰田RAV4");
		carNumView.setText("辽BH908G");
		buyTimeView.setText("2012年07月09日");
		jiaoqiangxianView.setText("是");
		disanfangView.setText("50.00万");
		cheshangView.setText("是");
		shunshiView.setText("是");
		daoqiangView.setText("是");
		poshunView.setText("是");
		teyueView.setText("是");
		ziranView.setText("否");
		newShunshiView.setText("否");
		jingshenView.setText("否");
		huahenView.setText("否");
		fadongjiView.setText("否");
		baojiaView.setText("您好，您于2015年05月14日08：59向我们提交了一条续保询价，我们的价格为交强险855月");
		buyStatusView.setText("设为已购");
		
		genjinBackView.setOnClickListener(this);
		backView.setOnClickListener(this);
		buyStatusBackView.setOnClickListener(this);
		personView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.beizhu_ll:
			startActivity(new Intent(this, BaoxianGenjinActivity.class));
			break;
		case R.id.buystatus_ll:
			startActivity(new Intent(this,BaoxianTouBaoActivity.class));
			break;
		case R.id.goback:
			finish();
			break;
		case R.id.userpic:
			startActivity(new Intent(this, ManagerGuestDataActivity.class));
			break;
		default:
			break;
		}
	}
}
