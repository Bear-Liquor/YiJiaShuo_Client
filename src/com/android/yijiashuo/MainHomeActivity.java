package com.android.yijiashuo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.android.View.ActionBarItemView;

public class MainHomeActivity extends Activity {
	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initView();
	}

	private void initView(){
		ActionBarItemView actionBarItemView = (ActionBarItemView) findViewById(R.id.action_bar);
		actionBarItemView.setOnActionBarClickListener(new ActionBarItemView.OnActionBarClickListener() {
			@Override
			public void click(String tag) {
				if(ActionBarItemView.RIGHT_IMG_TAG.equals(tag)){
					Toast.makeText(MainHomeActivity.this,tag,Toast.LENGTH_SHORT).show();
				}else if(ActionBarItemView.LEFT_IMG_TAG.equals(tag)){
					Toast.makeText(MainHomeActivity.this,tag,Toast.LENGTH_SHORT).show();
				}else if(ActionBarItemView.RIGHT_TEXT_TAG.equals(tag)){
					Toast.makeText(MainHomeActivity.this,tag,Toast.LENGTH_SHORT).show();
				}else if(ActionBarItemView.LEFT_TEXT_TAG.equals(tag)){
					Toast.makeText(MainHomeActivity.this,tag,Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
