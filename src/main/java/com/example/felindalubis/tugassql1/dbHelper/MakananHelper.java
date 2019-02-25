package com.example.felindalubis.tugassql1.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.felindalubis.tugassql1.MakananModel;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MakananColumns.HARGA;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MakananColumns.NAMA;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.MakananColumns.TOKO;
import static com.example.felindalubis.tugassql1.dbHelper.DatabaseContract.TABLE_MAKANAN;



public class MakananHelper {

    private Context context;
    private DatabaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public MakananHelper(Context context) {

        this.context = context;
    }

    public MakananHelper open() throws SQLException {
        dataBaseHelper = new DatabaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {

        dataBaseHelper.close();
    }

    public ArrayList<MakananModel> getAllData() {
        Cursor cursor = database.query(TABLE_MAKANAN, null, null, null, null, null, _ID + " DESC", null);
        cursor.moveToFirst();
        ArrayList<MakananModel> arrayList = new ArrayList<>();
        MakananModel makananModel;
        if (cursor.getCount() > 0) {
            do {
                makananModel = new MakananModel();
                makananModel.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                makananModel.setNama(cursor.getString(cursor.getColumnIndexOrThrow(NAMA)));
                makananModel.setHarga(cursor.getString(cursor.getColumnIndexOrThrow(HARGA)));
                makananModel.setToko(cursor.getString(cursor.getColumnIndexOrThrow(TOKO)));
                arrayList.add(makananModel);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insert(MakananModel makananModel) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(NAMA, makananModel.getNama());
        initialValues.put(HARGA, makananModel.getHarga());
        initialValues.put(TOKO, makananModel.getToko());
        return database.insert(TABLE_MAKANAN, null, initialValues);
    }


    public int update(MakananModel makananModel) {
        ContentValues args = new ContentValues();
        args.put(NAMA, makananModel.getNama());
        args.put(HARGA, makananModel.getHarga());
        args.put(TOKO, makananModel.getToko());
        return database.update(TABLE_MAKANAN, args, _ID + "= '" + makananModel.getId() + "'", null);
    }


    public int delete(int id) {
        return database.delete(TABLE_MAKANAN, _ID + " = '" + id + "'", null);
    }

}
