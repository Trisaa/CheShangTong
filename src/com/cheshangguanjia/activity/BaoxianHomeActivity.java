package com.cheshangguanjia.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.cheshangguanjia.fragment.BaoxianHomeFragment;
import com.cheshangguanjia.fragment.BaoxianKehuFragment;
import com.cheshangguanjia.fragment.ManagerMoreFragment;
import com.university.cheshangguanjia.R;

public class BaoxianHomeActivity extends FragmentActivity implements
		OnClickListener {

	private ImageButton xujiaView, kehuView, moreView;
	private FragmentManager manager;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.baoxian_home_activity);

		initView();
	}

	private void initView() {
		xujiaView = (ImageButton) findViewById(R.id.buttom_index);
		kehuView = (ImageButton) findViewById(R.id.buttom_customer);
		moreView = (ImageButton) findViewById(R.id.buttom_setting);

		xujiaView.setOnClickListener(this);
		kehuView.setOnClickListener(this);
		moreView.setOnClickListener(this);

		manager = getSupportFragmentManager();
		xujiaView.setImageResource(R.drawable.skin_tab_icon_xubao_selected);
		Fragment homeFragment = manager.findFragmentByTag("baoxianhome");
		if (homeFragment == null) {
			homeFragment = new BaoxianHomeFragment();
			manager.beginTransaction()
					.replace(R.id.fl_content, homeFragment, "baoxianhome")
					.commit();
		} else {
			if (!homeFragment.isAdded()) {
				manager.beginTransaction()
						.replace(R.id.fl_content, homeFragment, "baoxianhome")
						.commit();
			}
		}
	}

	@Override
	public void onClick(View v) {
		resetButton();
		switch (v.getId()) {
		case R.id.buttom_index:
			xujiaView.setImageResource(R.drawable.skin_tab_icon_xubao_selected);
			Fragment homeFragment = manager.findFragmentByTag("baoxianhome");
			if (homeFragment == null) {
				homeFragment = new BaoxianHomeFragment();
			} else {
				if (homeFragment.isAdded()) {
					break;
				}
			}
			manager.beginTransaction()
					.replace(R.id.fl_content, homeFragment, "baoxianhome")
					.commit();
			break;
		case R.id.buttom_customer:
			kehuView.setImageResource(R.drawable.skin_tab_icon_customer_selected);
			Fragment kehuFragment = manager.findFragmentByTag("baoxiankehu");
			if (kehuFragment == null) {
				kehuFragment = new BaoxianKehuFragment();
			} else {
				if (kehuFragment.isAdded()) {
					break;
				}
			}
			manager.beginTransaction()
					.replace(R.id.fl_content, kehuFragment, "baoxiankehu")
					.commit();
			break;
		case R.id.buttom_setting:
			moreView.setImageResource(R.drawable.skin_tab_icon_setup_selected);
			Fragment moreFragment = manager.findFragmentByTag("baoxianmore");
			if (moreFragment == null) {
				moreFragment = new ManagerMoreFragment();
			} else {
				if (moreFragment.isAdded()) {
					break;
				}
			}
			manager.beginTransaction()
					.replace(R.id.fl_content, moreFragment, "baoxianmore")
					.commit();
			break;
		default:
			break;
		}
	}

	private void resetButton() {
		xujiaView.setImageResource(R.drawable.skin_tab_icon_xubao_normal);
		kehuView.setImageResource(R.drawable.skin_tab_icon_customer_normal);
		moreView.setImageResource(R.drawable.skin_tab_icon_setup_normal);
	}

}
