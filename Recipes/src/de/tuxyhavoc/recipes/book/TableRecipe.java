package de.tuxyhavoc.recipes.book;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TableRecipe{
	
	private static final String TABLE_RECIPES = "recipes";
	
	private static final String COLUMN_ID = "recipeNumber";
	private static final String COLUMN_NAME = "name";
	private static final String COLUMN_DATE = "date";

	private static final String CREATE_RECIPE_TABLE = "create table " + TABLE_RECIPES + "("
			+ COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_NAME + " varchar(128) not null, "
			+ COLUMN_DATE + " datetime default current_timestamp"
			+ ")";
	
	private SQLiteDatabase database;
	
	public TableRecipe(SQLiteDatabase database){
		this.database = database;
	}
	
	public void create(){
		database.execSQL(CREATE_RECIPE_TABLE);
	}	
	
	public void addRecipe(Recipe recipe){
		ContentValues values = new ContentValues();
		
		values.put(COLUMN_ID, recipe.getId());
		values.put(COLUMN_NAME, recipe.getName());
		values.put(COLUMN_DATE, recipe.getDate());
				
		database.insert(TABLE_RECIPES, null, values);		
	}

	public TableRecipeIterator getAllRecipes() {
		
		String table = TABLE_RECIPES;
		String[] columns = null;
		String selection = null;
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = null;
		String limit = null;
		
		
		Cursor recipeCursor = database.query(table, columns, 
				selection, selectionArgs, 
				groupBy, having, orderBy, 
				limit);
		
		return new TableRecipeIterator(recipeCursor);
	}	
}
