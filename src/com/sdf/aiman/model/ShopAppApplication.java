package com.sdf.aiman.model;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;

import com.sdf.aiman.utils.Constas;
import com.sdf.aiman.utils.LogUtil;

public class ShopAppApplication extends Application {

	public static List<CategoryInfo> mDatas;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		LogUtil.LogMsg("----oncreate start----");

		mDatas = new ArrayList<CategoryInfo>();
		for (int i = 0; i < Constas.category_msg.length; i++) {
			CategoryInfo categoryInfo2 = new CategoryInfo();
			categoryInfo2.setIcon(Constas.categoory_icon[i]);
			categoryInfo2.setMsg(Constas.category_msg[i]);
			mDatas.add(categoryInfo2);

		}

	}

	public ShopAppApplication() {

		LogUtil.LogMsg("---------------------ShopAppApplication start-------------");

	}

}
