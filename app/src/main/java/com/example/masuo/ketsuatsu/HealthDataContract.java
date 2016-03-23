package com.example.masuo.ketsuatsu;

import android.provider.BaseColumns;

/**
 * Created by Masuo on 2016/03/20.
 */
public final class HealthDataContract {
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
}