package com.cheshangguanjia.utils;

import java.io.File;

import android.net.Uri;
import android.os.Environment;

public class SdcardUtils {
	public static boolean hasSdcard() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			return true;
		} else {
			return false;
		}
	}
	public static void makeDir(String path){
		if(!isExits(path)){
			File file = new File(path);
			file.mkdir();
		}	
	}
	public static boolean isExits(String path){
		File file = new File(path);
		if(file.exists()){
			return true;
		}else{
			return false;
		}
	}
	public static Uri getFileUri(File file){
		return Uri.fromFile(file);
	}
}
