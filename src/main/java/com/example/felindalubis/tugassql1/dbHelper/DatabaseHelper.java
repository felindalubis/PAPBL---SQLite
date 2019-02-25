package com.example.felindalubis.tugassql1.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MakananColumns.HARGA;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MakananColumns.NAMA;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MakananColumns.TOKO;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MinumanColumns.TOKO1;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MinumanColumns.NAMA1;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MinumanColumns.HARGA1;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.TABLE_MAKANAN;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.TABLE_MINUMAN;


/**
 * Created by Komang Candra Brata
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "dbmenukantin";

    public static String CREATE_TABLE_MAKANAN = "create table " + TABLE_MAKANAN +
            " (" + _ID + " integer primary key autoincrement, " +
            NAMA + " text not null, " +
            HARGA + " text not null, " +
            TOKO + " text not null);";

    public static String CREATE_TABLE_MINUMAN = "create table " + TABLE_MINUMAN +
            " (" + _ID + " integer primary key autoincrement, " +
            NAMA1 + " text not null, " +
            HARGA1 + " text not null, " +
            TOKO1 + " text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAKANAN);
        db.execSQL(CREATE_TABLE_MINUMAN);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAKANAN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MINUMAN);
        onCreate(db);
    }


}
