package com.example.riper.swim3;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.os.Bundle;

import android.support.v7.widget.helper.ItemTouchHelper;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initRecyclerView();
	}

	private void initRecyclerView(){
		recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		adapter = new CustomAdapter();
		recyclerView.setAdapter(adapter);
		ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

			@Override
			public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
				return false;
			}

			@Override
			public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
				final int position = viewHolder.getAdapterPosition();
				DataSet.data.remove(position);
				adapter.notifyItemRemoved(position);
			}
		};
		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
		itemTouchHelper.attachToRecyclerView(recyclerView);
	}
}
