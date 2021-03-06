package com.cheshangguanjia.adapter;

import java.util.List;

import com.university.cheshangguanjia.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BaoxianKehuAdapter extends BaseExpandableListAdapter{
	private Context context;
	private List<String>groupname;
	private LayoutInflater inflater;
	
	public BaoxianKehuAdapter(Context context){
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View convertView,
			ViewGroup arg4) {
		// TODO Auto-generated method stub
		ViewHolder2 holder = null;
		if(convertView == null){
			holder = new ViewHolder2();
			convertView = inflater.inflate(R.layout.expandable_child, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.usericon);
			holder.name = (TextView) convertView
					.findViewById(R.id.lName);
			holder.time = (TextView) convertView
					.findViewById(R.id.log);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder2) convertView.getTag();
		}
		holder.name.setText("一霎哈");
		holder.time.setText("2015-05-13");
		return convertView;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View convertView, ViewGroup arg3) {
		// TODO Auto-generated method stub
		ViewHolder1 holder = null;
		if(convertView == null){
			holder = new ViewHolder1();
			convertView = inflater.inflate(R.layout.expandable_group, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.group_indicator);
			holder.name = (TextView) convertView
					.findViewById(R.id.group_name);
			holder.time = (TextView) convertView
					.findViewById(R.id.online_count);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder1) convertView.getTag();
		}
		holder.name.setText("客户总数");
		holder.time.setText("23人");
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}
	
	class ViewHolder1 {
		ImageView iconView;
		TextView name;
		TextView time;
	}
	class ViewHolder2 {
		ImageView iconView;
		TextView name;
		TextView time;
	}

}
