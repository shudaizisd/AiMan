package com.sdf.aiman.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.sdf.aiman.R;
import com.sdf.aiman.activity.MainActivity;

public class HomeFrameFragment extends Fragment implements OnClickListener,
		OnCheckedChangeListener {
	private ImageButton ibtn_left_menu;
	// 四个fragment
	private HomeFragment homeFragment;
	private CategoryFragment categoryFragment;
	private HotFragment hotFragment;
	private AboutFragment aboutFragment;
	// 四个fragment的tag
	public final static String TAG_HOME = "HOME";
	public final static String TAG_CATEGORY = "CATEGORY";
	public final static String TAG_HOT = "HOT";
	public final static String TAG_ABOUT = "ABOUT";
	// 显示radiogroup
	private RadioGroup rg_home_tab_menu;

	private FragmentManager mFragmentManager;
	private FragmentTransaction mFragmentTransaction;
	private String hideTag;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_home_frame, null);
		return view;
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		ibtn_left_menu = (ImageButton) view.findViewById(R.id.ibtn_left_menu);
		ibtn_left_menu.setOnClickListener(this);

		rg_home_tab_menu = (RadioGroup) view.findViewById(R.id.rg_tab_menu);
		// 设置第一个radiobutton为选中状态
		RadioButton rb = (RadioButton) rg_home_tab_menu.getChildAt(0);
		rb.setChecked(true);
		// 设置监听器
		rg_home_tab_menu.setOnCheckedChangeListener(this);
		homeFragment = new HomeFragment();
		switchFragment(homeFragment, TAG_HOME);

	}

	/**
	 * 选择不同的fragment
	 * 
	 * @param frgament
	 * @param tag
	 */
	public void switchFragment(Fragment fragment, String tag) {
		// 在fragment里嵌套fragment一定要用getChildFragmentManager
		mFragmentManager = getChildFragmentManager();
		mFragmentTransaction = mFragmentManager.beginTransaction();

		Fragment tagFragment = mFragmentManager.findFragmentByTag(tag);
		if (tagFragment == null) {
			mFragmentTransaction.add(R.id.fl_tab_menu, fragment, tag);

		} else {
			mFragmentTransaction.show(tagFragment);
		}
		tagFragment = mFragmentManager.findFragmentByTag(hideTag);
		if (tagFragment != null) {
			mFragmentTransaction.hide(tagFragment);
		}
		hideTag = tag;
		mFragmentTransaction.commit();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ibtn_left_menu:
			((MainActivity) getActivity()).showMenu();
			break;

		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rbtn_one:
			if (homeFragment == null) {
				homeFragment = new HomeFragment();

			}
			switchFragment(homeFragment, TAG_HOME);
			break;
		case R.id.rbtn_two:
			if (categoryFragment == null) {
				categoryFragment = new CategoryFragment();

			}
			switchFragment(categoryFragment, TAG_CATEGORY);
			break;
		case R.id.rbtn_three:
			if (hotFragment == null) {
				hotFragment = new HotFragment();

			}
			switchFragment(hotFragment, TAG_HOT);
			break;
		case R.id.rbtn_four:
			if (aboutFragment == null) {
				aboutFragment = new AboutFragment();

			}
			switchFragment(aboutFragment, TAG_ABOUT);
			break;
		}
	}
}
