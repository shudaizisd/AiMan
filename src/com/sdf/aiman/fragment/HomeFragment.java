package com.sdf.aiman.fragment;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sdf.aiman.R;
import com.sdf.aiman.adapter.CategoryAdapter;
import com.sdf.aiman.adapter.RecommendAdapter;
import com.sdf.aiman.adapter.ViewPagerAdvAdapter;
import com.sdf.aiman.model.CategoryInfo;
import com.sdf.aiman.model.ShopAppApplication;

public class HomeFragment extends Fragment {
	private ViewPager vp_ad;
	private ImageView[] mImageViews;
	private TextView tv_title;
	private int currentPosition = 0;
	private GridView gv_category, gv_recommend;

	private List<CategoryInfo> mList = new ArrayList<CategoryInfo>();
	// 定义了recommend的图片和文字数组
	int[] recommend_icon = new int[] { R.drawable.huoying_bg,
			R.drawable.haizie_bg, R.drawable.heizi, R.drawable.sishen_bg };
	String[] recommend_msg = new String[] { "火影忍者", "海贼王", "黑子的篮球", "死神" };

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 获得服务端广告图片，这里我们就简单的直接取本地数据
		getAdData();
		getCategoryData();
		getRecommedData();
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
		return inflater.inflate(R.layout.fragment_home, null);
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
		vp_ad = (ViewPager) view.findViewById(R.id.vp_ad);
		tv_title = (TextView) view.findViewById(R.id.tv_title);
		// 来创建viewpager里面的游标圆点图
		gv_category = (GridView) view.findViewById(R.id.gv_category);
		gv_recommend = (GridView) view.findViewById(R.id.gv_recommend);
		createPoint(view);
	}

	public void createPoint(View view) {
		LinearLayout ll = (LinearLayout) view.findViewById(R.id.llayout);
		LinearLayout.LayoutParams paramas = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		paramas.setMargins(0, 0, 12, 0);
		mImageViews = new ImageView[5];
		for (int i = 0; i < mImageViews.length; i++) {
			mImageViews[i] = new ImageView(getActivity());
			mImageViews[i].setImageResource(R.drawable.guide_round);
			mImageViews[i].setEnabled(true);
			mImageViews[i].setLayoutParams(paramas);
			ll.addView(mImageViews[i]);

		}
		mImageViews[currentPosition].setEnabled(false);

	}

	public void getAdData() {

		List<Integer> list = new ArrayList<Integer>();

		list.add(R.drawable.huoying);
		list.add(R.drawable.caomao);
		list.add(R.drawable.yaowei);
		list.add(R.drawable.yinhun);
		list.add(R.drawable.diguang);

		vp_ad.setAdapter(new ViewPagerAdvAdapter(getActivity(), list));
		vp_ad.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				super.onPageSelected(position);
				setCurPoint(position);
			}
		});
	}

	public void setCurPoint(int index) {
		if (index < 0 || index > mImageViews.length || index == currentPosition) {
			return;
		}
		mImageViews[currentPosition].setEnabled(true);
		mImageViews[index].setEnabled(false);
		switch (index) {
		case 0:
			tv_title.setText("火影忍者");
			break;
		case 1:
			tv_title.setText("海贼王");
			break;
		case 2:
			tv_title.setText("妖精的尾巴");
			break;
		case 3:
			tv_title.setText("银魂");
			break;
		case 4:
			tv_title.setText("黑子的篮球");
			break;

		}
		currentPosition = index;
	}

	/**
	 * 获得gridView分类的数据
	 */
	public void getCategoryData() {
		gv_category.setSelector(new ColorDrawable(Color.TRANSPARENT));

		gv_category.setAdapter(new CategoryAdapter(getActivity(),
				ShopAppApplication.mDatas));

	}

	/**
	 * 获取gridView推荐漫画的数据
	 */
	public void getRecommedData() {
		List<CategoryInfo> list2 = new ArrayList<CategoryInfo>();
		for (int i = 0; i < recommend_icon.length; i++) {

			CategoryInfo categoryInfo = new CategoryInfo();
			categoryInfo.setIcon(recommend_icon[i]);
			categoryInfo.setMsg(recommend_msg[i]);
			list2.add(categoryInfo);
		}
		gv_recommend.setSelector(new ColorDrawable(Color.TRANSPARENT));
		gv_recommend.setAdapter(new RecommendAdapter(getActivity(), list2));

	}
}
