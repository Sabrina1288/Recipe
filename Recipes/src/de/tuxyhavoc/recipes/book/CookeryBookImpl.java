package de.tuxyhavoc.recipes.book;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class CookeryBookImpl implements CookeryBook {
	
	private SQLiteDatabase database;
	private RecipeDatabaseHelper databaseHelper;
	
	private TableRecipe recipes;
	private TableIngredients ingredients;
	private TableHasIngredients hasIngredients;
	private TableDirections directions;
	
	
	public CookeryBookImpl(Context context) {
		databaseHelper = new RecipeDatabaseHelper(context);
		
	}

	public void open(){
		database = databaseHelper.getWritableDatabase();
		
		recipes = new TableRecipe(database);
		ingredients = new TableIngredients(database);
		hasIngredients = new TableHasIngredients(database);
		directions = new TableDirections(database);
		
	}
	
	public void close(){
		database.close();
	}
	
	@Override
	public void addRecipe(Recipe recipe) {
		recipes.addRecipe(recipe);
	}

	@Override
	public void updateRecipe(Recipe recipe) {

	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Recipe> getRecipes() {
		
		TableRecipeIterator iterator = recipes.getAllRecipes();
		
		List<Recipe> recipeList = new ArrayList<Recipe>();
		
		while(iterator.hasNext()){
			RecipeDataset recipe = iterator.next();
			
			//populateRecipe(recipe);
			
			recipeList.add(recipe);
			
			
		}
		
		return recipeList;
	}


	private List<Ingredient> getIngredientsFromRecipeId(int id) {
		
		return null;
	}

}
