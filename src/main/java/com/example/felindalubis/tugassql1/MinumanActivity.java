package com.example.felindalubis.tugassql1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.felindalubis.tugassql1.dbHelper.MinumanHelper;

import java.util.ArrayList;

public class MinumanActivity extends AppCompatActivity {
    private Button _add;
    private EditText _nama, _harga, _toko;
    private MinumanAdapter minumanAdapter;
    private MinumanHelper minumanHelper;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minuman_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        _nama = (EditText) findViewById(R.id.input_nama);
        _harga = (EditText) findViewById(R.id.input_harga);
        _toko = (EditText) findViewById(R.id.input_toko);
        _add = (Button) findViewById(R.id.add);

        minumanHelper = new MinumanHelper(this);
        minumanAdapter = new MinumanAdapter(this);
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
        minumanHelper.open();
        MinumanModel minuman = new MinumanModel(_nama.getText().toString(), _harga.getText().toString(), _toko.getText().toString());
        minumanHelper.insert(minuman);
        minumanHelper.close();
    }

    private void getAllData() {
        minumanHelper.open();
        ArrayList<MinumanModel> minumanModels = minumanHelper.getAllData();
        minumanHelper.close();
        minumanAdapter.addItem(minumanModels);
        recyclerView.setAdapter(minumanAdapter);
    }
}




