package com.finance.richard.financebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by richard on 7/30/2015.
 */
public class StudentDatabaseHelper {

    private DatabaseControllerCore databaseHelper;

    public StudentDatabaseHelper(Context context){
        databaseHelper = new DatabaseControllerCore(context);
    }

    public String insert(Purchase purchase){
        ContentValues record = purchaseToRecord(purchase);
        insertRecord(record);
        return purchase.toString();
    }

    private ContentValues purchaseToRecord(Purchase purchase){
        ContentValues record = new ContentValues();
        record.put(Purchase.COLUMN_PRICE, purchase.getName());
        record.put(Purchase.COLUMN_NAME, purchase.getPrice());
        return record;
    }

    private void insertRecord(ContentValues record){
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        database.insert(Purchase.TABLE, null, record);
        database.close();
    }



    private static class DatabaseControllerCore extends SQLiteOpenHelper{
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "FinanceBook.db";

        Context context;

        public DatabaseControllerCore(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(createTableQuery());
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(dropTableQuery());
            onCreate(sqLiteDatabase);
        }

        private String createTableQuery(){
            return
                    String.format("CREATE TABLE %s (%s TEXT NOT NULL, %s REAL NOT NULL)",
                            Purchase.TABLE, Purchase.COLUMN_NAME, Purchase.COLUMN_PRICE);
        }

        private String dropTableQuery(){
            return "DROP TABLE IF EXISTS " + Purchase.TABLE;
        }

    }


}
