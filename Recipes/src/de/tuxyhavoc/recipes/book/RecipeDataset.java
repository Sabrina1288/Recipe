package de.tuxyhavoc.recipes.book;

import java.util.Date;

public class RecipeDataset implements Recipe {

	private int recipeNumber;
	private String name;
	private Date creationDate;
	
	public void setId(int recipeNumber) {
		this.recipeNumber = recipeNumber;
	}

	public void setCreationDate(Date date) {
		creationDate = date;
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
		return name + " " + creationDate;
	}

	@Override
	public String getDate() {
		return creationDate.toString();
	}

	@Override
	public int getId() {
		return recipeNumber;
	}
	
}
