package com.example.riper.swim3;

public class Item {
	String title;
	String category;
	int titleImage;
	int[] images;
	Actor[] actors;

	Item(String title, String category, int titleImage, int[] img){
		this.title = title;
		this.category = category;
		this.titleImage = titleImage;
		images = img;
	}

	Item(String title, String category, int titleImage, int[] img, Actor[] actors){
		this.title = title;
		this.category = category;
		this.titleImage = titleImage;
		images = img;
		this.actors = actors;
	}
}
