package com.sdf.aiman.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ab.view.carousel.CarouselAdapter;
import com.ab.view.carousel.CarouselAdapter.OnItemClickListener;
import com.ab.view.carousel.CarouselAdapter.OnItemSelectedListener;
import com.ab.view.carousel.CarouselView;
import com.ab.view.carousel.CarouselViewAdapter;
import com.sdf.aiman.R;
import com.sdf.aiman.model.CategoryInfo;
import com.sdf.aiman.utils.Constas;

/**
 * 分类的fragment
 *
 */
public class CategoryFragment extends Fragment implements OnItemClickListener,
		OnItemSelectedListener {
	private CarouselView carouselView;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// 得到图片数据
		getCategoryData();
		super.onActivityCreated(savedInstanceState);
	}

	private void getCategoryData() {
		// 不支持的动态添加adapter.notifyDataSetChanged()增强滑动的流畅
		List<View> mViews = new ArrayList<View>();
		List<CategoryInfo> data = new ArrayList<CategoryInfo>();
		for (int i = 0; i < Constas.category_msg.length; i++) {

			CategoryInfo categoryInfo2 = new CategoryInfo();
			categoryInfo2.setIcon(Constas.categoory_icon[i]);
			categoryInfo2.setMsg(Constas.category_msg[i]);
			data.add(categoryInfo2);

		}
		for (int i = 0; i < data.size(); i++) {
			View view = getActivity().getLayoutInflater().inflate(
					R.layout.item_carousel_view, null);
			ImageView icon = (ImageView) view.findViewById(R.id.itemsIcon);
			icon.setImageResource(data.get(i).getIcon());

			TextView msg = (TextView) view.findViewById(R.id.itemsText);
			msg.setText(data.get(i).getMsg());
			mViews.add(view);

		}
		CarouselViewAdapter adapter = new CarouselViewAdapter(getActivity(),
				mViews, false);

		carouselView.setOnItemClickListener(this);
		carouselView.setOnItemSelectedListener(this);
		carouselView.setAdapter(adapter);
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
		View v = inflater.from(getActivity()).inflate(
				R.layout.fragment_category, null);
		return v;
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		carouselView = (CarouselView) view.findViewById(R.id.carouesl);
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onItemClick(CarouselAdapter<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(), "点击了", 1000).show();
	}

	@Override
	public void onItemSelected(CarouselAdapter<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getActivity(),
				"选择了" + carouselView.getItemAtPosition(position).toString(),
				1000).show();

	}

	@Override
	public void onNothingSelected(CarouselAdapter<?> parent) {
		// TODO Auto-generated method stub

	}
}
