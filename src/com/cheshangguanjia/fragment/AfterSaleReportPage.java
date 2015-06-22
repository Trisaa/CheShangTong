package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.university.cheshangguanjia.R;

public class AfterSaleReportPage extends Fragment implements OnClickListener {

	private View mainView;
	private ViewPager pager;
	private ImageView nextView;
	private ImageView prevView;
	private MyPagerAdapter adapter;
	private int currentPage = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.manager_salereport_page, null);
		initView();
		return mainView;
	}

	private void initView() {
		pager = (ViewPager) mainView.findViewById(R.id.salereport_viewpager);
		nextView = (ImageView) mainView.findViewById(R.id.sale_right_arrow);
		prevView = (ImageView) mainView.findViewById(R.id.sale_left_arrow);
		nextView.setOnClickListener(this);
		prevView.setOnClickListener(this);

		FragmentManager manager = getChildFragmentManager();
		adapter = new MyPagerAdapter(manager);
		pager.setAdapter(adapter);
		pager.setOnPageChangeListener(new MyPageChangeListener());
	}

	class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public android.support.v4.app.Fragment getItem(int arg0) {
			return new AfterSaleReportFragment();
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			AfterSaleReportFragment fragment = (AfterSaleReportFragment) super
					.instantiateItem(container, position);
			//更新数据
			return fragment;
		}

		@Override
		public int getCount() {
			return 10;
		}

		@Override
		public int getItemPosition(Object object) {
			return POSITION_NONE;
		}
	}

	class MyPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int arg0) {
			currentPage = arg0;
			if (arg0 == 0) {
				prevView.setImageResource(R.drawable.left_unarrow);
				prevView.setClickable(false);
			} else if (arg0 == 9) {
				nextView.setImageResource(R.drawable.right_unarrow);
				nextView.setClickable(false);
			} else if (arg0 == 1) {
				prevView.setImageResource(R.drawable.left_arrow);
				prevView.setClickable(true);
			} else if (arg0 == 8) {
				nextView.setImageResource(R.drawable.right_arrow);
				nextView.setClickable(true);
			}
		}

	}

	@Override
	public void onClick(View v) {
		System.out.println(currentPage + " currentPage");
		switch (v.getId()) {
		case R.id.sale_left_arrow:
			pager.setCurrentItem(currentPage - 1);
			break;
		case R.id.sale_right_arrow:
			pager.setCurrentItem(currentPage + 1);
			break;
		default:
			break;
		}
	}
}
