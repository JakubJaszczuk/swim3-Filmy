package com.example.riper.swim3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImagesFragment extends Fragment {

	private static final String key = "itemIndex";
	private static final int height = 150;
	private static final int columns = 3;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.images_fragment, container, false);
		GridView gridview = (GridView) view.findViewById(R.id.grid_view);
		ImageAdapter adapter = new ImageAdapter(getActivity());
		gridview.setNumColumns(columns);
		adapter.set();
		gridview.setAdapter(adapter);
		return view;
	}

	public static ImagesFragment newInstance(int itemIndex) {
		ImagesFragment fragment = new ImagesFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(key, itemIndex);
		fragment.setArguments(bundle);
		return fragment;
	}

	class ImageAdapter extends BaseAdapter {
		private Context context;
		private int[] images;

		void set(){
			images = DataSet.data.get(ImagesFragment.this.getArguments().getInt(key)).images;
		}

		public ImageAdapter(Context context) {
			this.context = context;
		}

		public int getCount() {
			return images.length;
		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			imageView = new ImageView(context);
			imageView.setLayoutParams(new ViewGroup.LayoutParams(parent.getWidth() / columns, height));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(0, 0, 0, 0);
			imageView.setImageResource(images[position]);
			FrameLayout frameLayout = (FrameLayout) getActivity().findViewById(R.id.frame_layout);
			//frameLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height * ((int)Math.ceil(images.length / (double)columns))));
			// Jakiekolwiek wariacje i tak ustawiają wielkośc na (0, 0)
			//frameLayout.setLayoutParams(new ConstraintLayout.LayoutParams(200, 150));
			return imageView;
		}

		@Nullable
		@Override
		public CharSequence[] getAutofillOptions() {
			return new CharSequence[0];
		}
	}
}
