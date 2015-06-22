package com.cheshangguanjia.activity;

import android.R.string;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.cheshangguanjia.fragment.ManagerMoreFragment;
import com.cheshangguanjia.fragment.RescueCommentFragment;
import com.cheshangguanjia.fragment.RescueHomeFragment;
import com.university.cheshangguanjia.R;

public class RescureHomeActivity extends FragmentActivity implements
		OnClickListener {

	private ImageButton rescueView, commentView, moreView;
	private FragmentManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rescue_home_activity);
		initView();
	}

	private void initView() {
		rescueView = (ImageButton) findViewById(R.id.buttom_index);
		commentView = (ImageButton) findViewById(R.id.buttom_customer);
		moreView = (ImageButton) findViewById(R.id.buttom_setting);

		manager = getSupportFragmentManager();

		rescueView.setOnClickListener(this);
		commentView.setOnClickListener(this);
		moreView.setOnClickListener(this);

		rescueView.setImageResource(R.drawable.skin_tab_icon_rescue_selected);
		Fragment fragment = manager.findFragmentByTag("rescuehome");
		if (fragment == null) {
			fragment = new RescueHomeFragment();
			replaceFragment(fragment, "rescuehome");
		} else {
			replaceFragment(fragment, "rescuehome");
		}
	}

	@Override
	public void onClick(View v) {
		resetButton();
		switch (v.getId()) {
		case R.id.buttom_index:
			rescueView
					.setImageResource(R.drawable.skin_tab_icon_rescue_selected);
			Fragment fragment = manager.findFragmentByTag("rescuehome");
			if (fragment == null) {
				fragment = new RescueHomeFragment();
				replaceFragment(fragment, "rescuehome");
			} else {
				replaceFragment(fragment, "rescuehome");
			}
			break;
		case R.id.buttom_customer:
			commentView
					.setImageResource(R.drawable.skin_tab_icon_comment_selected);
			Fragment commentFragment = manager.findFragmentByTag("rescuecomment");
			if (commentFragment == null) {
				commentFragment = new RescueCommentFragment();
				replaceFragment(commentFragment, "rescuecomment");
			} else {
				replaceFragment(commentFragment, "rescuecomment");
			}
			break;
		case R.id.buttom_setting:
			moreView.setImageResource(R.drawable.skin_tab_icon_setup_selected);
			Fragment moreFragment = manager.findFragmentByTag("rescuemore");
			if (moreFragment == null) {
				moreFragment = new ManagerMoreFragment();
				replaceFragment(moreFragment, "rescuemore");
			} else {
				replaceFragment(moreFragment, "rescuemore");
			}
			break;
		default:
			break;
		}
	}

	private void resetButton() {
		rescueView.setImageResource(R.drawable.skin_tab_icon_rescue_normal);
		commentView.setImageResource(R.drawable.skin_tab_icon_comment_normal);
		moreView.setImageResource(R.drawable.skin_tab_icon_setup_normal);
	}
	
	private void replaceFragment(Fragment fragment,String tag){
		manager.beginTransaction().replace(R.id.fl_content, fragment,tag).commit();
	}
}
