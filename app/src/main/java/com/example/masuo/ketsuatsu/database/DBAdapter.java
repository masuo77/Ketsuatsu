package com.example.masuo.ketsuatsu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.masuo.ketsuatsu.HealthData;
import com.example.masuo.ketsuatsu.HealthDataContract;

//import static com.example.masuo.ketsuatsu.HealthDataContract.*;

/**
 * Created by Masuo on 2016/03/21.
 */
public class DBAdapter {

    static final String DATABASE_NAME = "myhealth.db";

    private SQLiteDatabase db = null;           // SQLiteDatabase
    private DatabaseOpenHelper dbHelper = null; // DBHelper
    protected Context context;                  // Context

    // コンストラクタ
    public DBAdapter(Context context) {
        this.context = context;
        dbHelper = new DatabaseOpenHelper(this.context);
    }

    /**
     * DBの読み書き
     * openDB()
     *
     * @return this 自身のオブジェクト
     */
    public DBAdapter openDB() {
        db = dbHelper.getWritableDatabase();        // DBの読み書き
        return this;
    }

    /**
     * DBの読み込み
     * readDB()
     *
     * @return this 自身のオブジェクト
     */
    public DBAdapter readDB() {
        db = dbHelper.getReadableDatabase();        // DBの読み込みオープン
        return this;
    }

    /**
     * DBを閉じる
     * closeDB()
     */
    public void closeDB() {
        db.close();     // DBを閉じる
        db = null;
    }

    /**
     * DBのレコードへ登録
     * saveDB()
     *
     */
    public void saveDB(HealthData healthData) {

        db.beginTransaction();          // トランザクション開始

        try {
            ContentValues values = new ContentValues();     // ContentValuesでデータを設定していく
            values.put(HealthDataContract.DataEntry.COL_RECTIME, healthData.getRecTime());
            values.put(HealthDataContract.DataEntry.COL_SYSTOLIC, healthData.getSystolic());
            values.put(HealthDataContract.DataEntry.COL_DIASTOLIC, healthData.getDiastolic());
            values.put(HealthDataContract.DataEntry.COL_WEIGHT, healthData.getWeight());
            values.put(HealthDataContract.DataEntry.COL_NOTES, healthData.getNotes());
            values.put(HealthDataContract.DataEntry.COL_USE, healthData.isUse() ? 1 : 0);

            // insertメソッド データ登録
            // 第1引数：DBのテーブル名
            // 第2引数：更新する条件式
            // 第3引数：ContentValues
            db.insert(DATABASE_NAME, null, values);      // レコードへ登録

            db.setTransactionSuccessful();      // トランザクションへコミット
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();                // トランザクションの終了
        }
    }



    private static class DatabaseOpenHelper extends SQLiteOpenHelper {

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
                        HealthDataContract.DataEntry.COL_NOTES     + " text" +
                        HealthDataContract.DataEntry.COL_USE       + " integer" +
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















}
