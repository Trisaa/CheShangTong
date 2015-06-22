package com.cheshangguanjia.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.university.cheshangguanjia.R;

public class RescueMapActivity extends Activity implements OnClickListener {

	private View backView;
	private View startMapView;
	private TextView nameView, carStyleView, carNumView, phoneView,
			addressView, recordView;
	private View recordBackView;
	private MapView mMapView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rescue_map_activity);

		initView();

		initMap();
	}

	private void initMap() {
		
		MapStatusUpdate status=MapStatusUpdateFactory.zoomTo(15.0f);
		mMapView.getMap().setMapStatus(status);
		
		MapStatusUpdate update=MapStatusUpdateFactory.newLatLng(new LatLng(39.963175, 116.400244));
		mMapView.getMap().animateMapStatus(update);
		//定义Maker坐标点  
		LatLng point = new LatLng(39.963175, 116.400244);  
		//构建Marker图标  
		BitmapDescriptor bitmap = BitmapDescriptorFactory  
		    .fromResource(R.drawable.maker);
		//构建MarkerOption，用于在地图上添加Marker  
		OverlayOptions option = new MarkerOptions()  
		    .position(point)  
		    .icon(bitmap);  
		//在地图上添加Marker，并显示  
		mMapView.getMap().addOverlay(option);
	}

	private void initView() {
		backView = findViewById(R.id.goback);
		startMapView = findViewById(R.id.nextto);
		nameView = (TextView) findViewById(R.id.name_tv);
		carStyleView = (TextView) findViewById(R.id.carstyle_tv);
		carNumView = (TextView) findViewById(R.id.chepai);
		phoneView = (TextView) findViewById(R.id.phone_tv);
		addressView = (TextView) findViewById(R.id.place_tv);
		recordView = (TextView) findViewById(R.id.rescue_history_tv);
		recordBackView = findViewById(R.id.rescue_history_ll);
		mMapView = (MapView) findViewById(R.id.bmapView);

		backView.setOnClickListener(this);
		recordBackView.setOnClickListener(this);
		startMapView.setOnClickListener(this);

		nameView.setText("王俊峰");
		carStyleView.setText("皇冠");
		carNumView.setText("辽BV0Q26");
		phoneView.setText("13354149915");
		addressView.setText("微信为您定位：大连市，甘井子区华北路，432号");
		recordView.setText("用户取消");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.rescue_history_ll:
			startActivity(new Intent(this, RescueHistoryActivity.class));
			break;
		case R.id.nextto:
			Intent intent;
			try {
				intent = Intent
						.getIntent("intent://map/direction?origin=latlng:34.264642646862,108.95108518068|name:我家&destination=大雁塔&mode=driving&region=西安&src=yourCompanyName|yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
				startActivity(intent);
			} catch (Exception e) {
				Toast.makeText(this, "亲，尚未安装百度地图app或者app版本过低",
						Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
		mMapView.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
		mMapView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// 在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
		mMapView.onPause();
	}

}
