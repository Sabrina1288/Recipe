package de.tuxyhavoc.recipes;

public interface CookeryBook {

	public void addRecipe(Recipe recipe);
	public void updateRecipe(Recipe recipe);
	public void deleteRecipe(Recipe recipe);
	
	public Recipe[] getRecipes();
}