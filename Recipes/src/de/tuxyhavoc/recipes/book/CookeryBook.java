package de.tuxyhavoc.recipes.book;

import java.util.List;

public interface CookeryBook {

	public void addRecipe(Recipe recipe);
	public void updateRecipe(Recipe recipe);
	public void deleteRecipe(Recipe recipe);
	
	public List<Recipe> getRecipes();
}