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

public class ManagerReportFragment extends Fragment implements
		OnClickListener {

	private View mainView;
	private ViewPager viewPager;
	private FragmentManager manager;
	private ImageView nextView, preView;
	private int currentPage=0;
	private int index;
	private FragmentPagerAdapter pageAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.manager_salereport_page, null);

		initView();

		return mainView;
	}

	private void initView() {
		viewPager = (ViewPager) mainView
				.findViewById(R.id.salereport_viewpager);
		preView = (ImageView) mainView.findViewById(R.id.sale_left_arrow);
		nextView = (ImageView) mainView.findViewById(R.id.sale_right_arrow);
		
		manager = getChildFragmentManager();

		preView.setOnClickListener(this);
		nextView.setOnClickListener(this);

		pageAdapter = new MyViewPageAdapter(manager);
		viewPager.setAdapter(pageAdapter);
		viewPager.setOnPageChangeListener(new MyPageChangeListener());
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
			currentPage=arg0;
			if (arg0 == 0) {
				preView.setImageResource(R.drawable.left_unarrow);
				preView.setClickable(false);
			}else if(arg0==9){
				nextView.setImageResource(R.drawable.right_unarrow);
				nextView.setClickable(false);
			}else if(arg0==1){
				preView.setImageResource(R.drawable.left_arrow);
				preView.setClickable(true);
			}else if(arg0==8){
				nextView.setImageResource(R.drawable.right_arrow);
				nextView.setClickable(true);
			}
		}

	}

	class MyViewPageAdapter extends FragmentPagerAdapter {

		public MyViewPageAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public android.support.v4.app.Fragment getItem(int arg0) {
			return new ManagerReportItemFragment();
			
		}

		@Override
		public int getCount() {
			return 10;
		}
		
		@Override
		public int getItemPosition(Object object) {
			return POSITION_NONE;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ManagerReportItemFragment fragment=(ManagerReportItemFragment) super.instantiateItem(container, position);
			fragment.setTitle(index);
			return fragment;
		}

	}

	@Override
	public void onClick(View v) {
		System.out.println(currentPage + " currentPage");
		switch (v.getId()) {
		case R.id.sale_left_arrow:
			viewPager.setCurrentItem(currentPage - 1);
			break;
		case R.id.sale_right_arrow:
			viewPager.setCurrentItem(currentPage + 1);
			break;
		default:
			break;
		}
	}
	
	public void setTitle(int index){
		this.index=index;
		pageAdapter.notifyDataSetChanged();
	}
	
}
