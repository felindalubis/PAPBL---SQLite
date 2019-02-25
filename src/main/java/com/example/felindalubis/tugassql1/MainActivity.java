package com.example.felindalubis.tugassql1;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button _makanan, _minuman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _makanan = (Button)findViewById(R.id.btnmakanan);
        _minuman = (Button)findViewById(R.id.btnminuman);

        _makanan.setOnClickListener(this);
        _minuman.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnmakanan){
            Intent intentObj = new Intent(this, MakananActivity.class);
            startActivity(intentObj);
        } else if(v.getId() == R.id.btnminuman){
            Intent intent = new Intent(this, MinumanActivity.class);
            startActivity(intent);
        }
    }

}
