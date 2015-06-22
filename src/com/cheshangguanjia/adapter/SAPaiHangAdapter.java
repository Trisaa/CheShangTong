package com.cheshangguanjia.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheshangguanjia.activity.GuestRankActivity;
import com.cheshangguanjia.utils.GetImgeLoadOption;
import com.cheshangguanjia.utils.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.university.cheshangguanjia.R;

public class SAPaiHangAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private List<Map<String, Object>> sas;
	private ImageLoader imageLoader;

	public SAPaiHangAdapter(Context context, List<Map<String, Object>> sas) {
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
		this.sas = sas;
		imageLoader = ImageLoader.getInstance();
	}

	@Override
	public int getCount() {
		return sas.size();
	}

	@Override
	public Map<String, Object> getItem(int position) {
		return sas.get(position);
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
			convertView = inflater.inflate(R.layout.manager_aftersale_sa_item,
					null);
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
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.nameView.setText(getItem(position).get("name").toString());
		// switch (position) {
		// case 0:
		// holder.levelView.setVisibility(View.VISIBLE);
		// holder.levelView.setBackgroundResource(R.drawable.lv1);
		// holder.levelView.setText("NO1");
		// break;
		// case 1:
		// holder.levelView.setVisibility(View.VISIBLE);
		// holder.levelView.setBackgroundResource(R.drawable.lv2);
		// holder.levelView.setText("NO2");
		// case 2:
		// holder.levelView.setVisibility(View.VISIBLE);
		// holder.levelView.setBackgroundResource(R.drawable.lv3);
		// holder.levelView.setText("NO3");
		// break;
		// default:
		// holder.levelView.setVisibility(View.GONE);
		// break;
		// }
		holder.guestNumView.setText(getItem(position).get("total").toString());
		holder.successNumView.setText(getItem(position).get("lost").toString());
		if (!getItem(position).get("img").equals("")) {
			imageLoader.displayImage(
					Utils.urlPrev + getItem(position).get("img").toString(),
					holder.iconView, GetImgeLoadOption.getDefaultOption());
		}

		holder.guestNumView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, GuestRankActivity.class);
				context.startActivity(intent);
			}
		});
		holder.successNumView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(context, GuestRankActivity.class);
				context.startActivity(intent);
			}
		});
		return convertView;
	}

	class ViewHolder {
		ImageView iconView;
		TextView nameView;
		TextView levelView;
		TextView guestNumView;
		TextView successNumView;
	}

}
