package com.example.demos;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentFragment extends Fragment {

	private static ContentFragment mContentFragment;
	private GridView mContentGridViewView;
	private LayoutInflater mLayoutInflater;
	private List<Content> mContents;
	private ContentAdapter mAdapter;

	private ContentFragment() {

	}

	public static ContentFragment getContentFragment(Bundle bundle) {
		mContentFragment = new ContentFragment();
		if (bundle != null) {
			mContentFragment.setArguments(bundle);
		}
		return mContentFragment;

	}

	public static ContentFragment getContentFragment() {
		return getContentFragment(null);
	}

	public void initData() {
		mContents = new ArrayList<Content>();
		mContents.add(new Content(R.drawable.ic_launcher, "中国"));
		mContents.add(new Content(R.drawable.ic_launcher, "中国"));
		mContents.add(new Content(R.drawable.ic_launcher, "中国"));
		mContents.add(new Content(R.drawable.ic_launcher, "中国"));
		mContents.add(new Content(R.drawable.ic_launcher, "中国"));
		mContents.add(new Content(R.drawable.ic_launcher, "中国"));
		mContents.add(new Content(R.drawable.ic_launcher, "中国"));
		mContents.add(new Content(R.drawable.ic_launcher, "中国"));
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		return inflater.inflate(R.layout.content_frament_layout, container,
				false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		if (getActivity() != null) {
			mLayoutInflater = getActivity().getLayoutInflater();
		}

		initData();

		mContentGridViewView = (GridView) getView().findViewById(
				R.id.content_grid_view);
		mAdapter = new ContentAdapter();
		mAdapter.setData(mContents);
		mContentGridViewView.setAdapter(mAdapter);

	}

	class ContentAdapter extends BaseAdapter {

		private List<Content> data = new ArrayList<Content>();

		public void setData(List<Content> data) {
			if (data != null) {
				this.data = data;
			}
		}

		@Override
		public int getCount() {
			return mContents.size();
		}

		@Override
		public Object getItem(int position) {

			return mContents.get(position);
		}

		@Override
		public long getItemId(int id) {

			return id;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup container) {

			ViewHolder viewHolder = null;
			if (convertView == null) {
				convertView = mLayoutInflater.inflate(
						R.layout.content_fragment_item, container, false);
				viewHolder = new ViewHolder();
				viewHolder.contentIcon = (ImageView) convertView
						.findViewById(R.id.content_icon);
				viewHolder.contentTitle = (TextView) convertView
						.findViewById(R.id.content_title);
				convertView.setTag(viewHolder);
			}

			viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.contentIcon.setImageResource(mContents.get(position)
					.getImage());
			viewHolder.contentTitle.setText(mContents.get(position).getTitle());

			return convertView;
		}

	}

	class ViewHolder {
		ImageView contentIcon;
		TextView contentTitle;
	}

}
