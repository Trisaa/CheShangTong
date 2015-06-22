package com.cheshangguanjia.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.cheshangguanjia.utils.MeasureUtils;
import com.university.cheshangguanjia.R;

public class BaoxianHomeFragment extends Fragment implements
		OnCheckedChangeListener {

	private View mainView;
	private RadioGroup group;
	private ViewPager viewPager;
	private ImageView indicatorView;
	private int tabWidth;
	private int indicatorWidth;
	private boolean isFirst = true;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.baoxian_home_fragment, null);
		initView();
		return mainView;
	}

	private void initView() {
		group = (RadioGroup) mainView
				.findViewById(R.id.salepriceenquiry_radiogroup);
		viewPager = (ViewPager) mainView.findViewById(R.id.reply_viewpager);
		indicatorView = (ImageView) mainView.findViewById(R.id.tab_top_select);

		group.setOnCheckedChangeListener(this);
		viewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));

		tabWidth = MeasureUtils.getScreenWidth(getActivity()) / 8;
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				ObjectAnimator animator = ObjectAnimator.ofFloat(indicatorView,
						"x", tabWidth * (arg0 * 2 + 1) - indicatorWidth);
				animator.setDuration(200);
				animator.start();
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});

		indicatorView.getViewTreeObserver().addOnGlobalLayoutListener(
				new OnGlobalLayoutListener() {
					@Override
					public void onGlobalLayout() {
						if (isFirst) {
							indicatorWidth = indicatorView.getWidth() / 2;
							indicatorView.setX(tabWidth);
							isFirst = !isFirst;
						}
					}
				});

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.notfix:
			viewPager.setCurrentItem(0);
			break;
		case R.id.hadsure:
			viewPager.setCurrentItem(1);
			break;
		case R.id.hadbuy:
			viewPager.setCurrentItem(2);
			break;
		case R.id.hadcancel:
			viewPager.setCurrentItem(3);
			break;
		default:
			break;
		}
	}

	class MyPagerAdapter extends FragmentPagerAdapter {
		
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			return new BaoxianHomePageItem();
		}

		@Override
		public int getCount() {
			return 4;
		}
			
	}
}
