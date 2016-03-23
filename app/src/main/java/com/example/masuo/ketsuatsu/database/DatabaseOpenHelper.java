package com.example.masuo.ketsuatsu.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.masuo.ketsuatsu.HealthDataContract;

//import static com.example.masuo.ketsuatsu.HealthDataContract.*;

/**
 * Created by Masuo on 2016/03/20.
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "myhealth.db";
    static final int DATABASE_VERSION = 1;

     // SQL文の定義
    private static final String CREATE_TABLE =
            "create table " + HealthDataContract.DataEntry.TABLE_NAME +
                    " (" +
                    HealthDataContract.DataEntry._ID           + " integer primary key autoincrement," +
                    HealthDataContract.DataEntry.COL_RECTIME   + " text," +
                    HealthDataContract.DataEntry.COL_SYSTOLIC  + " integer," +
                    HealthDataContract.DataEntry.COL_DIASTOLIC + " integer," +
                    HealthDataContract.DataEntry.COL_PULSE     + " integer," +
                    HealthDataContract.DataEntry.COL_WEIGHT    + " text," +
                    HealthDataContract.DataEntry.COL_NOTES      + " text" +
                    " )";


    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // DB作成
        db.execSQL(CREATE_TABLE);




        // init
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


