package com.example.riper.swim3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ActorsFragment extends Fragment {

	private static final String key = "itemIndex";

	private RecyclerView recyclerView;
	private ActorsAdapter adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.actors_layout, container, false);
		initRecyclerView(v);
		return v;
	}

	public static ActorsFragment newInstance(int itemIndex) {
		ActorsFragment fragment = new ActorsFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(key, itemIndex);
		fragment.setArguments(bundle);
		return fragment;
	}

	private void initRecyclerView(View v){
		recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		Actor[] actors = DataSet.data.get(ActorsFragment.this.getArguments().getInt(key)).actors;
		adapter = new ActorsAdapter(actors);
		recyclerView.setAdapter(adapter);
	}
}
