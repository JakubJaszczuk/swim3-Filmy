package com.example.riper.swim3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public ImageView image;
		public TextView textTitle;
		public TextView textCategory;

		public ViewHolder(final View itemView) {
			super(itemView);
			image = (ImageView) itemView.findViewById(R.id.item_image);
			textTitle = (TextView) itemView.findViewById(R.id.item_text_title);
			textCategory = (TextView) itemView.findViewById(R.id.item_text_category);

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					DetailsActivity.start(itemView.getContext(), getAdapterPosition());
				}
			});
		}
	}

	public CustomAdapter() {}

	@Override
	public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		Context context = parent.getContext();
		View view = (View)LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		// Pobierz element i ustawiaj wartości
		Item item = DataSet.data.get(position);
		TextView textViewTitle = viewHolder.textTitle;
		textViewTitle.setText(item.title);
		TextView textViewCategory = viewHolder.textCategory;
		textViewCategory.setText(item.category);
		ImageView imageView = viewHolder.image;
		imageView.setImageResource(item.titleImage);
	}

	@Override
	public int getItemCount() {
		return DataSet.data.size();
	}

}
