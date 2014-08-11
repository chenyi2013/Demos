package com.example.demos;

import java.util.ArrayList;

import com.viewpagerindicator.CirclePageIndicator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {

	private ViewPager mViewPager;
	private ViewPager mContentPager;
	private ContentFragmentAdapter mContentAdapter;
	private ArrayList<View> mViews;
	private ArrayList<Integer> mImages;
	private LayoutInflater mLayoutInflater;
	private CirclePageIndicator mIndicator;
	private CirclePageIndicator mContentIndicator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();

	}

	public void initView() {
		mLayoutInflater = getLayoutInflater();
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mContentPager = (ViewPager) findViewById(R.id.content);
		mViews = new ArrayList<View>();
		for (int i = 0; i < mImages.size(); i++) {

			View view = mLayoutInflater.inflate(R.layout.item, mViewPager,
					false);
			mViews.add(view);
		}
		mViewPager.setAdapter(new AdvAdapter());
		mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mViewPager);

		mContentIndicator = (CirclePageIndicator) findViewById(R.id.content_indicator);
		mContentAdapter = new ContentFragmentAdapter(
				getSupportFragmentManager());
		mContentPager.setAdapter(mContentAdapter);
		mContentIndicator.setViewPager(mContentPager);
		mContentIndicator.setFillColor(Color.RED);

	}

	public void initData() {
		mImages = new ArrayList<Integer>();
		mImages.add(R.drawable.a);
		mImages.add(R.drawable.b);
		mImages.add(R.drawable.c);
		mImages.add(R.drawable.d);
	}

	class AdvAdapter extends PagerAdapter {

		@Override
		public int getCount() {

			return mImages.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {

			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			ImageView imageView = (ImageView) mViews.get(position);
			imageView.setImageResource(mImages.get(position));
			container.addView(imageView);
			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

			container.removeView(mViews.get(position));

		}

	}

	class ContentFragmentAdapter extends FragmentPagerAdapter {

		public ContentFragmentAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return ContentFragment.getContentFragment();
		}

		@Override
		public int getCount() {
			return 4;
		}

	}
}
