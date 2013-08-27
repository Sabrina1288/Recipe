package de.tuxyhavoc.recipes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class CookeryBookImpl implements CookeryBook {
	
	private SQLiteDatabase database;
	private RecipeDatabaseHelper databaseHelper;
	
	public CookeryBookImpl(Context context) {
		databaseHelper = new RecipeDatabaseHelper(context);
		database = databaseHelper.getWritableDatabase();
	}

	@Override
	public void addRecipe(Recipe recipe) {
		// TODO das ist nur eine dummy funktion die immer das selbe hinzufügt
		
		//database.insert(RecipeDatabaseHelper.TABLE_RECIPES, nullColumnHack, values)
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Recipe> getRecipes() {
		
		Cursor recipeCursor = getRecipeCursor();
		recipeCursor.moveToFirst();
		
		List<Recipe> recipeList = new ArrayList<Recipe>();
		
		while(!recipeCursor.isAfterLast()){
			Recipe recipe = createRecipe(recipeCursor);
			recipeList.add(recipe);
		}
		
		return recipeList;
	}

	private Recipe createRecipe(Cursor recipeCursor) {
		RecipeDataset recipe = new RecipeDataset();
		
		recipe.setId(recipeCursor.getInt(0));
		recipe.setName(recipeCursor.getString(1));
		
		String dateString = recipeCursor.getString(2);
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateString, Locale.getDefault());
		
		recipe.setCreationDate(dateFormat);
		
		return recipe;
	}

	private Cursor getRecipeCursor() {
		String table = RecipeDatabaseHelper.TABLE_RECIPES;
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
		
		return recipeCursor;
	}

}
