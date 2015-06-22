package com.cheshangguanjia.adapter;

import com.university.cheshangguanjia.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DrawPriceAdapter extends BaseAdapter{
	
	private Context context;
	private LayoutInflater inflater;
	
	public DrawPriceAdapter(Context context){
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
			convertView=inflater.inflate(R.layout.draw_price_item, null);
			holder.messageView=(TextView) convertView.findViewById(R.id.price_message);
			holder.timeView=(TextView) convertView.findViewById(R.id.price_time);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		return convertView;
	}
	
	class ViewHolder{
		TextView messageView;
		TextView timeView;
	}

}
