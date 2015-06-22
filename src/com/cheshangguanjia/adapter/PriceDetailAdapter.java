package com.cheshangguanjia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class PriceDetailAdapter extends BaseAdapter{
	private Context context;
	private LayoutInflater inflater;
	
	public PriceDetailAdapter(Context context){
		this.context=context;
		inflater=LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		return 3;
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
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.price_detail_item, null);
			holder.exchangeCodeView=(TextView) convertView.findViewById(R.id.title);
			holder.nameView=(TextView) convertView.findViewById(R.id.prizename);
			holder.priceView=(TextView) convertView.findViewById(R.id.ticketvalue);
			holder.timelineView=(TextView) convertView.findViewById(R.id.datetitle);
			holder.foreverView=(TextView) convertView.findViewById(R.id.yongjiu);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		return convertView;
	}
	
	class ViewHolder{
		TextView  exchangeCodeView;
		TextView nameView;
		TextView priceView;
		TextView explainView;
		TextView timelineView;
		TextView foreverView;
	}
}
