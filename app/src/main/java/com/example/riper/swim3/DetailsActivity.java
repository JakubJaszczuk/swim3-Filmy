package com.example.riper.swim3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

	private static final String key = "itemIndex";
	Item item;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		setData();
		setViewPager();
	}

	@Override
	public boolean onSupportNavigateUp() {
		onBackPressed();
		return true;
	}

	private void setData(){
		item = DataSet.data.get(this.getIntent().getExtras().getInt(key, 0));
		TextView title = (TextView) findViewById(R.id.activity_details_title);
		TextView category = (TextView) findViewById(R.id.activity_details_category);
		ImageView image = (ImageView) findViewById(R.id.activity_details_image);
		title.setText(item.title);
		category.setText(item.category);
		image.setImageResource(item.titleImage);
	}

	private void setViewPager(){
		ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
		pager.setAdapter(new CustomAdapter(getSupportFragmentManager()));
	}

	public static void start(Context context, int value) {
		Intent starter = new Intent(context, DetailsActivity.class);
		starter.putExtra(key, value);
		context.startActivity(starter);
	}

	private class CustomAdapter extends FragmentPagerAdapter {

		public CustomAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch(position) {
				case 0: return ImagesFragment.newInstance(DataSet.data.indexOf(item));
				case 1: return ActorsFragment.newInstance(DataSet.data.indexOf(item));
				default: return ActorsFragment.newInstance(DataSet.data.indexOf(item));
			}
		}

		@Override
		public int getCount() {
			return 2;
		}
	}
}
