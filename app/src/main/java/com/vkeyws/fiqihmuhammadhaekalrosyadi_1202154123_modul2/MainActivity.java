package com.vkeyws.fiqihmuhammadhaekalrosyadi_1202154123_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup A;
    RadioButton B, C;
    Button Pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pesan = (Button)findViewById(R.id.btnPesan);
        A = (RadioGroup)findViewById(R.id.Group);
        B = (RadioButton)findViewById(R.id.radioButton);
        C = (RadioButton)findViewById(R.id.radioButton2);
        Pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int select = A.getCheckedRadioButtonId();

                if (select == B.getId()){
                    Intent intent = new Intent(MainActivity.this, DiveIn.class);
                    startActivity(intent);
                    Toast toast = Toast.makeText(MainActivity.this, "Dine In", Toast.LENGTH_LONG);
                    toast.show();
                }else if (select == C.getId()){
                    Intent intent = new Intent(MainActivity.this, TakeAway.class);
                    startActivity(intent);
                    Toast toast = Toast.makeText(MainActivity.this, "Take Away", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
