package de.tuxyhavoc.recipes.book;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;

public class TableHasIngredients {

	private TableRecipe recipes;
	private TableIngredients ingredients;
	
	private SQLiteDatabase database;
	
	public static final String TABLE_HAS_INGREDIENTS = "hasIngredients";
	
	public static final String COLUMN_RECIPE_ID = "recipeNumber";
	public static final String COLUMN_INGREDIENT_ID = "ingredientNumber";
	public static final String COLUMN_AMOUNT = "amount";
	public static final String COLUMN_UNIT = "unit";
	
	private static final String CREATE_HASINGREDIENT_TABLE = "create table " + TABLE_HAS_INGREDIENTS + "("
			+ COLUMN_RECIPE_ID + " integer primary key, "
			+ COLUMN_INGREDIENT_ID + " integer primary key, "
			+ COLUMN_AMOUNT + " integer, "
			+ COLUMN_UNIT + " varchar(32)"
			+ ")";
	
	public TableHasIngredients(SQLiteDatabase database) {
		this.database = database;
		
		recipes = new TableRecipe(database);
		ingredients = new TableIngredients(database);
	}

	public void create() {
		database.execSQL(CREATE_HASINGREDIENT_TABLE);
	}

	public List<Ingredient> getIngredientsFromRecipe(Recipe recipe) {
		
		//String
		
		//String sql_query = "SELECT "
		
		
		return null;
	}

}
