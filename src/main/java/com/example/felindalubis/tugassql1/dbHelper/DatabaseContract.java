package com.example.felindalubis.tugassql1.dbHelper;

import android.provider.BaseColumns;

/**
 * Created by Komang Candra Brata on 2/13/2018.
 */

public class DatabaseContract {

    static String TABLE_MAKANAN = "table_makanan";
    static String TABLE_MINUMAN = "table_minuman";

    static final class MinumanColumns implements BaseColumns {
        static String NAMA1 = "nama";
        static String HARGA1 = "harga";
        static String TOKO1 = "toko";
    }

    static final class MakananColumns implements BaseColumns {
        static String NAMA = "nama";
        static String HARGA = "harga";
        static String TOKO = "toko";

    }
}