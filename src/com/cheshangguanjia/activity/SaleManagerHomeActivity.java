package com.cheshangguanjia.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.cheshangguanjia.fragment.AfterSaleDayReportFragment;
import com.cheshangguanjia.fragment.ManagerMoreFragment;
import com.cheshangguanjia.fragment.ManagerSaleFragment;
import com.cheshangguanjia.fragment.SaleManagerHomeFragment;
import com.university.cheshangguanjia.R;

public class SaleManagerHomeActivity extends FragmentActivity implements OnClickListener {

	private ImageButton homePage, customerPage, excelPage, morePage;

	private FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_salemanager_home);
		initView();
	}

	private void initView() {
		// 首页
		homePage = (ImageButton) findViewById(R.id.buttom_index);
		// 客户
		customerPage = (ImageButton) findViewById(R.id.buttom_customer);
		// 报表
		excelPage = (ImageButton) findViewById(R.id.buttom_aftersale);
		// 更多
		morePage = (ImageButton) findViewById(R.id.buttom_setting);

		homePage.setOnClickListener(this);
		customerPage.setOnClickListener(this);
		excelPage.setOnClickListener(this);
		morePage.setOnClickListener(this);

		homePage.setImageResource(R.drawable.skin_tab_icon_index_selected);
		manager = getSupportFragmentManager();
		if (manager.findFragmentByTag("homeFragment") == null) {
			Fragment fragment = new SaleManagerHomeFragment();
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
			homePage.setImageResource(R.drawable.skin_tab_icon_index_selected);
			if (manager.findFragmentByTag("homeFragment") == null) {
				Fragment fragment = new SaleManagerHomeFragment();
				manager.beginTransaction()
						.replace(R.id.fl_content, fragment, "homeFragment")
						.commit();
			} else {
				replaceFragment("homeFragment");
			}
			break;
		case R.id.buttom_customer:
			customerPage.setImageResource(R.drawable.skin_tab_icon_customer_selected);
			if (manager.findFragmentByTag("customerFragment") == null) {
				Fragment fragment = new ManagerSaleFragment("salemanager");
				manager.beginTransaction()
						.replace(R.id.fl_content, fragment, "customerFragment")
						.commit();
			} else {
				replaceFragment("customerFragment");
			}
			break;
		case R.id.buttom_aftersale:
			excelPage.setImageResource(R.drawable.skin_tab_icon_reporttable_selected);
			if (manager.findFragmentByTag("afterFragment") == null) {
				Fragment fragment = new AfterSaleDayReportFragment();
				manager.beginTransaction()
						.replace(R.id.fl_content, fragment, "afterFragment")
						.commit();
			} else {
				replaceFragment("afterFragment");
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

	private void resetButton() {
		homePage.setImageResource(R.drawable.skin_tab_icon_index_normal);
		customerPage.setImageResource(R.drawable.skin_tab_icon_customer_normal);
		excelPage.setImageResource(R.drawable.skin_tab_icon_reporttable_normal);
		morePage.setImageResource(R.drawable.skin_tab_icon_setup_normal);
	}

}
