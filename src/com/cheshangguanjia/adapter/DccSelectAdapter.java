package com.cheshangguanjia.adapter;

import com.university.cheshangguanjia.R;

import android.R.integer;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DccSelectAdapter extends BaseAdapter implements OnClickListener {

	private Context context;
	private LayoutInflater inflater;
	private AlertDialog dialog;
	private View dialogContentView;
	private TextView messageView;
	private Button postiveButton, negtivebutton;
	private int checked;

	public DccSelectAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(this.context);

		dialogContentView = inflater.inflate(R.layout.v2_dialog_base, null);
		messageView = (TextView) dialogContentView
				.findViewById(R.id.dialog_message);
		postiveButton = (Button) dialogContentView
				.findViewById(R.id.dialog_positivebutton);
		negtivebutton = (Button) dialogContentView
				.findViewById(R.id.dialog_negativebutton);
		postiveButton.setOnClickListener(this);
		negtivebutton.setOnClickListener(this);
		postiveButton.setText("确定");
		negtivebutton.setText("取消");
		messageView.setText("亲，确定要讲吕正晨分配给贾晓玲吗？");
		dialog = new AlertDialog.Builder(this.context).setView(
				dialogContentView).create();
	}

	@Override
	public int getCount() {
		return 8;
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
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.dcc_select_item, null);
			holder.iconView = (ImageView) convertView
					.findViewById(R.id.picture);
			holder.nameView = (TextView) convertView.findViewById(R.id.name);
			holder.describView = (TextView) convertView
					.findViewById(R.id.lContent);
			holder.checkedView = (ImageButton) convertView
					.findViewById(R.id.okbutton);
			holder.contentView = convertView.findViewById(R.id.selectionview);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.nameView.setText("张莲莲");
		holder.describView.setText("客户总数80人，成交0人");
		holder.contentView.setOnClickListener(new MyOnclickListener(position));
		return convertView;
	}
	
	class MyOnclickListener implements OnClickListener{
		private int position;
		
		public MyOnclickListener(int position){
			this.position=position;
		}
		
		@Override
		public void onClick(View arg0) {
			dialog.show();
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dialog_positivebutton:
			dialog.cancel();
			break;
		case R.id.dialog_negativebutton:
			dialog.cancel();
			break;
		default:
			break;
		}
	}

	class ViewHolder {
		ImageView iconView;
		TextView nameView;
		TextView describView;
		ImageButton checkedView;
		View contentView;
	}

}
