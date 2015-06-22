package com.cheshangguanjia.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;

import android.text.style.ParagraphStyle;

import com.cheshangguanjia.connection.HttpUtils;
import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CustomerService {
	
	private static final String clazzBuyer = "app/claszBuyer";
	public static final QueryId clazzBuyerId=new QueryId();
	
	public void getClaszBuyer(String clasz, OnQueryCompleteListener onQueryCompleteListener){
		List<BasicNameValuePair> parms=new ArrayList<BasicNameValuePair>();
		parms.add(new BasicNameValuePair("step", clasz));
		makeSimpleQuery(clazzBuyer, parms, clazzBuyerId, onQueryCompleteListener);
	}
	

	private void makeSimpleQuery(String url, List<BasicNameValuePair> parms,
			final QueryId flag, OnQueryCompleteListener onQueryCompleteListener) {
		if (parms == null) {
			parms = new ArrayList<BasicNameValuePair>();
		}
		HttpUtils.makeAsyncPost(url, parms, new QueryCompleteHandler(
				onQueryCompleteListener, flag) {
			Map<String, Object> nums;

			@Override
			public void handleResponse(String jsonResult, EHttpError error) {
				// TODO Auto-generated method stub
				if (jsonResult != null && error == EHttpError.KErrorNone) {
					Gson gson = new Gson();
					Type type = new TypeToken<Map<String, Object>>() {
					}.getType();
					nums = gson.fromJson(jsonResult, type);
					this.completeListener.onQueryComplete(flag, nums, error);
				} else {
					this.completeListener.onQueryComplete(flag, null, error);
				}
			}
		});
	}
}
