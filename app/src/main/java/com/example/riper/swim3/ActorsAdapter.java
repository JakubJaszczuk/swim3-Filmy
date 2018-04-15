package com.example.riper.swim3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ActorsAdapter extends RecyclerView.Adapter<ActorsAdapter.ViewHolder>{

	private Actor[] actors;

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public ImageView image;
		public TextView textName;
		public TextView textAge;

		public ViewHolder(final View itemView) {
			super(itemView);
			image = (ImageView) itemView.findViewById(R.id.actor_image);
			textName = (TextView) itemView.findViewById(R.id.actor_name);
			textAge = (TextView) itemView.findViewById(R.id.actor_age);
		}
	}

	public ActorsAdapter(Actor[] actors) {
		this.actors = actors;
	}

	@Override
	public ActorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		Context context = parent.getContext();
		View view = (View)LayoutInflater.from(context).inflate(R.layout.actor_layout, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		// Pobierz element i ustawiaj wartości
		Actor actor = actors[position];
		TextView textViewName = viewHolder.textName;
		String toDisplay = actor.name + " " + actor.surname;
		textViewName.setText(toDisplay);
		TextView textViewAge = viewHolder.textAge;
		textViewAge.setText(Integer.toString(actor.age));
		ImageView imageView = viewHolder.image;
		imageView.setImageResource(actor.image);
	}

	@Override
	public int getItemCount() {
		return actors.length;
	}

}
