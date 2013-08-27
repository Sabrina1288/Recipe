package com.example.recipes;

import java.util.List;

import de.tuxyhavoc.recipes.CookeryBook;
import de.tuxyhavoc.recipes.CookeryBookImpl;
import de.tuxyhavoc.recipes.Recipe;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity implements OnClickListener {

	CookeryBook cookeryBook;
	//ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		deleteDatabase("recipes.db");
		
		setContentView(R.layout.activity_main);
		
		Button button = (Button)findViewById(R.id.StartButton);
		
		button.setOnClickListener(this);
		
		
		/*
		System.out.println("Fetching recipes");
		List<Recipe> recipes = cookeryBook.getRecipes();
		
		for(Recipe recipe : recipes){
			System.out.println(recipe.getName());
		}
		
		listView = (ListView)findViewById(R.id.list);
		
		@SuppressWarnings("unchecked")
		ArrayAdapter<Recipe> adapter = (ArrayAdapter<Recipe>)listView.getAdapter();
		for(Recipe recipe : recipes)
			adapter.add(recipe);
			*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Log.e("some Log", "some Log");
		cookeryBook = new CookeryBookImpl(this);
		
	}

}
