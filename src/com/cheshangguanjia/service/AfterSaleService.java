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

public class AfterSaleService {

	private final String CUSTERMANAGE = "app/custermanage";
	private final String SARANK = "app/sarank";
	private final String CUSTERSERIES = "app/custerseries";
	public final static QueryId CUSTERSERIESID = new QueryId();
	public final static QueryId CUSTERMANAGEID = new QueryId();
	public final static QueryId SARANKID = new QueryId();

	public void getCuster(OnQueryCompleteListener onQueryCompleteListener,
			final Context context) {
		makeSimpleQuery(CUSTERMANAGE, CUSTERMANAGEID, onQueryCompleteListener);
	}

	public void getSaRank(OnQueryCompleteListener onQueryCompleteListener,
			final Context context) {
		makeSimpleQuery(SARANK, SARANKID, onQueryCompleteListener);
	}

	public void getCusterSerise(
			OnQueryCompleteListener onQueryCompleteListener,
			final Context context) {
		makeSimpleQuery(CUSTERSERIES, CUSTERSERIESID, onQueryCompleteListener);
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
