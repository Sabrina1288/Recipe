package de.tuxyhavoc.recipes;

import java.text.SimpleDateFormat;

public class RecipeDataset implements Recipe {

	private int recipeNumber;
	private String name;
	private SimpleDateFormat creationDate;
	
	public void setId(int recipeNumber) {
		this.recipeNumber = recipeNumber;
	}

	public void setCreationDate(SimpleDateFormat dateFormat) {
		creationDate = dateFormat;
	}

	@Override
	public void setName(String name) {
		this.name = name;		
	}

	@Override
	public String getName() {
		return name;
	}

	public String toString(){
		return name;
	}
	
}
