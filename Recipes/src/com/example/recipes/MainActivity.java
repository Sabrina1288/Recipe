package com.example.recipes;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SQLiteDatabase db;
		db = openOrCreateDatabase("TestingData.db",
				SQLiteDatabase.CREATE_IF_NECESSARY, null);
		db.setVersion(1);
		db.setLocale(Locale.getDefault());
		
		
		//Create Table RECIPE
		final String CREATE_TABLE_RECIPES =
	            "CREATE TABLE tbl_recipes ("
	            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
	            + "recipes_name TEXT);";

		//Create Table INGREDIENTS
		final String CREATE_TABLE_INGREDIENTS =
	            "CREATE TABLE tbl_ingredients ("
	            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
	            + "ingredients_name TEXT);";
		
		//Create Table INGREDIENTS
				final String CREATE_TABLE_REC_HAS_INGR =
			            "CREATE TABLE tbl_ingredients ("
			            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
			            + "recipes_id REFERENCES tbl_recipes(id) "
		        		+ "ingredients_id REFERENCES tbl_ingredients(id);";
							
		
		
		//Execute Create table
		db.execSQL(CREATE_TABLE_RECIPES);
		db.execSQL(CREATE_TABLE_INGREDIENTS);
		db.execSQL(CREATE_TABLE_REC_HAS_INGR);
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
