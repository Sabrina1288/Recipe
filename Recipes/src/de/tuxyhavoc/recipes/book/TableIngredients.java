package de.tuxyhavoc.recipes.book;

import android.database.sqlite.SQLiteDatabase;

public class TableIngredients {

	public static final String TABLE_INGREDIENTS = "ingredients";

	public static final String COLUMN_ID = "ingredientNumber";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_CALORIES = "calories";
	public static final String COLUMN_FAT = "fat";
	public static final String COLUMN_PROTEIN = "protein";
	public static final String COLUMN_CARBOHYDRATE = "carbohydrate";
	public static final String COLUMN_TYPE = "type";

	private static final String CREATE_INGREDIENTS_TABLE = "create table " + TABLE_INGREDIENTS + "("
			+ COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_NAME + " varchar(128) not null, "
			+ COLUMN_CALORIES + " integer, "
			+ COLUMN_FAT + " integer, "
			+ COLUMN_PROTEIN + " integer, "
			+ COLUMN_CARBOHYDRATE + " integer, "
			+ COLUMN_TYPE + " varchar(32))";

	private SQLiteDatabase database;
	
	public TableIngredients(SQLiteDatabase database) {
		this.database = database;
	}

	public void create() {
		database.execSQL(CREATE_INGREDIENTS_TABLE);
	}

	public TableIngredientsIterator getAllIngredients(){
		
		
		/* TODO  make this work */
		
		return null;
	}
}
