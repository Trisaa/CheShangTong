package com.cheshangguanjia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.university.cheshangguanjia.R;

public class EditGuestDataActivity extends Activity implements OnClickListener {
	
	private ImageButton backView;
	private ImageButton commitView;
	private EditText editNameView, editPhoneView;
	private Button nameClearButton, phoneClearButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_guest_data);
		
		initView();
	}

	private void initView() {
		backView=(ImageButton) findViewById(R.id.goback);
		commitView=(ImageButton) findViewById(R.id.saveguestdata);
		editNameView=(EditText) findViewById(R.id.editTextName);
		editPhoneView=(EditText) findViewById(R.id.carguestName);
		nameClearButton=(Button) findViewById(R.id.btn_clear);
		phoneClearButton=(Button) findViewById(R.id.namebtn_clear);
		
		backView.setOnClickListener(this);
		commitView.setOnClickListener(this);
		
		editNameView.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(start>0||count>0){
					nameClearButton.setVisibility(View.VISIBLE);
				}else{
					nameClearButton.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		editPhoneView.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(count>0){
					phoneClearButton.setVisibility(View.VISIBLE);
				}else{
					phoneClearButton.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.goback:
			finish();
			break;
		case R.id.saveguestdata:
			break;
		default:
			break;
		}
	}

}
