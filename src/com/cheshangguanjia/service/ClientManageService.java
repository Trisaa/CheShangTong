package com.cheshangguanjia.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;

import android.content.Context;

import com.cheshangguanjia.connection.HttpUtils;
import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ClientManageService {
	private final String BUYERMANAGER = "app/buyermanager";
	private final String CLASZ = "app/clasz";
	private final String SALERANK = "app/salerank";
	private final String SERIESRANK = "app/seriesrank";
	public static final QueryId SERIESRANKID = new QueryId();
	public static final QueryId BUYERMANAGERID = new QueryId();
	public static final QueryId CLASZID = new QueryId();
	public static final QueryId SALERANKID = new QueryId();

	public void getClassNum(OnQueryCompleteListener onQueryCompleteListener,
			final Context context) {
		makeSimpleQuery(BUYERMANAGER, BUYERMANAGERID, onQueryCompleteListener);
	}

	public void getClasz(OnQueryCompleteListener onQueryCompleteListener,
			final Context context) {
		makeSimpleQuery(CLASZ, CLASZID, onQueryCompleteListener);
	}

	public void getSaleRank(OnQueryCompleteListener onQueryCompleteListener,
			final Context context) {
		makeSimpleQuery(SALERANK, SALERANKID, onQueryCompleteListener);
	}

	public void getSeriesRank(OnQueryCompleteListener onQueryCompleteListener,
			final Context context) {
		makeSimpleQuery(SERIESRANK, SERIESRANKID, onQueryCompleteListener);
	}

	private void makeSimpleQuery(String url, final QueryId flag,
			OnQueryCompleteListener onQueryCompleteListener) {
		List<BasicNameValuePair> parms = new ArrayList<BasicNameValuePair>();
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
