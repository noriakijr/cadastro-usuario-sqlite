package com.noriaki.crudsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Noriaki on 27/01/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CRUD_SIMPLES";
    private static final int DATABASE_VERSION = 3;

    private static final String USER_TABLE_NAME = "USUARIO";
    private static final String USER_TABLE_CREATE = "CREATE TABLE " + USER_TABLE_NAME
            + " (_ID integer primary key autoincrement, "
            + "NOME TEXT, "
            + "LOGIN TEXT, "
            + "SENHA TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        super(context, Environment.getExternalStorageDirectory().getAbsolutePath()                // armazenar externamente
//                + "/nome-da-aplicacao/database/" + DATABASE_NAME, null, DATABASE_VERSION);    
	}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);
        System.out.println("onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE USUARIO");
        onCreate(db);
        System.out.println("onUpgrade. oldVersion: " + oldVersion + ". newVersion: " + newVersion);
    }
}
