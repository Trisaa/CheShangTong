package com.cheshangguanjia.adapter;

import com.cheshangguanjia.activity.ManagerGuestDataActivity;
import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ManagerCommentAdapter extends BaseAdapter implements
		OnClickListener {

	private Context context;
	private LayoutInflater inflater;
	private boolean isService;

	public ManagerCommentAdapter(Context context, boolean isService) {
		this.context = context;
		inflater = LayoutInflater.from(context);
		this.isService = isService;
	}

	@Override
	public int getCount() {
		return 5;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parentView) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.manager_comment_item, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.picture);
			holder.nameView = (TextView) convertView.findViewById(R.id.name);
			holder.targetView = (TextView) convertView.findViewById(R.id.guwen);
			holder.commentView = (TextView) convertView
					.findViewById(R.id.message);
			holder.timeView = (TextView) convertView.findViewById(R.id.time);
			holder.arrowView = (ImageView) convertView
					.findViewById(R.id.morearrow);
			holder.rankView = (TextView) convertView
					.findViewById(R.id.comment_level);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.nameView.setText("李旺");
		holder.timeView.setText("04-24 17:06");
		holder.targetView.setText("点评对象：张莲莲");
		holder.commentView.setText("头像不清楚");
		holder.rankView.setText("好评");
		if (!isService) {
			holder.iconView.setOnClickListener(this);
		}
		return convertView;
	}

	class ViewHolder {
		private ImageView iconView;
		private TextView nameView;
		private TextView targetView;
		private TextView commentView;
		private TextView timeView;
		private ImageView arrowView;
		private TextView rankView;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.picture:
			((Activity) context).startActivity(new Intent(context,
					ManagerGuestDataActivity.class));
			break;

		default:
			break;
		}
	}

}
