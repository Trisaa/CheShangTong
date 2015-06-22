package com.cheshangguanjia.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class CarSortAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private List<Map<String, Object>> series;

	public CarSortAdapter(Context context, List<Map<String, Object>> series) {
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
		this.series = series;
	}

	@Override
	public int getCount() {
		return series.size();
	}

	@Override
	public Map<String, Object> getItem(int position) {
		return series.get(position);
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
			convertView = inflater.inflate(R.layout.car_sort_item, null);
			holder.nameView = (TextView) convertView
					.findViewById(R.id.company_item_fans_text);
			holder.levelView = (TextView) convertView
					.findViewById(R.id.company_item_no);
			holder.guestNumView = (TextView) convertView
					.findViewById(R.id.company_item_customers_text);
			holder.successNumView = (TextView) convertView
					.findViewById(R.id.company_item_binds_text);
			holder.failNumView = (TextView) convertView
					.findViewById(R.id.company_carstyle_text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.nameView.setText("孙美辰");
		// switch (position) {
		// case 0:
		// holder.levelView.setVisibility(View.VISIBLE);
		// holder.levelView.setBackgroundResource(R.drawable.lv1);
		// break;
		// case 2:
		// holder.levelView.setVisibility(View.VISIBLE);
		// holder.levelView.setBackgroundResource(R.drawable.lv2);
		// case 3:
		// holder.levelView.setVisibility(View.VISIBLE);
		// holder.levelView.setBackgroundResource(R.drawable.lv3);
		// break;
		// default:
		// holder.levelView.setVisibility(View.GONE);
		// break;
		// }
		holder.guestNumView.setText(getItem(position).get("total").toString());
		holder.successNumView.setText(getItem(position).get("H").toString());
		holder.failNumView.setText(getItem(position).get("A").toString());
		return convertView;
	}

	class ViewHolder {
		TextView nameView;
		TextView levelView;
		TextView guestNumView;
		TextView successNumView;
		TextView failNumView;
	}
}
