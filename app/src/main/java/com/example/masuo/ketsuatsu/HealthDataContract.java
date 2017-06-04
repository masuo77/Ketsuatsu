package com.example.masuo.ketsuatsu;

import android.provider.BaseColumns;

/**
 * Created by Masuo on 2016/03/20.
 */
public final class HealthDataContract {

    public static final String DATABASE_NAME = "myhealth.db";
    public static final int DATABASE_VERSION = 1;

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty private constructor.
    private HealthDataContract() {}

    /* Inner class that defines the table contents */
    public static abstract class DataEntry implements BaseColumns {
        public static final String TABLE_NAME = "health";

        public static final String COL_RECTIME = "rectime";
        public static final String COL_SYSTOLIC = "systolic";
        public static final String COL_DIASTOLIC = "diastolic";
        public static final String COL_PULSE = "pulse";
        public static final String COL_WEIGHT = "weight";
        public static final String COL_NOTES = "note";
        public static final String COL_USE = "use";
    }

    // SQL文の定義
    public static final String CREATE_TABLE =
            "create table " + HealthDataContract.DataEntry.TABLE_NAME +
                    " (" +
                    DataEntry._ID           + " integer primary key autoincrement," +
                    DataEntry.COL_RECTIME   + " text," +
                    DataEntry.COL_SYSTOLIC  + " integer," +
                    DataEntry.COL_DIASTOLIC + " integer," +
                    DataEntry.COL_PULSE     + " integer," +
                    DataEntry.COL_WEIGHT    + " text," +
                    DataEntry.COL_NOTES     + " text" +
                    " )";

    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + DataEntry.TABLE_NAME;
}