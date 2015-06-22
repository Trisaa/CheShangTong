package com.cheshangguanjia.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cheshangguanjia.activity.FixNoticeActivity;
import com.cheshangguanjia.activity.MyMessagesActivity;
import com.cheshangguanjia.activity.PersonInfoActivity;
import com.university.cheshangguanjia.R;

public class ManagerMoreFragment extends Fragment implements OnClickListener{
	private RelativeLayout personinfoLayout,mymessageLayout,remindLayout,
						cacheLayout,aboutLayout,logoutLayout;
	private ImageView userIcon;
	private TextView gradeView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.manager_more_fragment, null);
		initView(view);
		return view;
	}
	
	public void initView(View view){
		personinfoLayout = (RelativeLayout)view.findViewById(R.id.userinfo_ll);
		mymessageLayout = (RelativeLayout)view.findViewById(R.id.mymessage_ll);
		remindLayout = (RelativeLayout)view.findViewById(R.id.notice_ll);
		cacheLayout = (RelativeLayout)view.findViewById(R.id.clearcache_ll);
		aboutLayout = (RelativeLayout)view.findViewById(R.id.function_ll);
		logoutLayout = (RelativeLayout)view.findViewById(R.id.exitview);
		userIcon = (ImageView)view.findViewById(R.id.userpic);
		gradeView = (TextView)view.findViewById(R.id.integral_tv);
		
		personinfoLayout.setOnClickListener(this);
		mymessageLayout.setOnClickListener(this);
		remindLayout.setOnClickListener(this);
		cacheLayout.setOnClickListener(this);
		aboutLayout.setOnClickListener(this);
		logoutLayout.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.userinfo_ll:
			Intent intent = new Intent(getActivity(),PersonInfoActivity.class);
			startActivity(intent);
			break;
		case R.id.mymessage_ll:
			intent = new Intent(getActivity(),MyMessagesActivity.class);
			startActivity(intent);		
			break;
		case R.id.notice_ll:
			intent = new Intent(getActivity(),FixNoticeActivity.class);
			startActivity(intent);
			break;
		case R.id.clearcache_ll:
			new AlertDialog.Builder(getActivity()).setTitle("提示")
			.setMessage("亲，确定要清除缓存么？")
			.setPositiveButton("确定", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					arg0.cancel();
					Toast.makeText(getActivity(), "清除成功", 2000).show();
				}
			})
			.setNegativeButton("取消", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					arg0.cancel();
				}
			}).show();
			break;
		case R.id.function_ll:
			
			break;
		case R.id.exitview:
			
			break;

		default:
			break;
		}
	}

}
