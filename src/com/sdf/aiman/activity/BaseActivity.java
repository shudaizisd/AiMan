package com.sdf.aiman.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.sdf.aiman.R;
import com.sdf.aiman.fragment.SlideMenuFragment;

public class BaseActivity extends SlidingFragmentActivity {
	private int mTitleRes;
	private SlideMenuFragment slideMenu;

	/* �˳��ļ��ʱ�� */
	private static final long EXIT_INTERVAL_TIME = 2000;
	private long touchTime = 0;

	public BaseActivity(int titleRes) {
		mTitleRes = titleRes;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setTitle(mTitleRes);

		// ���ص�slidingmenu
		setBehindContentView(R.layout.menu_frame);

		FragmentManager fm = getSupportFragmentManager();
		if (savedInstanceState == null) {
			FragmentTransaction ft = fm.beginTransaction();
			slideMenu = new SlideMenuFragment();
			ft.replace(R.id.menu_frame, slideMenu);
			ft.commit();
		} else {
			slideMenu = (SlideMenuFragment) fm
					.findFragmentById(R.id.menu_frame);

		}
		// ���slidingmenu
		SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		// SlidingMenu����ʱ��ҳ����ʾ��ʣ����
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

	}

	private void toastMSG(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& getSlidingMenu().isMenuShowing()) {

			long currentTime = System.currentTimeMillis();
			if ((currentTime - touchTime) >= EXIT_INTERVAL_TIME) {
				toastMSG("�ٰ�һ���˳�����");
				touchTime = currentTime;

			} else {
				finish();
				System.exit(0);

			}
			return false;

		} else {
			getSlidingMenu().showMenu();
			return true;
		}

	}

}
