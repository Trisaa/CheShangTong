package com.cheshangguanjia.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class ServiceKehuguanliFragment extends Fragment implements OnCheckedChangeListener {

	private View mainView;
	private TextView carView, pipeiView, registerView, releaseView;
	private RadioGroup group;
	private FragmentManager manager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.service_kehuguanli, null);
		
		initView();
		
		return mainView;
	}
	
	private void initView(){
		carView=(TextView) mainView.findViewById(R.id.company_item_fans);
		pipeiView=(TextView) mainView.findViewById(R.id.company_item_customers);
		registerView=(TextView) mainView.findViewById(R.id.company_item_binds);
		releaseView=(TextView) mainView.findViewById(R.id.company_carstyle_binds);
		group=(RadioGroup) mainView.findViewById(R.id.salereport_radiogroup);
		
		manager=getFragmentManager();
		
		carView.setText("3022");
		pipeiView.setText("2243");
		registerView.setText("779");
		releaseView.setText("39");
		
		Fragment fragment=manager.findFragmentByTag("sa");
		if(fragment==null){
			fragment=new SApaihangFragment();
			manager.beginTransaction().replace(R.id.aftersalemanagerhome_child_fragment, fragment).commit();
		}else{
			if(!fragment.isAdded()){
				manager.beginTransaction().replace(R.id.aftersalemanagerhome_child_fragment, fragment).commit();
			}
		}
		
		group.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.dayreport:
			Fragment fragment=manager.findFragmentByTag("sa");
			if(fragment==null){
				fragment=new SApaihangFragment();
				manager.beginTransaction().replace(R.id.aftersalemanagerhome_child_fragment, fragment).commit();
			}else{
				if(!fragment.isAdded()){
					manager.beginTransaction().replace(R.id.aftersalemanagerhome_child_fragment, fragment).commit();
				}
			}
			break;
		case R.id.seasonreport:
			Fragment carStyleFragment=manager.findFragmentByTag("carstyle");
			if(carStyleFragment==null){
				carStyleFragment=new CarStylepaihangFragment();
				manager.beginTransaction().replace(R.id.aftersalemanagerhome_child_fragment, carStyleFragment).commit();
			}else{
				if(!carStyleFragment.isAdded()){
					manager.beginTransaction().replace(R.id.aftersalemanagerhome_child_fragment, carStyleFragment).commit();
				}
			}
			break;
		default:
			break;
		}
	};

}
