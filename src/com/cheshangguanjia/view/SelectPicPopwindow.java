package com.cheshangguanjia.view;

import java.io.File;

import com.cheshangguanjia.activity.PersonInfoActivity;
import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

public class SelectPicPopwindow extends PopupWindow{
	 private TextView btn_take_photo, btn_pick_photo, btn_cancel;  
	    private View mMenuView; 
	    private static final int PHOTO_REQUEST_CAREMA = 1;//拍照
		private static final int PHOTO_REQUEST_GALLERY = 2;//从相册中选择
		private static final int PHOTO_REQUEST_CUT = 3;//结果
		private File tempFile;
	  
	    public SelectPicPopwindow(final Activity context) {  
	        super(context);  
	        LayoutInflater inflater = (LayoutInflater) context  
	                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	        mMenuView = inflater.inflate(R.layout.selectpic_popwindow, null);  
	        btn_take_photo = (TextView) mMenuView.findViewById(R.id.administration_function_photograph);  
	        btn_pick_photo = (TextView) mMenuView.findViewById(R.id.administration_function_photochoice);  
	        btn_cancel = (TextView) mMenuView.findViewById(R.id.administration_function_photocancel);  
	        //取消按钮  
	        btn_cancel.setOnClickListener(new OnClickListener() {  
	  
	            @Override
				public void onClick(View v) {  
	                //销毁弹出框  
	                dismiss();  
	            }  
	        });  
	        //拍照按钮
	        btn_take_photo.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dismiss();  
					Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
					// 判断存储卡是否可以用，可用进行存储
					if (hasSdcard()) {
						tempFile = new File(Environment.getExternalStorageDirectory(),
								"usericon");
						// 从文件中创建uri
						Uri uri = Uri.fromFile(tempFile);
						intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
					}
					((PersonInfoActivity) context).setTempFile(tempFile);
					
					context.startActivityForResult(intent, PHOTO_REQUEST_CAREMA);
				}
			});
	        //从相册选择按钮
	        btn_pick_photo.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dismiss();  
					// 激活系统图库，选择一张图片
					Intent intent1 = new Intent(Intent.ACTION_PICK);
					intent1.setType("image/*");
					// 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
					context.startActivityForResult(intent1, PHOTO_REQUEST_GALLERY);
				}
			});
	        //设置SelectPicPopupWindow的View  
	        this.setContentView(mMenuView);  
	        //设置SelectPicPopupWindow弹出窗体的宽  
	        this.setWidth(LayoutParams.FILL_PARENT);  
	        //设置SelectPicPopupWindow弹出窗体的高  
	        this.setHeight(LayoutParams.WRAP_CONTENT);  
	        //设置SelectPicPopupWindow弹出窗体可点击  
	        this.setFocusable(true);
	        
	        //设置SelectPicPopupWindow弹出窗体动画效果  
	        //this.setAnimationStyle(R.style.AnimBottom);
	        
	        //实例化一个ColorDrawable颜色为半透明  
	        ColorDrawable dw = new ColorDrawable(0x55000000);  
	        //设置SelectPicPopupWindow弹出窗体的背景  
	        this.setBackgroundDrawable(dw);  
	  
	    }  
	    
		/*
		 * 判断sdcard是否被挂载
		 */
		private boolean hasSdcard() {
			if (Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				return true;
			} else {
				return false;
			}
		}

}
