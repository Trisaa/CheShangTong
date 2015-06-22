package com.cheshangguanjia.adapter;

import com.university.cheshangguanjia.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ZhongJiangAdapter extends BaseAdapter{
	private Context context;
	private LayoutInflater inflater;
	private ZhongJiangAdapterAdapter adapter;

	public ZhongJiangAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
		adapter = new ZhongJiangAdapterAdapter(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.zhongjiangmingdan_item, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.winnerprice);
			holder.name = (TextView) convertView
					.findViewById(R.id.winnername);
			holder.listView = (ListView) convertView
					.findViewById(R.id.lv_contain);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText("林林");
		holder.listView.setAdapter(adapter);
		return convertView;
	}
	
	class ViewHolder {
		ImageView iconView;
		TextView name;
		ListView listView;
	}

}
