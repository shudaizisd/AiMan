package com.sdf.aiman.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sdf.aiman.R;
import com.sdf.aiman.model.CategoryInfo;

public class CarouselViewAdapter extends BaseAdapter {
	private Context mContext;
	private List<CategoryInfo> mList;

	public CarouselViewAdapter(Context mContext, List<CategoryInfo> mList) {
		this.mContext = mContext;
		this.mList = mList;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList == null ? null : mList.size();
	}

	@Override
	public CategoryInfo getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		CategoryInfo categoryInfo = getItem(position);
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_carousel_view, null);
			viewHolder = new ViewHolder();
			viewHolder.icon = (ImageView) convertView
					.findViewById(R.id.itemsIcon);
			viewHolder.msg = (TextView) convertView
					.findViewById(R.id.itemsText);
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.icon.setImageResource(categoryInfo.getIcon());
		viewHolder.msg.setText(categoryInfo.getMsg());

		return convertView;
	}

	class ViewHolder {
		private ImageView icon;
		private TextView msg;

	}
}
