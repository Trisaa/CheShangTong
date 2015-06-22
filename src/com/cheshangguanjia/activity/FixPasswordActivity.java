package com.cheshangguanjia.activity;

import com.university.cheshangguanjia.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class FixPasswordActivity extends Activity implements OnClickListener{
	private EditText oldpassword,newpassword,repassword;
	private ImageButton backButton;
	private Button okButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fixpassword);
		initView();
	}
	
	public void initView(){
		oldpassword = (EditText)findViewById(R.id.password);
		newpassword = (EditText)findViewById(R.id.newpassword);
		repassword = (EditText)findViewById(R.id.repassword);
		backButton = (ImageButton)findViewById(R.id.goback);
		okButton = (Button)findViewById(R.id.okbutton);
		
		backButton.setOnClickListener(this);
		okButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.okbutton:
			finish();
			break;
			

		default:
			break;
		}
	}

}
