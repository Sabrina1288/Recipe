package de.tuxyhavoc.recipes;

import java.util.Date;

public interface Recipe {
	
	public Ingredient[] getIngredients();
	public String getName();
	public Date getCreationDate();
	public String[] getDirections();
	
}
