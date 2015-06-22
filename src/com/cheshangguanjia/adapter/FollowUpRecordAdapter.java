package com.cheshangguanjia.adapter;

import com.university.cheshangguanjia.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FollowUpRecordAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;

	public FollowUpRecordAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		return 3;
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
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.follow_up_record_item, null);
			holder.timeView=(TextView) convertView.findViewById(R.id.fixname);
			holder.messageView=(TextView) convertView.findViewById(R.id.fixcontent);
			holder.actionView=(TextView) convertView.findViewById(R.id.fixdate);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.timeView.setText("4月27日 21:45 林吉龙");
		holder.actionView.setText("--【选择顾问】");
		holder.messageView.setText("将客户分配给孙美辰");
		return convertView;
	}

	class ViewHolder {
		private TextView timeView;
		private TextView actionView;
		private TextView messageView;
	}

}
