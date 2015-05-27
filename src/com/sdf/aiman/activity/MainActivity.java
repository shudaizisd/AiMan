package com.sdf.aiman.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.Menu;
import android.view.MenuItem;

import com.sdf.aiman.R;
import com.sdf.aiman.fragment.HomeFrameFragment;

public class MainActivity extends BaseActivity {
	private HomeFrameFragment homeFrameFragment;

	public MainActivity() {
		super(R.string.viewpager);
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	/**
	 * 初始化数据
	 */
	private void init() {
		// 加载首页fragment
		homeFrameFragment = new HomeFrameFragment();
		replaceFragment(homeFrameFragment);
	}

	/**
	 * 替换fragment
	 */
	private void replaceFragment(Fragment fragment) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fl_Container, fragment).commit();

	}

	/**
	 * 选择加载一个新的Fragment
	 */
	public void switchNewFragment(Fragment newFragment) {
		replaceFragment(newFragment);
		getSlidingMenu().showContent();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
