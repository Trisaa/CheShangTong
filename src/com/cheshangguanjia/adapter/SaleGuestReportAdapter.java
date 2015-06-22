package com.cheshangguanjia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class SaleGuestReportAdapter extends BaseAdapter {
	
	private Context context;
	private LayoutInflater inflater;

	public SaleGuestReportAdapter(Context context) {
		this.context = context;
		this.inflater=LayoutInflater.from(this.context);
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
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.sale_guest_report_item, null);
			holder.timeView=(TextView) convertView.findViewById(R.id.company_item_fans_text);
			holder.qiankeNewView=(TextView) convertView.findViewById(R.id.company_item_customers_text_one);
			holder.qiankeTotalView=(TextView) convertView.findViewById(R.id.company_item_binds_text_one);
			holder.dccNewViwe=(TextView) convertView.findViewById(R.id.company_item_customers_text_two);
			holder.dccTotalView=(TextView) convertView.findViewById(R.id.company_item_binds_text_two);
			holder.carNewView=(TextView) convertView.findViewById(R.id.company_item_customers_text_three);
			holder.carTotalView=(TextView) convertView.findViewById(R.id.company_item_binds_text_three);
			holder.phoneNewView=(TextView) convertView.findViewById(R.id.company_item_customers_text_four);
			holder.phoneTotalView=(TextView) convertView.findViewById(R.id.company_item_binds_text_four);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		holder.timeView.setText("2015-4-30");
		holder.qiankeNewView.setText("3");
		holder.qiankeTotalView.setText("452");
		holder.dccNewViwe.setText("3");
		holder.dccTotalView.setText("452");
		holder.carNewView.setText("3");
		holder.carTotalView.setText("452");
		holder.phoneNewView.setText("3");
		holder.phoneTotalView.setText("94");
		
		MyOnclickListener listener=new MyOnclickListener(position);
		holder.qiankeNewView.setOnClickListener(listener);
		holder.qiankeTotalView.setOnClickListener(listener);
		holder.dccNewViwe.setOnClickListener(listener);
		holder.dccTotalView.setOnClickListener(listener);
		holder.carNewView.setOnClickListener(listener);
		holder.carTotalView.setOnClickListener(listener);
		holder.phoneNewView.setOnClickListener(listener);
		holder.phoneTotalView.setOnClickListener(listener);
		return convertView;
	}
	
	class MyOnclickListener implements OnClickListener{
		
		private int position;
		
		public MyOnclickListener(int position){
			this.position=position;
		}
		
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.company_item_customers_text_one:
				break;
			case R.id.company_item_binds_text_one:
				break;
			case R.id.company_item_customers_text_two:
				break;
			case R.id.company_item_binds_text_two:
				break;
			case R.id.company_item_customers_text_three:
				break;
			case R.id.company_item_binds_text_three:
				break;
			case R.id.company_item_customers_text_four:
				break;
			case R.id.company_item_binds_text_four:
				break;
			default:
				break;
			}
		}
	}
	
	class ViewHolder{
		TextView timeView;
		TextView qiankeNewView;
		TextView qiankeTotalView;
		TextView dccNewViwe;
		TextView dccTotalView;
		TextView carNewView;
		TextView carTotalView;
		TextView phoneNewView;
		TextView phoneTotalView;
	}
	
}
