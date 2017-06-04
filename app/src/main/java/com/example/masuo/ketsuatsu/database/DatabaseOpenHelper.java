package com.example.masuo.ketsuatsu.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.masuo.ketsuatsu.HealthDataContract;

/**
 * Created by Masuo on 2016/03/20.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public DatabaseOpenHelper(Context context) {
        super(context, HealthDataContract.DATABASE_NAME, null, HealthDataContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // DB作成
        db.execSQL(HealthDataContract.CREATE_TABLE);

        // init
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(HealthDataContract.DELETE_TABLE);
        onCreate(db);
    }

}


