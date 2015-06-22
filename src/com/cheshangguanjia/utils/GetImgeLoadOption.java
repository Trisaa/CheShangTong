package com.cheshangguanjia.utils;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.university.cheshangguanjia.R;

public class GetImgeLoadOption {

	public static DisplayImageOptions normalOptions;

	public static DisplayImageOptions iconOptions;

	public static DisplayImageOptions getDefaultOption() {
		if (normalOptions == null) {
			normalOptions = new DisplayImageOptions.Builder()
					.showImageOnLoading(R.drawable.no_head)
					.showImageForEmptyUri(R.drawable.no_head)
					.showImageOnFail(R.drawable.no_head)
					.cacheInMemory(true).cacheOnDisk(true)
					.considerExifParams(true).build();
		}
		return normalOptions;
	}

}
