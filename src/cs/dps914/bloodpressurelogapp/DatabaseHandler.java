package cs.dps914.bloodpressurelogapp;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "BloodPressureInformation";
 
    // Data table name
    private static final String TABLE_DATA = "BloodPressureData";
 
    // Data Table Column names
    private static final String KEY_ID = "dataId";
    private static final String KEY_SYSTOLIC = "systolic";
    private static final String KEY_DIASTOLIC = "diastolic";
    private static final String KEY_HEARTRATE = "heartrate";
    private static final String KEY_DATESTORED = "datestored";
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_DATA_TABLE = "CREATE TABLE " + TABLE_DATA + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
        		+ KEY_SYSTOLIC + " INTEGER,"
                + KEY_DIASTOLIC + " INTEGER," 
        		+ KEY_HEARTRATE + " INTEGER,"  
                + KEY_DATESTORED + " TEXT" + ")";
        db.execSQL(CREATE_DATA_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA);
 
        // Create tables again
        onCreate(db);
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    // Adding new data
    public void addData(Data data) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_SYSTOLIC, data.getSystolic()); // Systolic value
        values.put(KEY_DIASTOLIC, data.getDiastolic()); // Diastolic value
        values.put(KEY_HEARTRATE, data.getHeartRate()); // Heart rate value
        values.put(KEY_DATESTORED, data.getDateStored()); // Date value
 
        // Inserting Row
        db.insert(TABLE_DATA, null, values);
        db.close(); // Closing database connection
    }
 
    // Getting single data
    public Data getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_DATA, new String[] { KEY_ID,
                KEY_SYSTOLIC, KEY_DIASTOLIC, KEY_HEARTRATE, KEY_DATESTORED }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        Data data = new Data(
        		Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(1)), 
                Integer.parseInt(cursor.getString(2)), 
                Integer.parseInt(cursor.getString(3)),
                DateTime.parse(cursor.getString(4))); 
                
        // return Data
        return data;
    }
 
    // Getting All data
    public List<Data> getAllData() {
        List<Data> dataList = new ArrayList<Data>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DATA;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Data data = new Data();
                data.setID(Integer.parseInt(cursor.getString(0)));
                data.setSystolic(Integer.parseInt(cursor.getString(1)));
                data.setDiastolic(Integer.parseInt(cursor.getString(2)));
                data.setHeartRate(Integer.parseInt(cursor.getString(3)));
                data.setDateStored(DateTime.parse(cursor.getString(4)));
                // Adding data to list
                dataList.add(data);
            } while (cursor.moveToNext());
        }
 
        // return data list
        return dataList;
    }
 
    // Updating single data
    public int updateData(Data data) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(KEY_SYSTOLIC, data.getSystolic());
        values.put(KEY_DIASTOLIC, data.getDiastolic());
        values.put(KEY_HEARTRATE, data.getHeartRate());
        values.put(KEY_DATESTORED, data.getDateStored()); // Date stored value
 
        // updating row
        return db.update(TABLE_DATA, values, KEY_ID + " = ?",
                new String[] { String.valueOf(data.getID()) });
    }
 
    // Deleting single data
    public void deleteData(Data data) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DATA, KEY_ID + " = ?",
                new String[] { String.valueOf(data.getID()) });
        db.close();
    }
 
    // Getting data Count
    public int getDataCount() {
        String countQuery = "SELECT  * FROM " + TABLE_DATA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
 
}