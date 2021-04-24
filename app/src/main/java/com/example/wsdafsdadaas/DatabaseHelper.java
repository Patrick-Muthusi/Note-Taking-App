package com.example.wsdafsdadaas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    //Table Name
    public static final String TABLE_NAME = "COUNTRIES";

    //Table columns.
    public static final String _ID= "_id";
    public static final String SUBJECT= "subject";
    public static final String DESC= "description";


    //Database Information
    static final String DB_NAME= "MASTER_ANDROID_APP.DB";

    //Database version
    static final int DB_VERSION= 1;

    //Creating Table Querry.
    private static final String CREATE_TABLE ="create table "+
            TABLE_NAME+ "(" + _ID
            +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ SUBJECT +
            " TEXT NOT NULL, " + DESC+ " TEXT);";

    //Constructours.
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
    }
}
