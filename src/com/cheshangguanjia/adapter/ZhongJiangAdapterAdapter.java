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

public class ZhongJiangAdapterAdapter extends BaseAdapter{
	private Context context;
	private LayoutInflater inflater;

	public ZhongJiangAdapterAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
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
			convertView = inflater.inflate(R.layout.zhongjiangmingdan_item_item, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.onelevelicon);
			holder.content = (TextView) convertView
					.findViewById(R.id.onelevel);
			holder.time = (TextView) convertView
					.findViewById(R.id.oneleveldatetextview);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.content.setText("林林");
		holder.time.setText("2015/1/2");
		return convertView;
	}
	
	class ViewHolder {
		ImageView iconView;
		TextView content;
		TextView time;
	}

}
