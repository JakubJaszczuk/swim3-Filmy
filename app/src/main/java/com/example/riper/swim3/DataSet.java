package com.example.riper.swim3;

import java.util.ArrayList;
import java.util.Arrays;

public class DataSet {

	public static Actor actors[] = {
			new Actor("Tim", "Robbins", 43, R.drawable.ac1),
			new Actor("Morgan", "Freeman", 57, R.drawable.ac2),
			new Actor("Mark", "Hamill", 63, R.drawable.ac3),
			new Actor("Johnny", "Depp", 45, R.drawable.ac4),
			new Actor("Piotr", "Adamczyk", 35, R.drawable.ac5),
			new Actor("Mirosław", "Zbrojewicz", 61, R.drawable.ac6),
			new Actor("Piotr", "Fronczewski", 71, R.drawable.ac7)
	};

	static int[] images1 = {R.drawable.img1, R.drawable.img12, R.drawable.img13};
	static int[] images2 = {R.drawable.img21, R.drawable.img22, R.drawable.img23, R.drawable.img24};
	static int[] images3 = {R.drawable.img31, R.drawable.img32, R.drawable.img33, R.drawable.img34, R.drawable.img35, R.drawable.img36, R.drawable.img37, R.drawable.img38};
	static int[] images4 = {R.drawable.img41, R.drawable.img42};

	static Actor[] actors1 = {actors[1], actors[2], actors[3], actors[4], actors[5], actors[6], actors[0]};
	static Actor[] actors2 = {actors[3], actors[4], actors[6], actors[5]};
	static Actor[] actors3 = {actors[5], actors[2], actors[4], actors[0], actors[5]};
	static Actor[] actors4 = {actors[0], actors[1], actors[0], actors[2], actors[5], actors[6], actors[3]};

	public static Item[] array = {
			new Item("Interstellar", "Sci-Fi", R.drawable.img1, images1, actors1),
			new Item("Skazani na Shawshank", "Dramat", R.drawable.img21, images2, actors2),
			new Item("Gwiezdne wojny: Ostatni Jedi", "Fantasy", R.drawable.img31, images3, actors3),
			new Item("Piraci z Karaibów: Klątwa Czarnej Perły", "Przygodowy", R.drawable.img41, images4, actors4)
	};

	public static ArrayList<Item> data = new ArrayList<>(Arrays.asList(array));

	DataSet(){}
}
