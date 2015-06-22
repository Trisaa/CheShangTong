package com.cheshangguanjia.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.university.cheshangguanjia.R;

public class WelcomeActivity extends Activity {

//	private SharedPreferences preference;
	// 保存角色对应的序号
	public static int role;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());  
		setContentView(R.layout.activity_splash);
		// 完善之后，客户角色保存在preference中，现在模拟数据，直接给role赋值
		// preference = getSharedPreferences("role", Context.MODE_PRIVATE);
		// role=preference.getInt("role", 0);
		role = 0;
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				switch (role) {
				// 总经理
				case 0:
					startActivity(new Intent(WelcomeActivity.this,ManagerHomeActivity.class));
					break;
				// 服务经理
				case 1:
					startActivity(new Intent(WelcomeActivity.this,
							AfterSaleManagerHomeActivity.class));
					break;
				// 销售经理
				case 2:
					startActivity(new Intent(WelcomeActivity.this,
							SaleManagerHomeActivity.class));
					break;
				// 客户经理
				case 3:
					break;
				// 销售员
				case 4:
					startActivity(new Intent(WelcomeActivity.this,
							SalerHomeActivity.class));
					break;
				// 服务顾问
				case 5:
					startActivity(new Intent(WelcomeActivity.this,
							ServiceGuwenHomeActivity.class));
					break;
				// 保险
				case 6:
					startActivity(new Intent(WelcomeActivity.this, BaoxianHomeActivity.class));
					break;
				// 救援
				case 7:
					startActivity(new Intent(WelcomeActivity.this, RescureHomeActivity.class));
					break;
				// 客服
				case 8:
					startActivity(new Intent(WelcomeActivity.this, KeFuHomeActivity.class));
					break;
				default:
					break;
				}
				WelcomeActivity.this.finish();
			}
		}, 1000);
	}
}
