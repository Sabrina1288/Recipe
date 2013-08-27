package de.tuxyhavoc.recipes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Debug;
import android.util.Log;

public final class RecipeDatabaseHelper extends SQLiteOpenHelper {

	public static final String TABLE_RECIPES = "recipes";
	public static final String TABLE_INGREDIENTS = "ingredients";
	public static final String TABLE_HAS_INGREDIENTS = "hasIngredients";
	public static final String TABLE_DIRECTIONS = "directions";
	
	public static final String COLUMN_RECIPES_ID = "recipeNumber";
	public static final String COLUMN_RECIPES_NAME = "name";
	public static final String COLUMN_RECIPES_DATE = "date";
	
	private static final String CREATE_RECIPE_TABLE = "create table " + TABLE_RECIPES + "("
			+ COLUMN_RECIPES_ID + " integer primary key autoincrement, "
			+ COLUMN_RECIPES_NAME + " varchar(128) not null, "
			+ COLUMN_RECIPES_DATE + " datetime default current_timestamp"
			+ ")";
	
	/* TODO Ich muss noch die anderen Spalten hinzufügen */
	
	private static final String DATABASE_NAME = "recipes.db";
	private static final int DATABASE_VERSION = 2;
	
	public RecipeDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		Log.e("Database", "creating Recipe Table");
		createRecipeTable(database);
		
		Log.e("Database", "creating Ingredients Table");
		createIngredientsTable(database);
		
		Log.e("Database", "creating hasIngredients table");
		createHasIngredientsTable(database);
		
		Log.e("Database", "creating Directions table");
		createDirectionsTable(database);
	}
	
	private void createRecipeTable(SQLiteDatabase database) {		
		database.execSQL(CREATE_RECIPE_TABLE);
		
		Log.d("DatabaseQuery",CREATE_RECIPE_TABLE);
	}
	
	private void createIngredientsTable(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		
	}
	
	private void createHasIngredientsTable(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		
	}
	
	private void createDirectionsTable(SQLiteDatabase database) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
