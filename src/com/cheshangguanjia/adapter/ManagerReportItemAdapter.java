package com.cheshangguanjia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class ManagerReportItemAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private Context context;

	public ManagerReportItemAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
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
		ViewHolder holder=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.manager_salereport_data, null);
			holder=new ViewHolder();
			holder.projectView=(TextView) convertView.findViewById(R.id.lName);
			holder.composerView=(TextView) convertView.findViewById(R.id.lYear);
			holder.aimView=(TextView) convertView.findViewById(R.id.datetaici);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.projectView.setText("订单");
		holder.composerView.setText("0");
		holder.aimView.setText("0");
		return convertView;
	}

	class ViewHolder {
		TextView projectView;
		TextView composerView;
		TextView aimView;
	}

}
