package com.example.felindalubis.tugassql1.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.felindalubis.tugassql1.MinumanModel;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MinumanColumns.TOKO1;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MinumanColumns.NAMA1;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MinumanColumns.HARGA1;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.TABLE_MINUMAN;


public class MinumanHelper {

    private Context context;
    private DatabaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public MinumanHelper(Context context) {

        this.context = context;
    }

    public MinumanHelper open() throws SQLException {
        dataBaseHelper = new DatabaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {

        dataBaseHelper.close();
    }

    public ArrayList<MinumanModel> getAllData() {
        Cursor cursor = database.query(TABLE_MINUMAN, null, null, null, null, null, _ID + " DESC", null);
        cursor.moveToFirst();
        ArrayList<MinumanModel> arrayList = new ArrayList<>();
        MinumanModel minumanModel;
        if (cursor.getCount() > 0) {
            do {
                minumanModel = new MinumanModel();
                minumanModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                minumanModel.setNama(cursor.getString(cursor.getColumnIndexOrThrow(NAMA1)));
                minumanModel.setHarga(cursor.getString(cursor.getColumnIndexOrThrow(HARGA1)));
                minumanModel.setToko(cursor.getString(cursor.getColumnIndexOrThrow(TOKO1)));
                arrayList.add(minumanModel);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insert(MinumanModel minumanModel) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(NAMA1, minumanModel.getNama());
        initialValues.put(HARGA1, minumanModel.getHarga());
        initialValues.put(TOKO1, minumanModel.getToko());
        return database.insert(TABLE_MINUMAN, null, initialValues);
    }


    public int update(MinumanModel minumanModel) {
        ContentValues args = new ContentValues();
        args.put(NAMA1, minumanModel.getNama());
        args.put(HARGA1, minumanModel.getHarga());
        args.put(TOKO1, minumanModel.getToko());
        return database.update(TABLE_MINUMAN, args, _ID + "= '" + minumanModel.getId() + "'", null);
    }


    public int delete(int id) {
        return database.delete(TABLE_MINUMAN, _ID + " = '" + id + "'", null);
    }

}

