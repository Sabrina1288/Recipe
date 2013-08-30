package de.tuxyhavoc.recipes.book;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public final class RecipeDatabaseHelper extends SQLiteOpenHelper {

	public static final String TABLE_DIRECTIONS = "directions";

	
	/* TODO Ich muss noch die anderen Spalten hinzufügen */
	
	private static final String DATABASE_NAME = "recipes.db";
	private static final int DATABASE_VERSION = 2;
	
	private TableRecipe recipeTable;
	private TableIngredients ingredientsTable;
	private TableHasIngredients hasIngredientsTable;
	private TableDirections directionsTable;
	
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
		
		recipeTable = new TableRecipe(database);
		recipeTable.create();
	}
	
	private void createIngredientsTable(SQLiteDatabase database) {
		ingredientsTable = new TableIngredients(database);
		ingredientsTable.create();
	}
	
	private void createHasIngredientsTable(SQLiteDatabase database) {
		hasIngredientsTable = new TableHasIngredients(database);		
		hasIngredientsTable.create();
	}
	
	private void createDirectionsTable(SQLiteDatabase database) {
		directionsTable = new TableDirections(database);
		directionsTable.create();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
