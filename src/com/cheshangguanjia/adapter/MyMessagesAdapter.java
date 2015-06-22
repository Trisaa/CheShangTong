package com.cheshangguanjia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class MyMessagesAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;

	public MyMessagesAdapter(Context context) {
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
			convertView = inflater.inflate(R.layout.mymessageslist_item, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.newversionicon);
			holder.messages = (TextView) convertView
					.findViewById(R.id.name);
			holder.time = (TextView) convertView
					.findViewById(R.id.time);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.messages.setText("五一培训通知");
		holder.time.setText("2015/5/5 20:20");
		return convertView;
	}

	class ViewHolder {
		ImageView iconView;
		TextView messages;
		TextView time;
	}

}
