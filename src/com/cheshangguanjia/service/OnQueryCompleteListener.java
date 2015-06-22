package com.cheshangguanjia.service;

import com.cheshangguanjia.connection.HttpUtils;


public interface OnQueryCompleteListener {
    public abstract void onQueryComplete(QueryId queryId, Object result, HttpUtils.EHttpError error);
}
