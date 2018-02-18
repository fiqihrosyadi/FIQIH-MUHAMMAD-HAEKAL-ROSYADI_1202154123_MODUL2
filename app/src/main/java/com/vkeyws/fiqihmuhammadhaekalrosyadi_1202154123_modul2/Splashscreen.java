package com.vkeyws.fiqihmuhammadhaekalrosyadi_1202154123_modul2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class Splashscreen extends AppCompatActivity {
    private static final int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(intent);

                Splashscreen.this.finish();
                Toast toast = Toast.makeText(Splashscreen.this, "FIQIH MUHAMMAD HAEKAL ROSYADI_1202154123", Toast.LENGTH_LONG);
                toast.show();
            }
        }, SPLASH_TIME);
    }

}
