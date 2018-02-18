package com.vkeyws.fiqihmuhammadhaekalrosyadi_1202154123_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //menerima value yang dikirimkan dari activity sebelumnya berupa sebuah key value
        String menu = getIntent().getStringExtra("menu");
        String price = getIntent().getStringExtra("price");
        String komposisi = getIntent().getStringExtra("komposisi");
        Integer image = getIntent().getIntExtra("image", 0);

        //mendifinisikan TextView dan ImageView dengan id
        TextView txtMenu = findViewById(R.id.namaMenu);
        TextView txtPrice = findViewById(R.id.price);
        TextView txtkomposisi = findViewById(R.id.listkomposisi);
        ImageView images = findViewById(R.id.imageMenu);

        //mengeset valuenya
        txtMenu.setText(menu);
        txtPrice.setText("Price Rp: "+price);
        txtkomposisi.setText(komposisi);
        images.setImageResource(image);
    }
    @Override
    public boolean onSupportNavigateUp() {
        //function ketika button back di klik maka akan kembali ke view sebelumnya
        onBackPressed();
        return true;
    }
}
