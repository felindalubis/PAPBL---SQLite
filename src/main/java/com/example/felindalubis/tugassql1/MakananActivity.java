package com.example.felindalubis.tugassql1;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.felindalubis.tugassql1.dbHelper.MakananHelper;

import java.util.ArrayList;

public class MakananActivity extends AppCompatActivity {
    private Button _add;
    private EditText _nama, _harga, _toko;
    private MakananAdapter makananAdapter;
    private MakananHelper makananHelper;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makanan_layout);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        _nama = (EditText) findViewById(R.id.input_nama);
        _harga = (EditText) findViewById(R.id.input_harga);
        _toko = (EditText) findViewById(R.id.input_toko);
        _add = (Button) findViewById(R.id.add);

        makananHelper = new MakananHelper(this);
        makananAdapter = new MakananAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getAllData();
        _add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (_add.getText().equals("update")) {


                } else {
                    insertData();
                    getAllData();
                }
            }
        });
    }



    private void insertData() {
        makananHelper.open();
        MakananModel makanan = new MakananModel(_nama.getText().toString(), _harga.getText().toString(), _toko.getText().toString());
        makananHelper.insert(makanan);
        makananHelper.close();
    }

    private void getAllData() {
        makananHelper.open();
        ArrayList<MakananModel> makananModels = makananHelper.getAllData();
        makananHelper.close();
        makananAdapter.addItem(makananModels);
        recyclerView.setAdapter(makananAdapter);
    }

}
