package com.cheshangguanjia.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.cheshangguanjia.fragment.ManagerAfterSaleFragment;
import com.cheshangguanjia.fragment.ManagerHomeFragment;
import com.cheshangguanjia.fragment.ManagerMoreFragment;
import com.cheshangguanjia.fragment.ManagerSaleFragment;
import com.university.cheshangguanjia.R;

public class ManagerHomeActivity extends FragmentActivity implements OnClickListener {

	private ImageButton homePage, salePage, afterPage, morePage;

	private FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manager_home_activity);

		initView();
	}

	private void initView() {
		// 首页
		homePage = (ImageButton) findViewById(R.id.buttom_index);
		// 销售
		salePage = (ImageButton) findViewById(R.id.buttom_sale);
		// 售后
		afterPage = (ImageButton) findViewById(R.id.buttom_aftersale);
		// 更多
		morePage = (ImageButton) findViewById(R.id.buttom_setting);

		homePage.setOnClickListener(this);
		salePage.setOnClickListener(this);
		afterPage.setOnClickListener(this);
		morePage.setOnClickListener(this);

		homePage.setImageResource(R.drawable.skin_tab_icon_index_selected);
		manager = getSupportFragmentManager();
		if (manager.findFragmentByTag("homeFragment") == null) {
			Fragment fragment = new ManagerHomeFragment();
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
				Fragment fragment = new ManagerHomeFragment();
				manager.beginTransaction()
						.replace(R.id.fl_content, fragment, "homeFragment")
						.commit();
			} else {
				replaceFragment("homeFragment");
			}
			break;
		case R.id.buttom_sale:
			salePage.setImageResource(R.drawable.skin_tab_icon_sale_selected);
			if (manager.findFragmentByTag("saleFragment") == null) {
				Fragment fragment = new ManagerSaleFragment("manager");
				manager.beginTransaction()
						.replace(R.id.fl_content, fragment, "saleFragment")
						.commit();
			} else {
				replaceFragment("saleFragment");
			}
			break;
		case R.id.buttom_aftersale:
			afterPage.setImageResource(R.drawable.skin_tab_icon_aftersale_selected);
			if (manager.findFragmentByTag("afterFragment") == null) {
				Fragment fragment = new ManagerAfterSaleFragment();
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
		salePage.setImageResource(R.drawable.skin_tab_icon_sale_normal);
		afterPage.setImageResource(R.drawable.skin_tab_icon_aftersale_normal);
		morePage.setImageResource(R.drawable.skin_tab_icon_setup_normal);
	}

}
