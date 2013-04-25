package edu.umich.umd.dtmanager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import edu.umich.umd.dtmanager.Dwarf.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private final static String DEBUG_TAG = "DTMain";
	
	
	private GridLayout welcomeLayout;
	
	private boolean dwarvesLoaded;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewsByID();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	
	public void findViewsByID(){
		Log.d(DEBUG_TAG, "Finding Views By ID");
		welcomeLayout = (GridLayout)findViewById(R.id.welcome_grid);
		ViewTreeObserver vto = welcomeLayout.getViewTreeObserver();
		Log.d(DEBUG_TAG, "Adding OnGlobalLayoutListener");
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				GridLayout gl = (GridLayout)findViewById(R.id.welcome_grid);
				fillView(gl);
				
				ViewTreeObserver obs = gl.getViewTreeObserver();
				obs.removeOnGlobalLayoutListener(this);
				
				gl.invalidate();
				
			}
		});
		
	}
	
	/***
	 * Resize views within Welcome Grid to fill the screen for a prettier UI
	 * 
	 * @param gl Welcome Grid to restructure
	 */
	public void fillView(GridLayout gl) {
		Button bt;
		View v;
		
		// Get GridLayout dimensions
		int glWidth = gl.getWidth();
		int glHeight = gl.getHeight();
		
		// Get GridLayout row and column properties;
		int glNumCol = gl.getColumnCount();
		int glNumRow = gl.getRowCount();
		
		// Setup margins
		int widthMargins = 10;
		int heightMargins = 10;
		
		int glColWidth = (int) (glWidth - widthMargins) / glNumCol;
		int glRowHeight = (int) (glHeight - heightMargins) / glNumRow;
		
		// Desired button width and height relative to screen size;
		int btnHeight = 1 * glRowHeight;
		int btnWidth = 6 * glColWidth;
		
		for(int i = 0; i < gl.getChildCount(); i++) {
			v = (View) gl.getChildAt(i);
			
			Log.d(DEBUG_TAG, "Checking child:" + i + " for tag");
			if(v.getTag() != null){
				// Check View for button tag
				String tagString = (String)v.getTag();
				if(tagString.equals("button_view")){
					// Cast view to button
					bt = (Button)v;
					// Set button width and height
					bt.setWidth(btnWidth);
					bt.setHeight(btnHeight);
				}
			}
		}
	}

	/**
	 * Switch to the Dwarf Log Viewing Activity when the "View Dwarf Logs"
	 * button is clicked
	 * @param v The view that initiated the switch of activities
	 * @throws IOException 
	 * @throws XmlPullParserException 
	 */
	public void viewDwarfLogs(View v) throws IOException, XmlPullParserException {
		
		DwarfXmlParser p = new DwarfXmlParser();
		AssetManager am = getApplicationContext().getAssets();
		InputStream fs = am.open("dwarves.txt");
		
		ArrayList<Dwarf> dwarfList = p.parse(fs);
		DwarfContainer.dwarf_list = dwarfList;
		DwarfContainer.genNameList();
		dwarvesLoaded = true;
		
		Intent vwDwarfLogs = new Intent(this,DwarfListActivity.class);
		vwDwarfLogs.putParcelableArrayListExtra("Dwarves", dwarfList);
		startActivity(vwDwarfLogs);
	}
	
	public void exportDwarves(View v) {
		
		if(dwarvesLoaded){
			SQLHandler db = new SQLHandler(this);
			
			for(Dwarf d: DwarfContainer.dwarf_list)
			{
				db.addDwarf(d);
			}
			Log.d(DEBUG_TAG, "Loading Database");
			CharSequence text = "Dwarves added to Database successfully";
			Toast dLoaded = Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG);
			dLoaded.show();
			
		}else {
			Log.d(DEBUG_TAG,"Database Not Loaded");
			CharSequence text = "No Connection Found: Dwarf Data Not Loaded";
			Toast dNotLoaded = Toast.makeText(getBaseContext(), text, Toast.LENGTH_SHORT);
			dNotLoaded.show();
		}
	}
}
