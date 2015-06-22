package com.cheshangguanjia.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheshangguanjia.utils.GetImgeLoadOption;
import com.cheshangguanjia.utils.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.university.cheshangguanjia.R;

public class DccSortAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private List<Map<String, Object>> sales;

	public DccSortAdapter(Context context, List<Map<String, Object>> sales) {
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
		this.sales = sales;
	}

	@Override
	public int getCount() {
		return sales.size();
	}

	@Override
	public Map<String, Object> getItem(int position) {
		return sales.get(position);
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
			convertView = inflater.inflate(R.layout.dcc_sort_item, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.iconpic);
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
		holder.nameView.setText(getItem(position).get("name").toString());
		holder.guestNumView.setText(getItem(position).get("total").toString());
		holder.successNumView.setText(getItem(position).get("succ").toString());
		holder.failNumView.setText(getItem(position).get("fail").toString());
		if (!getItem(position).get("img").equals("")) {
			ImageLoader.getInstance().displayImage(
					Utils.urlPrev+getItem(position).get("img").toString(), holder.iconView,
					GetImgeLoadOption.getDefaultOption());
		}
		return convertView;
	}

	class ViewHolder {
		ImageView iconView;
		TextView nameView;
		TextView levelView;
		TextView guestNumView;
		TextView successNumView;
		TextView failNumView;
	}

}
