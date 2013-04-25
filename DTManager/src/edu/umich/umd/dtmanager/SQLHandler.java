package edu.umich.umd.dtmanager;

import java.util.List;

import edu.umich.umd.dtmanager.Dwarf.Dwarf;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLHandler extends SQLiteOpenHelper {

	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "dwarfDatabase";
 
    // Contacts table name
    private static final String TABLE_DWARFS = "dwarfs";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
	private static final String KEY_nickname = "nickname";
	private static final String KEY_sex = "sex";
	private static final String KEY_age = "age";
	
	private static final String KEY_strength = "strength";
	private static final String KEY_agility = "agility";
	private static final String KEY_toughness = "toughness";
	private static final String KEY_endurance = "endurance";
	private static final String KEY_recuperation = "recuperation";
	private static final String KEY_diseaseResistance = "diseaseResistance";
    
    public SQLHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
 
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_DWARFS_TABLE = "CREATE TABLE " + TABLE_DWARFS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY ," + KEY_NAME + " TEXT,"
				+ KEY_nickname + " TEXT," + KEY_sex + " TEXT,"
				+ KEY_age + " INTEGER," + KEY_strength + " INTEGER,"
				+ KEY_agility + " INTEGER," + KEY_toughness + " INTEGER,"
				+ KEY_endurance + " INTEGER," + KEY_recuperation + " INTEGER,"
				+ KEY_diseaseResistance + " INTEGER" + ")";
		Log.d(CREATE_DWARFS_TABLE, "Creating Table");
		db.execSQL(CREATE_DWARFS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DWARFS);
 
        // Create tables again
        onCreate(db);

	}
	
	public void addDwarf(Dwarf d) {
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, d.getName());
		values.put(KEY_age, d.getAge());
		values.put(KEY_agility, d.getAgility());
		values.put(KEY_diseaseResistance, d.getDiseaseResistance());
		values.put(KEY_endurance, d.getEndurance());
		values.put(KEY_nickname, d.getNickName());
		values.put(KEY_recuperation, d.getRecuperation());
		values.put(KEY_sex, d.getSex());
		values.put(KEY_strength, d.getStrength());
		values.put(KEY_toughness, d.getToughness());
		
		db.insert(TABLE_DWARFS, null, values);
	}
	
	public void getDwarf(Dwarf d) {
		
	}
	
	public List<Dwarf> getAllDwarfs() {
		return null;
		
	}
	
	public int updateDwarf(Dwarf d){
		return 0;
		
	}
	
	public void deleteDwarf(Dwarf d) {
		
	}
}
