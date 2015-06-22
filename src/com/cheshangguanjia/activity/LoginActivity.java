package com.cheshangguanjia.activity;

import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.cheshangguanjia.connection.HttpUtils.EHttpError;
import com.cheshangguanjia.service.OnQueryCompleteListener;
import com.cheshangguanjia.service.QueryId;
import com.cheshangguanjia.service.UserManagerService;
import com.cheshangguanjia.utils.Utils;
import com.university.cheshangguanjia.R;

public class LoginActivity extends Activity implements OnClickListener,
		OnQueryCompleteListener {

	private EditText usernameView, passwordView;
	private RelativeLayout okButton;
	private UserManagerService managerService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initView();
	}

	public void initView() {
		usernameView = (EditText) findViewById(R.id.login_username);
		passwordView = (EditText) findViewById(R.id.login_userpwd);
		okButton = (RelativeLayout) findViewById(R.id.login_login_layout);
		okButton.setOnClickListener(this);

		managerService = new UserManagerService();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login_login_layout:
//			String username = usernameView.getText().toString();
//			String password = passwordView.getText().toString();
			String username="linjilong";
			String password="123456";
			if (username.equals("")) {
				Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
			} else if (password.equals("")) {
				Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
			} else {
				managerService.UserLogin(username, password, this);
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void onQueryComplete(QueryId queryId, Object result, EHttpError error) {
		if (result != null) {
			Map<String, Object> data = (Map<String, Object>) result;
			Utils.sid = data.get("sid").toString();
			System.out.println(Utils.sid);
			startActivity(new Intent(LoginActivity.this,
					ManagerHomeActivity.class));
		} else {
			Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
		}
	}

}
