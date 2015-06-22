package com.cheshangguanjia.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.cheshangguanjia.fragment.CustomerFragment;
import com.cheshangguanjia.fragment.ManagerMoreFragment;
import com.cheshangguanjia.fragment.WeiXinDialogFragment;
import com.cheshangguanjia.fragment.YeWuFragment;
import com.university.cheshangguanjia.R;

public class SalerHomeActivity extends FragmentActivity implements OnClickListener {

	private ImageButton homePage, dialogPage, customerPage, morePage;

	private FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saler_home);
		initView();
	}

	private void initView() {
		// 首页
		homePage = (ImageButton) findViewById(R.id.buttom_index);
		// 对话
		dialogPage = (ImageButton) findViewById(R.id.buttom_customer);
		// 客户
		customerPage = (ImageButton) findViewById(R.id.buttom_sale);
		// 更多
		morePage = (ImageButton) findViewById(R.id.buttom_setting);

		homePage.setOnClickListener(this);
		customerPage.setOnClickListener(this);
		dialogPage.setOnClickListener(this);
		morePage.setOnClickListener(this);

		homePage.setImageResource(R.drawable.skin_tab_icon_yewu_selected);
		manager = getSupportFragmentManager();
		if (manager.findFragmentByTag("homeFragment") == null) {
			Fragment fragment = new YeWuFragment();
			manager.beginTransaction()
					.replace(R.id.fl_content, fragment, "homeFragment")
					.commit();
		} else {
			replaceFragment("homeFragment");
		}
	}

	@Override
	public void onClick(View v) {
		resetButton();
		switch (v.getId()) {
		case R.id.buttom_index:
			homePage.setImageResource(R.drawable.skin_tab_icon_yewu_selected);
			if (manager.findFragmentByTag("homeFragment") == null) {
				Fragment fragment = new YeWuFragment();
				manager.beginTransaction()
						.replace(R.id.fl_content, fragment, "homeFragment")
						.commit();
			} else {
				replaceFragment("homeFragment");
			}
			break;
		case R.id.buttom_customer:
			dialogPage.setImageResource(R.drawable.skin_tab_icon_chat_selected);
			if (manager.findFragmentByTag("dialogFragment") == null) {
				Fragment fragment = new WeiXinDialogFragment();
				manager.beginTransaction()
						.replace(R.id.fl_content, fragment, "dialogFragment")
						.commit();
			} else {
				replaceFragment("dialogFragment");
			}
			break;
		case R.id.buttom_sale:
			customerPage.setImageResource(R.drawable.skin_tab_icon_customer_selected);
			if (manager.findFragmentByTag("customerFragment") == null) {
				Fragment fragment = new CustomerFragment();
				manager.beginTransaction()
						.replace(R.id.fl_content, fragment, "customerFragment")
						.commit();
			} else {
				replaceFragment("customerFragment");
			}
			break;
		case R.id.buttom_setting:
			morePage.setImageResource(R.drawable.skin_tab_icon_setup_selected);
			if (manager.findFragmentByTag("moreFragment") == null) {
				Fragment fragment = new ManagerMoreFragment();
				manager.beginTransaction()
						.replace(R.id.fl_content, fragment, "moreFragment")
						.commit();
			} else {
				replaceFragment("moreFragment");
			}
			break;
		default:
			break;
		}
	}

	private void replaceFragment(String fragmentName) {
		if (!manager.findFragmentByTag(fragmentName).isAdded()) {
			manager.beginTransaction()
					.replace(R.id.fl_content,
							manager.findFragmentByTag(fragmentName),
							fragmentName).commit();
		}
	}
	
	public void toCustomer(){
		resetButton();
		customerPage.setImageResource(R.drawable.skin_tab_icon_customer_selected);
		if (manager.findFragmentByTag("customerFragment") == null) {
			Fragment fragment = new CustomerFragment();
			manager.beginTransaction()
					.replace(R.id.fl_content, fragment, "customerFragment")
					.commit();
		} else {
			replaceFragment("customerFragment");
		}
	}

	private void resetButton() {
		homePage.setImageResource(R.drawable.skin_tab_icon_yewu_normal);
		dialogPage.setImageResource(R.drawable.skin_tab_icon_chat_normal);
		customerPage.setImageResource(R.drawable.skin_tab_icon_customer_normal);
		morePage.setImageResource(R.drawable.skin_tab_icon_setup_normal);
	}

}
