package com.cheshangguanjia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.university.cheshangguanjia.R;

public class SaleServiceReportAdapter extends BaseAdapter {

	public Context context;
	private LayoutInflater inflater;

	public SaleServiceReportAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(this.context);
	}

	@Override
	public int getCount() {
		return 6;
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
		ViewHolder holder = new ViewHolder();
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.sale_service_report_item,
					null);
			holder = new ViewHolder();
			holder.timeView = (TextView) convertView
					.findViewById(R.id.company_item_fans_text);
			holder.keepPriceNewView = (TextView) convertView
					.findViewById(R.id.company_item_customers_text_one);
			holder.keepPriceTotalView = (TextView) convertView
					.findViewById(R.id.company_item_binds_text_one);
			holder.repairNewView = (TextView) convertView
					.findViewById(R.id.company_item_customers_text_two);
			holder.repairTotalView = (TextView) convertView
					.findViewById(R.id.company_item_binds_text_two);
			holder.commentNewView = (TextView) convertView
					.findViewById(R.id.company_item_customers_text_three);
			holder.commentTotalView = (TextView) convertView
					.findViewById(R.id.company_item_binds_text_three);
			holder.priceNewView = (TextView) convertView
					.findViewById(R.id.company_item_customers_text_four);
			holder.priceTotalView = (TextView) convertView
					.findViewById(R.id.company_item_binds_text_four);
			holder.messageNewView = (TextView) convertView
					.findViewById(R.id.company_item_customers_text_five);
			holder.messageTotalView = (TextView) convertView
					.findViewById(R.id.company_item_binds_text_five);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.timeView.setText("2015-04-30");
		holder.keepPriceNewView.setText("0");
		holder.keepPriceTotalView.setText("95");
		holder.repairNewView.setText("0");
		holder.repairTotalView.setText("4");
		holder.commentNewView.setText("0");
		holder.commentTotalView.setText("4");
		holder.priceNewView.setText("9");
		holder.priceTotalView.setText("66");
		holder.messageNewView.setText("0");
		holder.messageTotalView.setText("1096");
		
		ServiceReportListener listener=new ServiceReportListener(position);
		holder.keepPriceNewView.setOnClickListener(listener);
		holder.keepPriceTotalView.setOnClickListener(listener);
		holder.repairNewView.setOnClickListener(listener);
		holder.repairTotalView.setOnClickListener(listener);
		holder.commentNewView.setOnClickListener(listener);
		holder.commentTotalView.setOnClickListener(listener);
		holder.priceNewView.setOnClickListener(listener);
		holder.priceTotalView.setOnClickListener(listener);
		holder.messageNewView.setOnClickListener(listener);
		holder.messageTotalView.setOnClickListener(listener);
		return convertView;
	}

	class ServiceReportListener implements OnClickListener {
		private int position;

		public ServiceReportListener(int position) {
			this.position = position;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.company_item_fans_text:
				break;
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
			case R.id.company_item_customers_text_five:
				break;
			case R.id.company_item_binds_text_five:
				break;
			default:
				break;
			}
		}
	}

	class ViewHolder {
		TextView timeView;
		TextView keepPriceNewView;
		TextView keepPriceTotalView;
		TextView repairNewView;
		TextView repairTotalView;
		TextView commentNewView;
		TextView commentTotalView;
		TextView priceNewView;
		TextView priceTotalView;
		TextView messageNewView;
		TextView messageTotalView;
	}

}
