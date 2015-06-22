package com.cheshangguanjia.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheshangguanjia.activity.BaoxianXubaoxunjiaActivity;
import com.cheshangguanjia.activity.ManagerGuestDataActivity;
import com.university.cheshangguanjia.R;

public class BaoxianHomeAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;

	public BaoxianHomeAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return 5;
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
			convertView=inflater.inflate(R.layout.customers_item, null);
			holder=new ViewHolder();
			holder.iconView=(ImageView) convertView.findViewById(R.id.picture);
			holder.nameView=(TextView) convertView.findViewById(R.id.name);
			holder.carView=(TextView) convertView.findViewById(R.id.message);
			holder.timeView=(TextView) convertView.findViewById(R.id.time);
			holder.backView=convertView.findViewById(R.id.acount_ll);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.nameView.setText("高丽");
		holder.carView.setText("辽BB8E72");
		holder.timeView.setText("05-13 18:49");
		MyOnclickListener listener=new MyOnclickListener(position);
		holder.iconView.setOnClickListener(listener);
		holder.backView.setOnClickListener(listener);
		
		return convertView;
	}
	
	private class MyOnclickListener implements OnClickListener{
		
		private int position;
		
		public MyOnclickListener(int position){
			this.position=position;
		}
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.acount_ll:
				context.startActivity(new Intent(context, BaoxianXubaoxunjiaActivity.class));
				break;
			case R.id.picture:
				context.startActivity(new Intent(context, ManagerGuestDataActivity.class));
				break;
			default:
				break;
			}
		}
	}

	class ViewHolder {
		ImageView iconView;
		TextView nameView;
		TextView carView;
		TextView timeView;
		View backView;
	}

}
