package com.cheshangguanjia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class GouCheXunjiaAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private String from;

	public GouCheXunjiaAdapter(Context context,String from) {
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
		this.from = from;
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
			convertView = inflater.inflate(R.layout.gouchexunjia_item, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.picture);
			holder.name = (TextView) convertView
					.findViewById(R.id.name);
			holder.time = (TextView) convertView
					.findViewById(R.id.time);
			holder.description = (TextView) convertView
					.findViewById(R.id.message);
			holder.status = (TextView) convertView
					.findViewById(R.id.status);
			holder.guwen = (TextView) convertView
					.findViewById(R.id.guwen);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if(from.equals("购车询价")){
			holder.guwen.setVisibility(View.GONE);
		}
		else {
			holder.guwen.setVisibility(View.VISIBLE);
		}
		holder.name.setText("林林");
		holder.time.setText("2015-01-11");
		holder.description.setText("客户从微信自行注册成为潜客");
		return convertView;
	}

	class ViewHolder {
		ImageView iconView;
		TextView name;
		TextView time;
		TextView description;
		TextView status;
		TextView guwen;
	}

}
