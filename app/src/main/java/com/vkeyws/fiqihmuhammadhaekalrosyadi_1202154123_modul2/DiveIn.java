package com.vkeyws.fiqihmuhammadhaekalrosyadi_1202154123_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DiveIn extends AppCompatActivity {
    Button Pesan;
    String[] mSpinnerlabel={"Meja 1","Meja2","Meja 3","Meja 4"};
    Spinner D;
    EditText Nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dive_in);

        Nama = (EditText)findViewById(R.id.editText);
        Pesan = (Button)findViewById(R.id.btnPesan);
        D = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DiveIn.this, android.R.layout.simple_spinner_dropdown_item,mSpinnerlabel);
        if (D !=null){
            D.setAdapter(adapter);
        }
        Pesan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String X = D.getSelectedItem().toString();
                String Z = Nama.getText().toString();
                if (X == null) {
                    Toast toast = Toast.makeText(DiveIn.this, "Pilih Meja Dahulu", Toast.LENGTH_LONG);
                    toast.show();
                }else if (Z.equals(null)){
                    Toast toast = Toast.makeText(DiveIn.this, "Isi Nama Dahulu!", Toast.LENGTH_LONG);
                    toast.show();
                }else {
                    Toast toast = Toast.makeText(DiveIn.this,X+" Telah Terpilih", Toast.LENGTH_LONG);
                    toast.show();
                    Intent intent = new Intent(DiveIn.this,Menu.class);
                    startActivity(intent);
                }
            }
        });
    }
}
