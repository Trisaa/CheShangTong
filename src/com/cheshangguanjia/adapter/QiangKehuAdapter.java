package com.cheshangguanjia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class QiangKehuAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;

	public QiangKehuAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.qiangkehu_item, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.picture);
			holder.name = (TextView) convertView
					.findViewById(R.id.name);
			holder.time = (Button) convertView
					.findViewById(R.id.time);
			holder.description = (TextView) convertView
					.findViewById(R.id.message);
			holder.source = (TextView) convertView
					.findViewById(R.id.source);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.name.setText("林林");
		holder.description.setText("客户从微信自行注册成为潜客");
		holder.source.setText("来源微信");
		return convertView;
	}

	class ViewHolder {
		ImageView iconView;
		TextView name;
		Button time;
		TextView description;
		TextView source;
	}

}
