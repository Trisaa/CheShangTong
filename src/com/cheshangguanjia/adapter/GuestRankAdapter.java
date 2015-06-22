package com.cheshangguanjia.adapter;

import com.university.cheshangguanjia.R;

import android.R.string;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GuestRankAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private String rank;

	public GuestRankAdapter(Context context, String rank) {
		this.context = context;
		this.rank = rank;
		inflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		return 6;
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
			convertView = inflater.inflate(R.layout.guest_rank_item, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.picture);
			holder.nameView = (TextView) convertView.findViewById(R.id.name);
			holder.dccNameView = (TextView) convertView
					.findViewById(R.id.guwen);
			holder.timeView = (TextView) convertView.findViewById(R.id.time);
			holder.messageView = (TextView) convertView
					.findViewById(R.id.message);
			holder.rankView = (Button) convertView
					.findViewById(R.id.comment_level);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.nameView.setText("--");
		holder.dccNameView.setText("韩伟伟");
		holder.messageView.setText("添加修改理由");
		holder.timeView.setText("2014-06-01");
		holder.rankView.setText(rank);
		return convertView;
	}

	class ViewHolder {
		ImageView iconView;
		TextView nameView;
		TextView dccNameView;
		TextView timeView;
		TextView messageView;
		Button rankView;
	}

}
