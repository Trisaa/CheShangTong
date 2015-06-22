package com.cheshangguanjia.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class RankCountAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private List<Map<String, Object>> stats;
	private float count;

	public RankCountAdapter(Context context, List<Map<String, Object>> stats) {
		this.context = context;
		inflater = LayoutInflater.from(this.context);
		this.stats = stats;
	}

	@Override
	public int getCount() {
		count = 0;
		for (Map<String, Object> item : stats) {
			count += Float.valueOf(item.get("num").toString());
		}
		return stats.size();
	}

	@Override
	public Map<String, Object> getItem(int position) {
		return stats.get(position);
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
			convertView = inflater.inflate(R.layout.rank_count_item, null);
			holder.rankView = (TextView) convertView.findViewById(R.id.name);
			holder.numView = (TextView) convertView
					.findViewById(R.id.level_count);
			holder.progressView = (ProgressBar) convertView
					.findViewById(R.id.color_progressBar);
			holder.percentView = (TextView) convertView
					.findViewById(R.id.comment_level);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.rankView.setText(getItem(position).get("step").toString() + "级");
		float percent = 100
				* Float.valueOf(getItem(position).get("num").toString())
				/ count;
		holder.percentView.setText(percent + "%");
		holder.progressView.setProgress((int) percent);
		holder.numView.setText(getItem(position).get("num").toString());
		return convertView;
	}

	class ViewHolder {
		TextView rankView;
		TextView numView;
		ProgressBar progressView;
		TextView percentView;
	}
}
