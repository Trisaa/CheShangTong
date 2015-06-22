package com.cheshangguanjia.activity;

import java.io.File;

import com.cheshangguanjia.utils.SdcardUtils;
import com.cheshangguanjia.view.SelectPicPopwindow;
import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PersonInfoActivity extends Activity implements OnClickListener{
	private ImageView usericon;
	private TextView username;
	private RelativeLayout editiconLayout,editpasswordLayout;
	private ImageButton backButton;
	private SelectPicPopwindow selectPicPopwindow;
	private File tempFile;
	private Bitmap bitmap;
	
	private static final int PHOTO_REQUEST_CAREMA = 1;// 拍照
	private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
	private static final int PHOTO_REQUEST_CUT = 3;// 结果

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personinfo_detail_activity);
		initView();
	}
	
	public void initView(){
		usericon = (ImageView)findViewById(R.id.userpic);
		username = (TextView)findViewById(R.id.username);
		editiconLayout = (RelativeLayout)findViewById(R.id.usericon_ll);
		editpasswordLayout = (RelativeLayout)findViewById(R.id.fixpassword_ll);
		backButton = (ImageButton)findViewById(R.id.goback);
		
		editiconLayout.setOnClickListener(this);
		editpasswordLayout.setOnClickListener(this);
		backButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.usericon_ll:
			selectPicPopwindow = new SelectPicPopwindow(this);
			selectPicPopwindow.showAtLocation(
					this.findViewById(R.id.selectpic_layout), Gravity.BOTTOM
							| Gravity.CENTER_HORIZONTAL, 0, 0);
			break;
		case R.id.fixpassword_ll:
			Intent intent = new Intent(this,FixPasswordActivity.class);
			startActivity(intent);
			break;
		case R.id.goback:
			finish();
			break;

		default:
			break;
		}
	}
	
	
	private void crop(Uri uri) {
		// 裁剪图片意图
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		// 裁剪框的比例，1：1
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// 裁剪后输出图片的尺寸大小
		intent.putExtra("outputX", 250);
		intent.putExtra("outputY", 250);

		intent.putExtra("outputFormat", "JPEG");// 图片格式
		intent.putExtra("noFaceDetection", true);// 取消人脸识别
		intent.putExtra("return-data", true);
		// 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
		startActivityForResult(intent, PHOTO_REQUEST_CUT);
	}

	public void setTempFile(File file) {
		tempFile = file;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PHOTO_REQUEST_GALLERY) {
			// 从相册返回的数据
			if (data != null) {
				// 得到图片的全路径
				Uri uri = data.getData();
				crop(uri);
			}

		} else if (requestCode == PHOTO_REQUEST_CAREMA) {
			// 从相机返回的数据
			if (SdcardUtils.hasSdcard()) {
				crop(Uri.fromFile(tempFile));

			} else {
				Toast.makeText(PersonInfoActivity.this, "未找到存储卡，无法存储照片！", 0)
						.show();
			}

		} else if (requestCode == PHOTO_REQUEST_CUT) {
			// 从剪切图片返回的数据
			if (data != null) {

				bitmap = data.getParcelableExtra("data");
				usericon.setImageBitmap(bitmap);
				usericon.setBackgroundResource(R.drawable.transparent);
				if(bitmap != null){

				}
			}
			if (tempFile != null) {
				try {
					// 将临时文件删除
					tempFile.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		super.onActivityResult(requestCode, resultCode, data);
	}

}
