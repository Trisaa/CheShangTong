package com.cheshangguanjia.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;

import com.cheshangguanjia.connection.HttpUtils;
import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.cheshangguanjia.utils.EncodeUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class UserManagerService {

	private static final String LOGIN = "app/login";
	public static final QueryId LOGINID = new QueryId();

	public void UserLogin(String username, String password,
			OnQueryCompleteListener onQueryCompleteListener) {
		List<BasicNameValuePair> parms = new ArrayList<BasicNameValuePair>();
		password = EncodeUtils.byteMD5_32(password.getBytes());
		parms.add(new BasicNameValuePair("username", username));
		parms.add(new BasicNameValuePair("password", password));
		HttpUtils.makeAsyncPost(LOGIN, parms, new QueryCompleteHandler(
				onQueryCompleteListener, new QueryId()) {
			@Override
			public void handleResponse(String jsonResult, EHttpError error) {
				Map<String, Object> data;
				if (jsonResult != null && error == EHttpError.KErrorNone) {
					Gson gson = new Gson();
					Type type = new TypeToken<Map<String, Object>>() {
					}.getType();
					data = gson.fromJson(jsonResult, type);
					this.completeListener.onQueryComplete(LOGINID, data, error);
				} else {
					this.completeListener.onQueryComplete(new QueryId(),
							jsonResult, error);
				}
			}
		});
	}
}
