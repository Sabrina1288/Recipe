package de.tuxyhavoc.recipes.book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import android.database.Cursor;

public class TableRecipeIterator implements Iterator<RecipeDataset> {

	private Cursor cursor;
	private SimpleDateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-d HH:mm:ss");
	
	
	public TableRecipeIterator(Cursor cursor){
		this.cursor = cursor;
		cursor.moveToFirst();
	}
	
	@Override
	public boolean hasNext() {
		boolean hasNextIfNotAfterLast = !cursor.isAfterLast();
		return hasNextIfNotAfterLast;
	}

	@Override
	public RecipeDataset next() {

		RecipeDataset recipe = new RecipeDataset();
		
		recipe.setId(cursor.getInt(0));
		recipe.setName(cursor.getString(1));		
		String dateString = cursor.getString(2);
		
		try {
			recipe.setCreationDate(dateFormat.parse(dateString));
		} catch (ParseException e) {
			recipe.setCreationDate(new Date());
		}
		
		cursor.moveToNext();
		
		return recipe;
	}

	@Override
	public void remove() {
		/* NOT USED */		
	}

}
